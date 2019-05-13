package main;

public class LightIndicator implements DeviceDriver {
	boolean isOn;
	
	public LightIndicator() {
		isOn = false;
	}
	
	public boolean getIsOn () {
		return isOn;
	}
	
	public void off() {
		isOn = false;
	}
	
	public void on() {
		isOn = true;
	}
}
