package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeaterTest {
	
	IDeviceDriver heater = new Heater();

	@Test
	public void getStatus_heaterStatus_resultFalse() {
		assertEquals(false, heater.getStatus());
	}
	
	@Test
	public void getSensor_retrieveSensorObject_resultISensor() {
		assertTrue (((Heater) heater).getSensor() instanceof ISensor);
	}

	@Test
	public void on_HeaterOn_resultTrue() {
		heater.on();
		assertEquals(true, heater.getStatus());
	}

	@Test
	public void off_HeaterOff_resultFalse() {
		heater.off();
		assertEquals(false, heater.getStatus());
	}
}
