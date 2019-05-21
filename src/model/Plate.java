package model;

public class Plate {
	IDeviceDriver heater;
	ISensor sensor;
	
	// Constructor
	public Plate () {
		this.heater = new Heater();
		this.sensor = SensorFactory.create(SensorType.PLATE_SENSOR);
	}

	
	// Getters
	public IDeviceDriver getHeater() {
		return heater;
	}

	public ISensor getSensor() {
		return sensor;
	}
}
