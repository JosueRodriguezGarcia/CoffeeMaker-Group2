package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class StartButtonTest {
	
	StartButton button = new StartButton();

	@Test
	public void getStatus_retrieveStartButton_resultFalse() {
		assertEquals(StartButtonStatus.OFF, button.getStatus());
	}

	@Test
	public void setStatus_setStartButton_resultTrue() {
		button.setStatus(StartButtonStatus.ON);
		assertEquals(StartButtonStatus.ON, button.getStatus());
	}
}
