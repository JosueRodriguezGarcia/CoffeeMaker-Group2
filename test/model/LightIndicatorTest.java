package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class LightIndicatorTest {

	IDeviceDriver light = new LightIndicator();
	
	@Test
	public void getStatus_retrieveLighIndicatorStatus_resultOff() {
		assertEquals(DeviceStatus.OFF, light.getStatus());
	}

	@Test
	public void on_statusLighIndicatorOn_resultOn() {
		light.on();
		assertEquals(DeviceStatus.ON, light.getStatus());
	}

	@Test
	public void off_statusLighIndicatorOff_resultOff() {
		light.off();
		assertEquals(DeviceStatus.OFF, light.getStatus());
	}

}
