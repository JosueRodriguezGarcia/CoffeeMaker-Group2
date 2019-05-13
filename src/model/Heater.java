package model;

public abstract class Heater implements DeviceDriver {
	boolean isOn;
	Sensor sensor;
	
	public Heater () {
		isOn = false;
	}
	
	boolean isOn () {
		return isOn;
	}
	
	Sensor getSensor () {
		return sensor;
	}
	
	void setSensor (Sensor sensor) {
		this.sensor = sensor;
	}
	
	public void off() {
		isOn = false;
	}
	
	public void on() {
		isOn = true;
	}
}
