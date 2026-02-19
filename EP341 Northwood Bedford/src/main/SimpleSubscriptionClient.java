package main;

/*
 * Project, Building, Author
 */

/*
 * Changelog
 * V1 first version.
 * V2 Better function when a device is offline.
 * V3 Better handling when the number of devices is more than 5.
 * V3.1 Bug fix, Added code for updating pdb with a Fahrenheit to Celcius scaled value that was lost.
 * V3.2 Added read only setting to Fahrenheit<->Celcius scaler.
 * V3.3 Modified loop time. Could increase with the number of devices.
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.serotonin.bacnet4j.LocalDevice;
import com.serotonin.bacnet4j.RemoteDevice;
import com.serotonin.bacnet4j.exception.BACnetException;
import com.serotonin.bacnet4j.npdu.ip.IpNetwork;
import com.serotonin.bacnet4j.npdu.ip.IpNetworkBuilder;
import com.serotonin.bacnet4j.npdu.ip.IpNetworkUtils;
import com.serotonin.bacnet4j.service.acknowledgement.AcknowledgementService;
import com.serotonin.bacnet4j.service.confirmed.ConfirmedRequestService;
import com.serotonin.bacnet4j.service.unconfirmed.WhoIsRequest;
import com.serotonin.bacnet4j.transport.DefaultTransport;
import com.serotonin.bacnet4j.type.constructed.Address;
import com.serotonin.bacnet4j.type.enumerated.PropertyIdentifier;
import com.serotonin.bacnet4j.util.DiscoveryUtils;
import com.serotonin.bacnet4j.util.PropertyReferences;
import com.serotonin.bacnet4j.util.PropertyValues;
import com.serotonin.bacnet4j.util.RemoteDeviceDiscoverer;
import com.serotonin.bacnet4j.util.RequestUtils;
import pointconfig.*;
import pdb.PDBf;
import pdb.PDBi;
import pdb.Pdb;
import pdb.PdbInterface;
//import pdb.mock.PdbMock;

public class SimpleSubscriptionClient {
	final static Logger logger = LoggerFactory.getLogger(SimpleSubscriptionClient.class);
	public static void main(String[] args) throws Exception {
		
		final List<RemoteDevice> allDevices = new ArrayList<>();
	    final Queue<RemoteDevice> latestDevices = new LinkedList<>();
	    PdbInterface pdb = new Pdb("/usr/local/bin/modbus");
		//PdbInterface pdb = new PdbMock();
	    
    	
    	LocalDevice localDevice = null;
    	final ArrayList<PointManager> deviceManagers = new ArrayList<>();
    	
    	//Add devices here by entering the BACnet device ID
    	deviceManagers.add(new PointManager(111, pdb, ddc01.points(pdb)));//
    	deviceManagers.add(new PointManager(12346, pdb, ddc02.points(pdb)));//
    	
    	
    	
    	logger.info("Starting");
    	long timeLastDeviceConfigured = 0;
    	try {
    		
    		IpNetworkBuilder networkBuilder = new IpNetworkBuilder();
    		networkBuilder
    			//.withSubnet("192.168.2.0", 24)//LAN, Network Address
    			.withSubnet("192.168.30.0", 24)//WAN, Network Address
    			.withPort(0xBAC0)//BACnet port
    			.withLocalNetworkNumber(1);//BACnet network number
    		IpNetwork network = networkBuilder.build(); 
    		
    		System.err.println("Local device configured");
    		localDevice = new LocalDevice(12345, new DefaultTransport(network));//WDC BACnet device id
    		logger.info("Local device created");
    		
    		localDevice.initialize();
    		logger.info("Local device initialized");
    		
    		//Start discovery
    		localDevice.startRemoteDeviceDiscovery();
    		logger.info("Sent discovery will wait 60seconds for respones");
    		Thread.sleep(60000);
    		
    		//Debug
    	    long loopCounter = 0;
    	    long startTime = 0;
    	    long lastDiscoverTime = 0;
    		
        	while(true) {
        		
        		loopCounter++;
        		startTime = System.currentTimeMillis();
        		
        		if (loopCounter < 5 || (startTime - lastDiscoverTime) > 10*60*1000) {
            			localDevice.sendGlobalBroadcast(new WhoIsRequest());
            			logger.info("Sending new WhoIs request");
            			lastDiscoverTime = startTime;
            			//Thread.sleep(15000);
            		}
        		        		
        		//Fetch discovered devices
        		for (RemoteDevice rd : localDevice.getRemoteDevices()) {
        
        			if (!allDevices.contains(rd) && deviceManagers.stream().anyMatch((pm) -> pm.getRemoteDeviceIdentifier() == rd.getInstanceNumber())) {
        				//Add to device list
        				allDevices.add(rd);
						//Add to latest discovered
        				latestDevices.add(rd);
        				logger.info("Found new device {}", rd.getInstanceNumber());
					}
				}

        		//Pop device from latest discovered
        		while (!latestDevices.isEmpty()) {
        			//Pop device from the discovery list

        			RemoteDevice rd = latestDevices.poll();
        			logger.info("Found new device {}", rd.toString());
        			// Prepare device
        			localDevice.getRemoteDeviceBlocking(rd.getInstanceNumber());
        			//Get extended info
        			boolean success = false;
        			try {
        				DiscoveryUtils.getExtendedDeviceInformation(localDevice, rd);
        				Thread.sleep(5000);
        				//Get device object list
        				final PropertyReferences propRefs = new PropertyReferences() //
        	                    .add(rd.getObjectIdentifier(), PropertyIdentifier.objectList);
        				final PropertyValues actualValues = RequestUtils.readProperties(localDevice, rd, propRefs, false, null);
        				logger.trace("Device object {} list count: {}", rd.getInstanceNumber(), actualValues.toString().split(",").length);
        				success = true;
					} catch (BACnetException e) {
						success = false;
					}
        			
        			if (success) {
        				logger.info("Successfully identified device: {}", rd.getInstanceNumber());
        				for (PointManager pointManager : deviceManagers) {
							if (!pointManager.isConfigured() && pointManager.getRemoteDeviceIdentifier() == rd.getInstanceNumber()) {
								pointManager.setLocalDevice(localDevice);
								pointManager.setRemoteDevice(rd);
								if (pointManager.isConfigured()) {
									timeLastDeviceConfigured = System.currentTimeMillis();
									logger.info("Paired device: {} with pointManger: {}", rd.getInstanceNumber(), pointManager.toString());
									pointManager.run();
								} else {
									logger.error("Failed to pair device: {} with pointManger: {}", rd.getInstanceNumber(), pointManager.toString());
								}
								
								
							}
						}
        			} else {
        				// Check if unreachable device in our list of interest, if so reschedule it
        				if (deviceManagers.stream().anyMatch((pm) -> pm.getRemoteDeviceIdentifier() == rd.getInstanceNumber() )) {
        					latestDevices.add(rd);
        					logger.debug("Could not add device: {} Readded for retry", rd.getInstanceNumber());
        				} else {
        					logger.debug("Could not add device: {} Discarded because not in list of devices of intrerest",
        							rd.getInstanceNumber());
        				}
        			}
        		}

        		for (PointManager pointManager : deviceManagers) {
        			if (pointManager.isConfigured()) {
            			pointManager.run();
            			//Thread.sleep(2500);
        			}
				}
        		
        		final ArrayList<PointManager> unConfiguredDevices = deviceManagers
        				.stream()
        				.filter(pm -> !pm.isConfigured())
        				.collect(Collectors.toCollection(ArrayList::new));
        		
        		logger.info("Unconfigured devices: {} Count: {}",
        				unConfiguredDevices.size() > 0 ? unConfiguredDevices.stream().map((pm)-> pm.getRemoteDeviceIdentifier() + ", ") : "none",
        				unConfiguredDevices.size()
        		);
        		
        		if (loopCounter % 1 == 0 ) {
        			logger.debug("Loopcounter: {}, LoopTime: {}, Number of devices {}",
        					loopCounter,
        					(System.currentTimeMillis() - startTime),
        					deviceManagers
            					.stream()
            					.filter(pm -> pm.isConfigured())
            					.collect(Collectors.toCollection(ArrayList::new))
            					.size()
            		);
        		}
        		
        		Thread.sleep(1000);//Loop time
        	}
        }
    	
    	catch (Exception e) {
                	System.err.println("Exception caught in main:");
                	e.printStackTrace();
        }
        catch(Throwable e) {
        	System.err.println("Throwable caught in main:");
            e.printStackTrace();
        }
        finally {
        	if (localDevice != null)
        		// Unsubscribe
        		for (PointManager pM : deviceManagers) {
        			if (pM.isConfigured()) {
        				pM.unSubscribe();
				}
                localDevice.terminate();
                }
        }
    }
    public static AcknowledgementService send(LocalDevice d, ConfirmedRequestService s) throws Exception {
        Address a = IpNetworkUtils.toAddress("localhost", 0xbac0);
        return d.send(a, s).get();
    }
}