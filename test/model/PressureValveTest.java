package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PressureValveTest {

	IValveDriver valve = new PressureValve();
	
	@Test
	public void getStatus_pressureValveStatus_resultClosed() {		
		assertEquals(false, valve.getIsOpen());
	}

	@Test
	public void on_HeaterOn_resultTrue() {
		valve.open();
		assertEquals(true, valve.getIsOpen());
	}

	@Test
	public void off_HeaterOff_resultFalse() {
		valve.close();
		assertEquals(false, valve.getIsOpen());
	}

}
