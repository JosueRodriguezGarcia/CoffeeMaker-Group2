package main;

public class BoilerSensor extends Sensor {
	final int BOILER_EMPTY = 0;
	final int BOILER_NOT_EMPTY = 1;
	
	public BoilerSensor() {
		status = BOILER_NOT_EMPTY;
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
