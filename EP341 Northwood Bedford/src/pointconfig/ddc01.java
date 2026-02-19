package pointconfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.serotonin.bacnet4j.type.enumerated.ObjectType;
import com.serotonin.bacnet4j.type.primitive.ObjectIdentifier;

import main.PointConnnectionContainer;
import pdb.PdbException;
import pdb.PdbInterface;

import main.FahrenheitCelsiusScaler;
import main.OffsetFahrenheitCelsiusScaler;
import main.Scaler;
import pdb.MultiStateTranslation;
import pdb.MultiStateValue;
import pdb.PDBb;


public class ddc01 {

public static List<PointConnnectionContainer> points(PdbInterface pdb) throws PdbException {
	List<PointConnnectionContainer> pointList = new ArrayList<PointConnnectionContainer>();
	
	
	MultiStateTranslation msTranslation1 =  new MultiStateTranslation(Arrays.asList(
			new MultiStateValue(999, "Auto", 2, "Auto"),
			new MultiStateValue(0, "Off", 0, "Off"),
			new MultiStateValue(1, "On", 1, "On")
	));

	
	/*
	MultiStateTranslation msTranslation2 =  new MultiStateTranslation(Arrays.asList(
			new MultiStateValue(0, "Off", 1, "Off"),
			new MultiStateValue(1, "On", 2, "On")
	));
	*/
	
	/*
	MultiStateTranslation msTranslation3 =  new MultiStateTranslation(Arrays.asList(
			new MultiStateValue(2, "Pump2", 4, "P2"),
			new MultiStateValue(1, "Pump1", 3, "P1"),
			new MultiStateValue(0, "Off", 2, "Off"),
			new MultiStateValue(999, "Auto", 1, "Automatic")
	));
	*/
	
	//Scaler scalerCF = new FahrenheitCelsiusScaler();
	//Scaler scalerCFdsp = new OffsetFahrenheitCelsiusScaler();
		
	//PDBb system = new PDBb("system", "System, Description");
	//BACnet points
	
	//HS01 Heating System
	pointList.add(new PointConnnectionContainer(pdb.createMultiState("hs01.heatpump01.osw","EcoPilot Control Point ",msTranslation1), new ObjectIdentifier(ObjectType.analogValue, 0)));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hs01.ecomode.cm","Eco Mode 0=OFF 1=ON 2=BAS", ""), new ObjectIdentifier(ObjectType.analogValue, 0),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hs01.suptempcont01.sp","AEM Boiler Supply Water Setpoint ","C"), new ObjectIdentifier(ObjectType.analogInput, 0),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hs01.suptempcont01.cm","Boiler Supply Water Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 3),true));
	//pointList.add(new PointConnnectionContainer(pdb.createFloat("hs01.rettemp01.cm","Boiler Return Water Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 4),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hs01.suptempcont01.ms","Boiler Return Water Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 4),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hs01.llsuptemp01.cm","Low Loss Header Supply Water Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 1),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hs01.llrettemp01.cm","Low Loss Header Return Water Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 2),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hs01.suptempcont01.mn","EcoPIlot Supply Temp Minimum Setpoint Limit ","C"), new ObjectIdentifier(ObjectType.analogValue, 1)));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hs01.suptempcont01.mx","EcoPIlot Supply Temp Maximum Setpoint Limit ","C"), new ObjectIdentifier(ObjectType.analogValue, 3)));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hs01.suptempcont01.dsp","Ecopilot Temperature Setpoint Offset +/- ","C"), new ObjectIdentifier(ObjectType.analogValue, 2)));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hs01.suptempcont01.csp","EcoPilot Calculated Temperature Setpoint ","C"), new ObjectIdentifier(ObjectType.analogInput, 5),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hs01.apartrettemp01.cm","Apartment Return Water Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 6),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hs01.parkingrettemp01.cm","Parking Return Water Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 7),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hs01.muarettemp01.cm","MUA Return Water Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 8),true));
	pointList.add(new PointConnnectionContainer(pdb.createBoolean("hs01.heatpump06.di"," Main Heating Pump #6 Status "), new ObjectIdentifier(ObjectType.binaryInput, 0),true));
	//pointList.add(new PointConnnectionContainer(pdb.createFloat("hs01.heatpump06.cm","Main Heating Pump #6 Speed ","%"), new ObjectIdentifier(ObjectType.analogInput, NA),true));
	pointList.add(new PointConnnectionContainer(pdb.createBoolean("hs01.heatpump07.di"," Main Heating Pump #7 Status "), new ObjectIdentifier(ObjectType.binaryInput, 2),true));
	//pointList.add(new PointConnnectionContainer(pdb.createFloat("hs01.heatpump07.cm","Main Heating Pump #7 Speed ","%"), new ObjectIdentifier(ObjectType.analogInput, NA),true));
	pointList.add(new PointConnnectionContainer(pdb.createBoolean("hs01.heatpump10.di","MUA Heating Pump #10 Status "), new ObjectIdentifier(ObjectType.binaryInput, 1),true));
	pointList.add(new PointConnnectionContainer(pdb.createBoolean("hs01.heatpump09.di","Parking Garage Heating Pump #9 Status "), new ObjectIdentifier(ObjectType.binaryInput, 4),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hs01.suptempcont01.out1","Boiler Fire Rate ","%"), new ObjectIdentifier(ObjectType.analogInput, 9),true));
	pointList.add(new PointConnnectionContainer(pdb.createBoolean("hs01.boiler01.di","Boiler #1 Status "), new ObjectIdentifier(ObjectType.binaryInput, 5),true));
	pointList.add(new PointConnnectionContainer(pdb.createBoolean("hs01.boiler02.di","Boiler #2 Status "), new ObjectIdentifier(ObjectType.binaryInput, 6),true));
	pointList.add(new PointConnnectionContainer(pdb.createBoolean("hs01.boiler03.di","Boiler #3 Status "), new ObjectIdentifier(ObjectType.binaryInput, 7),true));
	pointList.add(new PointConnnectionContainer(pdb.createBoolean("hs01.boiler04.di","Boiler #4 Status "), new ObjectIdentifier(ObjectType.binaryInput, 8),true));
	pointList.add(new PointConnnectionContainer(pdb.createBoolean("hs01.boiler05.di","Boiler #5 Status "), new ObjectIdentifier(ObjectType.binaryInput, 9),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hs01.wwshutdownspt01.cm","Warm Weather Shutdown Setpoint ","C"), new ObjectIdentifier(ObjectType.analogInput, 10),true));
	pointList.add(new PointConnnectionContainer(pdb.createBoolean("hs01.wwshutdownspt01.di","Warm Weather Shutdown Status "), new ObjectIdentifier(ObjectType.binaryInput, 10),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hs01.cascadespt01.cm","Cascade Setpoint ","C"), new ObjectIdentifier(ObjectType.analogInput, 11),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hs01.cascadepower01.cm","Cascade Power ","%"), new ObjectIdentifier(ObjectType.analogInput, 12),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hs01.boilerroomtemp01.cm","Boiler Room Temp. ","C"), new ObjectIdentifier(ObjectType.analogInput, 27),true));

	//Domestic Hot Water 
	pointList.add(new PointConnnectionContainer(pdb.createFloat("dhw01.suptempcont01.sp","Domestic Hot Water Temperature Setpoint ","C"), new ObjectIdentifier(ObjectType.analogInput, 14),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("dhw01.suptempcont01.ms","Domestic Hot Water Supply Water Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 15),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("dhw01.suptemplowlimit01.cm","Domestic Hot Water Low Limit Alarm Setpoint ","C"), new ObjectIdentifier(ObjectType.analogInput, 16),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("dhw01.tanktemp01.cm","Domestic Tank #1 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 17),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("dhw01.tanktemp02.cm","Domestic Tank #2 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 18),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("dhw01.tanktemp03.cm","Domestic Tank #3 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 19),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("dhw01.tanktemp04.cm","Domestic Tank #4 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 20),true));
	pointList.add(new PointConnnectionContainer(pdb.createAlarm("dhw01.boiler01.al","Boiler 1 Alarm ","HEAT","CRIT"), new ObjectIdentifier(ObjectType.binaryInput, 11),true));
	pointList.add(new PointConnnectionContainer(pdb.createAlarm("dhw01.boiler02.al","Boiler 2 Alarm ","HEAT","CRIT"), new ObjectIdentifier(ObjectType.binaryInput, 12),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("dhw01.firerate01.cm","Boiler #1 Fire Rate ","%"), new ObjectIdentifier(ObjectType.analogInput, 21),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("dhw01.firerate02.cm","Boiler #2 Fire Rate ","%"), new ObjectIdentifier(ObjectType.analogInput, 22),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("dhw01.boilerintemp01.cm","Boiler #1 Inlet Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 23),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("dhw01.boilerintemp02.cm","Boiler #2 Inlet Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 24),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("dhw01.boilerouttemp01.cm","Boiler #1 Outlet Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 25),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("dhw01.boilerouttemp02.cm","Boiler #2 Outlet Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 26),true));

	//MUA
	pointList.add(new PointConnnectionContainer(pdb.createMultiState("mua01.comfort.TC.SW","EcoPilot Control Point ",msTranslation1), new ObjectIdentifier(ObjectType.analogValue, 4)));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("mua01.ecomode.cm","Eco Mode 0=OFF 1=ON 2=BAS", ""), new ObjectIdentifier(ObjectType.analogValue, 4),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("mua01.suptempcont01.sp","AEM Supply Air Setpoint ","C"), new ObjectIdentifier(ObjectType.analogInput, 28),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("mua01.suptempcont01.ms","Discharge Air Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 29),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("mua01.suptempcont01.mn","EcoPIlot Supply Temp Minimum Setpoint Limit ","C"), new ObjectIdentifier(ObjectType.analogValue, 5)));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("mua01.suptempcont01.mx","EcoPIlot Supply Temp Maximum Setpoint Limit ","C"), new ObjectIdentifier(ObjectType.analogValue, 6)));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("mua01.suptempcont01.dsp","Ecopilot Temperature Setpoint Offset +/- ","C"), new ObjectIdentifier(ObjectType.analogValue, 7)));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("mua01.suptempcont01.csp","EcoPilot Calculated Temperature Setpoint ","C"), new ObjectIdentifier(ObjectType.analogInput, 30),true));
	pointList.add(new PointConnnectionContainer(pdb.createBoolean("mua01.heatpump10.di","Pump #10 Status "), new ObjectIdentifier(ObjectType.binaryInput, 1),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("mua01.heatpump01.out3","Pump #10 Speed ","%"), new ObjectIdentifier(ObjectType.analogInput, 32),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("mua01.hcrettemp01.cm","Heat Coil Return Water Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 31),true));
	pointList.add(new PointConnnectionContainer(pdb.createBoolean("mua01.supfan01.di","Supply  Fan Status "), new ObjectIdentifier(ObjectType.binaryInput, 3),true));

	
	
	//Meter Points
	pointList.add(new PointConnnectionContainer(pdb.createFloat("met.outdoortemp01.cm","Outdoor Air Temp ","C"), new ObjectIdentifier(ObjectType.analogInput, 13),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("met.gaspulse01.cm","Gas Meter ","m3"), new ObjectIdentifier(ObjectType.analogInput, 33),true));

	
	
	

	return pointList;
}
}
