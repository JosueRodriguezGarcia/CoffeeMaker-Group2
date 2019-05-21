package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoilerTest {
	Boiler boiler = new Boiler();

	@Test
	public void getSensor_retrieveISensor_resultISensor() {
		assertTrue(boiler.getSensor() instanceof ISensor);
	}
	
	@Test
	public void getHeater_retrieveIDeviceDriver_resultIDeviceDriver() {
		assertTrue(boiler.getHeater() instanceof IDeviceDriver);
	}
	
	@Test
	public void getValve_retrievePressureValve_resultPressureValve() {
		assertTrue(boiler.getValve() instanceof PressureValve);
	}
}
