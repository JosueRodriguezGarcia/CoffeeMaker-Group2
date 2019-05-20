package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeaterTest {
	
	Heater heater = new Heater();

	@Test
	public void getStatus_resultOff() {
		assertEquals(DeviceStatus.OFF, heater.getStatus());
	}
	
	@Test
	public void on_On_resultOn() {
		heater.on();
		assertEquals(DeviceStatus.ON, heater.getStatus());
	}

	@Test
	public void off_HeaterOff_resultFalse() {
		heater.off();
		assertEquals(DeviceStatus.OFF, heater.getStatus());
	}
}
