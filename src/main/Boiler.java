
public class Boiler {
	double pressure;
	Heater heater;
	Sensor sensor;
	PressureValve valve;

	public Boiler(Heater heater, Sensor sensor, PressureValve valve) {
		this.heater = heater;
		this.sensor = sensor;
		this.valve = valve;
	}
	Heater getHeater() {
		return heater;
	}
	Sensor getSensor() {
		return sensor;
	}
	PressureValve getValve() {
		return valve;
	}

}
