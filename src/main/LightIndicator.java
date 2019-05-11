package main;

public class LightIndicator implements DeviceDriver {
	boolean isOn;
	
	public LightIndicator() {
		isOn = false;
	}

	public void off() {
		isOn = false;		
	}

	public void on() {
		isOn = true;
		
	}	
	
	/*
	boolean isOn () {
		return isOn;
	}
	*/
	
}
