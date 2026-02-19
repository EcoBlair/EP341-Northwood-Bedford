package pointconfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.serotonin.bacnet4j.type.enumerated.ObjectType;
import com.serotonin.bacnet4j.type.primitive.ObjectIdentifier;

import main.PointConnnectionContainer;
import pdb.PdbException;
import pdb.PdbInterface;

//import main.FahrenheitCelsiusScaler;
//import main.OffsetFahrenheitCelsiusScaler;
//import main.Scaler;
import pdb.MultiStateTranslation;
import pdb.MultiStateValue;
import pdb.PDBb;


public class ddc02 {

public static List<PointConnnectionContainer> points(PdbInterface pdb) throws PdbException {
	List<PointConnnectionContainer> pointList = new ArrayList<PointConnnectionContainer>();
	
	
	MultiStateTranslation msTranslation1 =  new MultiStateTranslation(Arrays.asList(
			new MultiStateValue(999, "Auto", 1, "Auto"),
			new MultiStateValue(0, "Off", 2, "Off"),
			new MultiStateValue(1, "On", 3, "On")
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
	
	//PDBb system = new PDBb("system", "System, Description");
	//BACnet points
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl02.roomtemp100.cm","EP1_223 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 1),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl02.roomtemp101.cm","EP2_216 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 2),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl02.roomtemp102.cm","EP3_2nd Floor North Hall Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 3),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl02.roomtemp103.cm","EP4_202 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 4),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl02.roomtemp104.cm","EP5_212 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 5),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl02.roomtemp105.cm","EP6_209 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 6),true));
	
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl03.roomtemp106.cm","EP7_322 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 7),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl03.roomtemp107.cm","EP8_317 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 8),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl03.roomtemp108.cm","EP9_313 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 9),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl03.roomtemp109.cm","EP10_304 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 10),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl03.roomtemp110.cm","EP11_303 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 11),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl03.roomtemp111.cm","EP12_314 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 12),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl03.roomtemp112.cm","EP13_3rd Floor East Hall Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 13),true));
	
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl04.roomtemp113.cm","EP14_423 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 14),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl04.roomtemp114.cm","EP15_416 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 15),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl04.roomtemp115.cm","EP16_402 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 16),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl04.roomtemp116.cm","EP17_401 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 17),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl04.roomtemp117.cm","EP18_412 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 18),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl04.roomtemp118.cm","EP19_409 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 19),true));
	
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl05.roomtemp119.cm","EP20_522 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 20),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl05.roomtemp120.cm","EP21_517 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 21),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl05.roomtemp121.cm","EP22_513 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 22),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl05.roomtemp122.cm","EP23_504 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 23),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl05.roomtemp123.cm","EP24_503 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 24),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl05.roomtemp124.cm","EP25_514 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 25),true));
	
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl06.roomtemp125.cm","EP26_623 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 26),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl06.roomtemp126.cm","EP27_616 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 27),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl06.roomtemp127.cm","EP28_6th Floor North Hall Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 28),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl06.roomtemp128.cm","EP29_606 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 29),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl06.roomtemp129.cm","EP30_605 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 30),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl06.roomtemp130.cm","EP31_609 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 31),true));
	
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl07.roomtemp131.cm","EP32_722 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 32),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl07.roomtemp132.cm","EP33_717 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 33),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl07.roomtemp133.cm","EP34_713 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 34),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl07.roomtemp134.cm","EP35_708 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 35),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl07.roomtemp135.cm","EP36_714 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 36),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl07.roomtemp136.cm","EP37_711 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 37),true));
	
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl08.roomtemp137.cm","EP38_820 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 38),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl08.roomtemp138.cm","EP39_816 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 39),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl08.roomtemp139.cm","EP40_815 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 40),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl08.roomtemp140.cm","EP41_801 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 41),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl08.roomtemp141.cm","EP42_806 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 42),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl08.roomtemp142.cm","EP43_812 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 43),true));
	
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl09.roomtemp143.cm","EP44_922 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 44),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl09.roomtemp144.cm","EP45_913 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 45),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl09.roomtemp145.cm","EP46_904 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 46),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl09.roomtemp146.cm","EP47_907 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 47),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl09.roomtemp147.cm","EP48_914 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 48),true));
	
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl10.roomtemp148.cm","EP49_1023 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 49),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl10.roomtemp149.cm","EP50_10th Floor North Hall Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 50),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl10.roomtemp150.cm","EP51_1016 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 51),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl10.roomtemp151.cm","EP52_1002 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 52),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl10.roomtemp152.cm","EP53_1012 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 53),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl10.roomtemp153.cm","EP54_1005 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 54),true));
	
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl11.roomtemp154.cm","EP55_1121 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 55),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl11.roomtemp155.cm","EP56_1118 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 56),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl11.roomtemp156.cm","EP57_1113 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 57),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl11.roomtemp157.cm","EP58_1104 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 58),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl11.roomtemp158.cm","EP59_1107 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 59),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("fl11.roomtemp159.cm","EP60_1111 Temperature ","C"), new ObjectIdentifier(ObjectType.analogInput, 60),true));

	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat02.roombatt100.cm","EP1_223 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 101),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat02.roombatt101.cm","EP2_216 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 102),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat02.roombatt102.cm","EP3_2nd Floor North Hall Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 103),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat02.roombatt103.cm","EP4_202 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 104),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat02.roombatt104.cm","EP5_212 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 105),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat02.roombatt105.cm","EP6_209 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 106),true));

	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat03.roombatt106.cm","EP7_322 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 107),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat03.roombatt107.cm","EP8_317 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 108),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat03.roombatt108.cm","EP9_313 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 109),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat03.roombatt109.cm","EP10_304 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 110),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat03.roombatt110.cm","EP11_303 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 111),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat03.roombatt111.cm","EP12_314 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 112),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat03.roombatt112.cm","EP13_3rd Floor East Hall Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 113),true));

	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat04.roombatt113.cm","EP14_423 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 114),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat04.roombatt114.cm","EP15_416 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 115),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat04.roombatt115.cm","EP16_402 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 116),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat04.roombatt116.cm","EP17_401 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 117),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat04.roombatt117.cm","EP18_412 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 118),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat04.roombatt118.cm","EP19_409 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 119),true));

	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat05.roombatt119.cm","EP20_522 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 120),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat05.roombatt120.cm","EP21_517 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 121),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat05.roombatt121.cm","EP22_513 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 122),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat05.roombatt122.cm","EP23_504 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 123),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat05.roombatt123.cm","EP24_503 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 124),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat05.roombatt124.cm","EP25_514 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 125),true));

	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat06.roombatt125.cm","EP26_623 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 126),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat06.roombatt126.cm","EP27_616 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 127),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat06.roombatt127.cm","EP28_6th Floor North Hall Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 128),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat06.roombatt128.cm","EP29_606 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 129),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat06.roombatt129.cm","EP30_605 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 130),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat06.roombatt130.cm","EP31_609 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 131),true));

	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat07.roombatt131.cm","EP32_722 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 132),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat07.roombatt132.cm","EP33_717 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 133),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat07.roombatt133.cm","EP34_713 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 134),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat07.roombatt134.cm","EP35_708 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 135),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat07.roombatt135.cm","EP36_714 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 136),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat07.roombatt136.cm","EP37_711 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 137),true));

	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat08.roombatt137.cm","EP38_820 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 138),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat08.roombatt138.cm","EP39_816 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 139),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat08.roombatt139.cm","EP40_815 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 140),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat08.roombatt140.cm","EP41_801 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 141),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat08.roombatt141.cm","EP42_806 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 142),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat08.roombatt142.cm","EP43_812 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 143),true));

	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat09.roombatt143.cm","EP44_922 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 144),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat09.roombatt144.cm","EP45_913 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 145),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat09.roombatt145.cm","EP46_904 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 146),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat09.roombatt146.cm","EP47_907 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 147),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat09.roombatt147.cm","EP48_914 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 148),true));

	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat10.roombatt148.cm","EP49_1023 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 149),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat10.roombatt149.cm","EP50_10th Floor North Hall Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 150),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat10.roombatt150.cm","EP51_1016 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 151),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat10.roombatt151.cm","EP52_1002 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 152),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat10.roombatt152.cm","EP53_1012 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 153),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat10.roombatt153.cm","EP54_1005 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 154),true));

	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat11.roombatt154.cm","EP55_1121 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 155),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat11.roombatt155.cm","EP56_1118 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 156),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat11.roombatt156.cm","EP57_1113 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 157),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat11.roombatt157.cm","EP58_1104 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 158),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat11.roombatt158.cm","EP59_1107 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 159),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("bat11.roombatt159.cm","EP60_1111 Battery ","%"), new ObjectIdentifier(ObjectType.analogInput, 160),true));


	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum02.roomhum100.cm","EP1_223 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 201),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum02.roomhum101.cm","EP2_216 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 202),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum02.roomhum102.cm","EP3_2nd Floor North Hall Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 203),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum02.roomhum103.cm","EP4_202 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 204),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum02.roomhum104.cm","EP5_212 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 205),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum02.roomhum105.cm","EP6_209 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 206),true));

	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum03.roomhum106.cm","EP7_322 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 207),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum03.roomhum107.cm","EP8_317 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 208),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum03.roomhum108.cm","EP9_313 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 209),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum03.roomhum109.cm","EP10_304 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 210),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum03.roomhum110.cm","EP11_303 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 211),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum03.roomhum111.cm","EP12_314 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 212),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum03.roomhum112.cm","EP13_3rd Floor East Hall Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 213),true));

	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum04.roomhum113.cm","EP14_423 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 214),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum04.roomhum114.cm","EP15_416 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 215),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum04.roomhum115.cm","EP16_402 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 216),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum04.roomhum116.cm","EP17_401 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 217),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum04.roomhum117.cm","EP18_412 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 218),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum04.roomhum118.cm","EP19_409 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 219),true));

	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum05.roomhum119.cm","EP20_522 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 220),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum05.roomhum120.cm","EP21_517 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 221),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum05.roomhum121.cm","EP22_513 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 222),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum05.roomhum122.cm","EP23_504 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 223),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum05.roomhum123.cm","EP24_503 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 224),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum05.roomhum124.cm","EP25_514 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 225),true));

	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum06.roomhum125.cm","EP26_623 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 226),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum06.roomhum126.cm","EP27_616 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 227),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum06.roomhum127.cm","EP28_6th Floor North Hall Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 228),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum06.roomhum128.cm","EP29_606 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 229),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum06.roomhum129.cm","EP30_605 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 230),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum06.roomhum130.cm","EP31_609 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 231),true));

	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum07.roomhum131.cm","EP32_722 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 232),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum07.roomhum132.cm","EP33_717 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 233),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum07.roomhum133.cm","EP34_713 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 234),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum07.roomhum134.cm","EP35_708 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 235),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum07.roomhum135.cm","EP36_714 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 236),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum07.roomhum136.cm","EP37_711 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 237),true));

	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum08.roomhum137.cm","EP38_820 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 238),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum08.roomhum138.cm","EP39_816 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 239),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum08.roomhum139.cm","EP40_815 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 240),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum08.roomhum140.cm","EP41_801 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 241),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum08.roomhum141.cm","EP42_806 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 242),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum08.roomhum142.cm","EP43_812 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 243),true));

	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum09.roomhum143.cm","EP44_922 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 244),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum09.roomhum144.cm","EP45_913 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 245),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum09.roomhum145.cm","EP46_904 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 246),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum09.roomhum146.cm","EP47_907 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 247),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum09.roomhum147.cm","EP48_914 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 248),true));

	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum10.roomhum148.cm","EP49_1023 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 249),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum10.roomhum149.cm","EP50_10th Floor North Hall Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 250),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum10.roomhum150.cm","EP51_1016 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 251),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum10.roomhum151.cm","EP52_1002 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 252),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum10.roomhum152.cm","EP53_1012 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 253),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum10.roomhum153.cm","EP54_1005 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 254),true));

	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum11.roomhum154.cm","EP55_1121 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 255),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum11.roomhum155.cm","EP56_1118 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 256),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum11.roomhum156.cm","EP57_1113 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 257),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum11.roomhum157.cm","EP58_1104 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 258),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum11.roomhum158.cm","EP59_1107 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 259),true));
	pointList.add(new PointConnnectionContainer(pdb.createFloat("hum11.roomhum159.cm","EP60_1111 Humidity ","%RH"), new ObjectIdentifier(ObjectType.analogInput, 260),true));

	
	return pointList;
}
}
