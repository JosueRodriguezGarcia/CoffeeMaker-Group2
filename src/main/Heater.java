package main;

public class Heater implements DeviceDriver {
	boolean isOn;
		
	public Heater () {
		isOn = false;
	}
	/*
	public boolean isOn () {
		return isOn;
	}
	*/
	public void off() {
		isOn = false;		
	}
                                                      
	public void on() {
		isOn = true;
		
	}	
}
