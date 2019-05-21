package model;

public class PressureValve implements IValveDriver {
	PressureValveStatus status;
	
	// Constructor
	public PressureValve () {
		status = PressureValveStatus.CLOSED;
	}

	// Getter
	public PressureValveStatus getStatus() {
		return status;
	}

	public void setStatus(PressureValveStatus status) {
		this.status = status; 
	}

	// Open Relief Valve
	public void open() {
		this.setStatus(PressureValveStatus.OPEN); 
	}

	// Close Relief Valve
	public void close() {
		this.setStatus(PressureValveStatus.CLOSED); 
	}
}
