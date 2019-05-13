package main;

public class PressureValve implements ValveDriver {
	boolean isOpen;
	
	public PressureValve () {
		isOpen = false;
	}

	public boolean getIsOpen() {
		return isOpen;
	}

	public void open() {
		isOpen = true; 
	}

	public void close() {
		isOpen = false; 
	}
}
