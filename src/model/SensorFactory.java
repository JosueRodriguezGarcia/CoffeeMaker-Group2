package model;

abstract public class SensorFactory {
	public static ISensor create(SensorType sensorType) {
		switch (sensorType) {
		case PLATE_SENSOR: 
			return new PlateSensor();

		case BOILER_SENSOR: 
			return new BoilerSensor();

		case FILTER_SENSOR: 
			return new FilterSensor();

		default:
			return null;
		}
	}
}
