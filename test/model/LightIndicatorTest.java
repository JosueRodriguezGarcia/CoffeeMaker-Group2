package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class LightIndicatorTest {

	IDeviceDriver light = new LightIndicator();
	
	@Test
	public void getStatus_lighIndicatorStatus_resultOff() {
		assertEquals(DeviceStatus.OFF, light.getStatus());
	}

	@Test
	public void on_lighIndicatorOn_resultOn() {
		light.on();
		assertEquals(DeviceStatus.ON, light.getStatus());
	}

	@Test
	public void off_lighIndicatorOff_resultOff() {
		light.off();
		assertEquals(DeviceStatus.OFF, light.getStatus());
	}

}
