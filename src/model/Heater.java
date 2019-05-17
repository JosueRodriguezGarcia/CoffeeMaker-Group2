package model;

public class Heater implements IDeviceDriver {
	boolean status;
	ISensor sensor;
	
	public Heater () {
		status = false;
	}
	
	public boolean getStatus () {
		return status;
	}
	
	public ISensor getSensor () {
		return sensor;
	}
	
	public void off() {
		status = false;
	}
	
	public void on() {
		status = true;
	}
}
