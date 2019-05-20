package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class StartButtonTest {
	
	StartButton button = new StartButton();

	@Test
	public void getStatus_startButton_resultFalse() {
		assertEquals(StartButtonStatus.OFF, button.getStatus());
	}

	@Test
	public void isPushed_startButton_resultFalse() {
		button.setStatus(StartButtonStatus.ON);
		assertEquals(StartButtonStatus.ON, button.getStatus());
	}
}
