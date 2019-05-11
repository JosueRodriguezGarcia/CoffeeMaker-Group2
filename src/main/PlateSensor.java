package main;

public class PlateSensor extends Sensor {
	final int WARMER_EMPTY = 0;
	final int POT_EMPTY = 1;
	final int POT_NOT_EMPTY = 2;
	
	public PlateSensor() {
		status = POT_EMPTY;
	}
	
	@Override
	public int getStatus() {
		return status;
	}
	
	@Override
	public void setStatus(int status) {
		this.status = status;
	}
	
}
