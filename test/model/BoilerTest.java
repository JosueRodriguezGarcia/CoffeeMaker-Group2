package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoilerTest {

	Boiler boiler = new Boiler();

	@Test
	public void pruebaTest_Sensor() {
		assertTrue(boiler.getSensor() instanceof ISensor);
	}
	
	@Test
	public void pruebaTest_Heater() {
		assertTrue(boiler.getHeater() instanceof IDeviceDriver);
	}
	
	@Test
	public void pruebaTest_Valve() {
		assertTrue(boiler.getValve() instanceof PressureValve);
	}
	
	
}
