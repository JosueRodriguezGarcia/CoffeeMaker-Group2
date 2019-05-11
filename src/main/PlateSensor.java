package main;

public class PlateSensor extends Sensor {
	static final int WARMER_EMPTY = -1;
	static final int POT_EMPTY = 0;
	static final int POT_NOT_EMPTY = 1;
	
	public PlateSensor() {
		status = WARMER_EMPTY;
	}
}
