package model;

public class PressureValve implements IValveDriver {
	PressureValveStatus status;
	
	public PressureValve () {
		status = PressureValveStatus.CLOSED;
	}

	public PressureValveStatus getStatus() {
		return status;
	}

	public void open() {
		status = PressureValveStatus.OPEN; 
	}

	public void close() {
		status = PressureValveStatus.CLOSED; 
	}
}
