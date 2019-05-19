package model;

public class PressureValve implements IValveDriver {
	PressureValveStatus status;
	
	public PressureValve () {
		status = PressureValveStatus.CLOSED;
	}

	public PressureValveStatus getStatus() {
		return status;
	}

	public void setStatus(PressureValveStatus status) {
		this.status = status; 
	}

	public void open() {
		this.setStatus(PressureValveStatus.OPEN); 
	}

	public void close() {
		this.setStatus(PressureValveStatus.CLOSED); 
	}
}
