package model;

public class Boiler {
	IDeviceDriver heater;
	ISensor sensor;
	IValveDriver valve;

	public Boiler() {
		this.heater = new Heater();
		this.sensor = SensorFactory.create(SensorType.BOILER_SENSOR);
		this.valve = new PressureValve();
	}

	public IDeviceDriver getHeater() {
		return heater;
	}

	public ISensor getSensor() {
		return sensor;
	}

	public IValveDriver getValve() {
		return valve;
	}
}
