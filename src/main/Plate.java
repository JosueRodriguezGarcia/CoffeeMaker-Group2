package main;

public class Plate {
	DeviceDriver heater;
	Sensor sensor;
	
	public Plate () {
		this.heater = new Heater();
		this.sensor = SensorFactory.make(SensorType.PLATE_SENSOR);
	}

	public DeviceDriver getHeater() {
		return heater;
	}

	public Sensor getSensor() {
		return sensor;
	}
}
