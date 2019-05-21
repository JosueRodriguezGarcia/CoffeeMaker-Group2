package model;

public class Heater implements IDeviceDriver {
	DeviceStatus status;
	
	// Constructor
	public Heater () {
		status = DeviceStatus.OFF;
	}
	
	// Getter
	public DeviceStatus getStatus () {
		return status;
	}
	
<<<<<<< HEAD
	// Turn Heater off
=======
	public void setStatus(DeviceStatus status) {
		this.status = status;
	}
	
>>>>>>> 602ae9b7fe8fee9a5525089278882f59a96b6a17
	public void off() {
		this.setStatus(DeviceStatus.OFF);
	}
	
	// Turn Heater on
	public void on() {
		this.setStatus(DeviceStatus.ON);
	}
}
