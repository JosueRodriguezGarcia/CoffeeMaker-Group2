package model;

public class Plate {
	IDeviceDriver heater;
	ISensor sensor;
	
	public Plate () {
		this.heater = new Heater();
		this.sensor = SensorFactory.create(SensorType.PLATE_SENSOR);
	}

	public IDeviceDriver getHeater() {
		return heater;
	}

	public ISensor getSensor() {
		return sensor;
	}
}
