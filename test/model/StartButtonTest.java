package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class StartButtonTest {
	
	StartButton button = new StartButton();

	@Test
	public void getStatus_startButton_resultFalse() {
		assertEquals(false, button.getIsPushed());
	}

	@Test
	public void isPushed_startButton_resultFalse() {
		button.setIsPushed(true);
		assertEquals(true, button.getIsPushed());
	}
}
