package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class LightIndicatorTest {

	IDeviceDriver light = new LightIndicator();
	
	@Test
	public void getStatus_lighIndicatorStatus_resultFalse() {
		assertEquals(false, light.getStatus());
	}

	@Test
	public void on_lighIndicatorOn_resultTrue() {
		light.on();
		assertEquals(true, light.getStatus());
	}

	@Test
	public void off_lighIndicatorOff_resultFalse() {
		light.off();
		assertEquals(false, light.getStatus());
	}

}
