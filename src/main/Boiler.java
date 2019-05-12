package main;

public class Boiler {
	double pressure;
	DeviceDriver heater;
	Sensor sensor;
	ValveDriver valve;
	
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

	public DeviceDriver getHeater() {
		return heater;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public ValveDriver getValve() {
		return valve;
	}
}
