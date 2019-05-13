package model;

public class Boiler {
	double pressure;
	IDeviceDriver heater;
	ISensor sensor;
	IValveDriver valve;
	
	public Boiler () {
		pressure = 0.0;
		this.heater = new Heater();
		this.sensor = SensorFactory.make(SensorType.BOILER_SENSOR);
		this.valve = new PressureValve();
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
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
