package main;

public class Heater implements DeviceDriver {
	boolean isOn;
	Sensor sensor;
	
	public Heater () {
		isOn = false;
	}
	
	public boolean getIsOn () {
		return isOn;
	}
	
	public Sensor getSensor () {
		return sensor;
	}
	
	public void off() {
		isOn = false;
	}
	
	public void on() {
		isOn = true;
	}
}
