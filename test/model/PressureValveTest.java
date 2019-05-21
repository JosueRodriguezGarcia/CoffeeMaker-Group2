package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PressureValveTest {

	IValveDriver valve = new PressureValve();
	
	@Test
	public void getStatus_retrieveValveStatus_resultClosed() {		
		assertEquals(PressureValveStatus.CLOSED, valve.getStatus());
	}

	@Test
	public void open_statusValveOpen_resultOpen() {
		valve.open();
		assertEquals(PressureValveStatus.OPEN, valve.getStatus());
	}

	@Test
	public void close_statusValveClosed_resultClosed() {
		valve.close();
		assertEquals(PressureValveStatus.CLOSED, valve.getStatus());
	}

}
