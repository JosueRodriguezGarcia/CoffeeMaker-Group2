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

<<<<<<< HEAD
	// Open Relief Valve
=======
	public void setStatus(PressureValveStatus status) {
		this.status = status; 
	}

>>>>>>> 602ae9b7fe8fee9a5525089278882f59a96b6a17
	public void open() {
		this.setStatus(PressureValveStatus.OPEN); 
	}

	// Close Relief Valve
	public void close() {
		this.setStatus(PressureValveStatus.CLOSED); 
	}
}
