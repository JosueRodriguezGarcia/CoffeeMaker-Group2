package main;

abstract public class SensorFactory {
	public static Sensor make(SensorType sensorType) {
		switch (sensorType) {
		case PLATE_SENSOR: 
			return new PlateSensor();

		case BOILER_SENSOR: 
			return new BoilerSensor();

		default:
			return null;
		}
	}
}
