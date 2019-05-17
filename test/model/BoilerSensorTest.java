package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoilerSensorTest {

	ISensor boilerSensor = new BoilerSensor();
	
	@Test
	public void getStatus_resultBoilerNotEmpty() {
		assertEquals(BoilerSensorStatus.BOILER_NOT_EMPTY,boilerSensor.getStatus());
	}

	@Test
	public void setStatus_boilerEmpty_resultboilerEmpty() {
		boilerSensor.setStatus(BoilerSensorStatus.BOILER_EMPTY);
		assertEquals(BoilerSensorStatus.BOILER_EMPTY,boilerSensor.getStatus());
	}

}
