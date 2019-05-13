package model;

public class Boiler {
<<<<<<< HEAD
	double pressure;
	Heater heater;
	Sensor sensor;
	PressureValve valve;
	
	public Boiler () {
		pressure = 0.0;
		this.heater = new BoilerHeater();
		this.sensor = new BoilerSensor();
		this.valve = new PressureValve();
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

	public PressureValve getValve() {
		return valve;
	}

	public void setValve(PressureValve valve) {
		this.valve = valve;
	}
=======

>>>>>>> develop
}
