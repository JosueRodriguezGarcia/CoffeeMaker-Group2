package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlateSensorTest {

	ISensor plateSensor = new PlateSensor();

	@Test
	public void getStatus_resultPlateSensorStatus() {
		assertEquals(PlateSensorStatus.POT_EMPTY, plateSensor.getStatus());
	}

	@Test
	public void setStatus_resultPlateSensorStatus() {
		plateSensor.setStatus(PlateSensorStatus.POT_NOT_EMPTY);
		assertEquals(PlateSensorStatus.POT_NOT_EMPTY, plateSensor.getStatus());
	}
}
