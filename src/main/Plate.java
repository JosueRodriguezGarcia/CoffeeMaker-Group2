package main;

public class Plate {
	Heater heater;
	Sensor sensor;
	
	public Plate () {
		this.heater = new Heater();
		this.sensor = new PlateSensor();
	}

	public Heater getHeater() {
		return heater;
	}

	public Sensor getSensor() {
		return sensor;
	}
}
