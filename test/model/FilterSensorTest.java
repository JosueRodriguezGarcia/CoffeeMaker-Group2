package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class FilterSensorTest {

	ISensor filterSensor = new FilterSensor();

	@Test
	public void getStatus_resultFilterSensorStatus() {
		assertEquals(FilterSensorStatus.FILTER_NOT_EMPTY, filterSensor.getStatus());
	}

	@Test
	public void setStatus_resultFilterSensorStatus() {
		filterSensor.setStatus(FilterSensorStatus.FILTER_EMPTY);
		assertEquals(FilterSensorStatus.FILTER_EMPTY, filterSensor.getStatus());
	}
}
