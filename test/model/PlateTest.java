package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlateTest {

	Plate plate = new Plate();
	
	@Test
	public void getHeater_retrieveStatusPlateHeater_resultHeater() {
		assertTrue(plate.getHeater() instanceof IDeviceDriver);
	}

	@Test
	public void getSensor_retrieveStatusISensor_resultSensor() {
		assertTrue(plate.getSensor() instanceof ISensor);
	}

}
