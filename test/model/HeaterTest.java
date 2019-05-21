package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeaterTest {
	
	Heater heater = new Heater();

	@Test
	public void getStatus_retrieveStatusHeater_resultOff() {
		assertEquals(DeviceStatus.OFF, heater.getStatus());
	}
	
	@Test
	public void on_statusHeaterOn__resultTrue() {
		heater.on();
		assertEquals(DeviceStatus.ON, heater.getStatus());
	}

	@Test
	public void off_statusHeaterOff_resultFalse() {
		heater.off();
		assertEquals(DeviceStatus.OFF, heater.getStatus());
	}
}
