
public class Plate {
	Heater heater;
	Sensor sensor;

	public Plate(Heater heater, Sensor sensor) {
		this.heater = heater;
		this.sensor = sensor;
	}

	Heater getHeater() {
		return heater;
	}

	Sensor getSensor() {
		return sensor;
	}

}
