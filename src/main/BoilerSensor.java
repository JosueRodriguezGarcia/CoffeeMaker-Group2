package main;

public class BoilerSensor extends Sensor {
	static final int BOILER_EMPTY = 0;
	static final int BOILER_NOT_EMPTY = 1;
	
	public BoilerSensor() {
		status = BOILER_EMPTY;
	}
}
