package main;

public class Boiler {
	double pressure;
	Heater heater;
	Sensor sensor;
	PressureValve valve;
	
	public Boiler (PressureValve valve) {
		pressure = 0.0;
		this.heater = new BoilerHeater();
		this.sensor = new BoilerSensor();
		this.valve = valve;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public Heater getHeater() {
		return heater;
	}

	public void setHeater(Heater heater) {
		this.heater = heater;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
}