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
	
	public void setStatus(DeviceStatus status) {
		this.status = status;
	}
	
	//Turn Heater off
	public void off() {
		this.setStatus(DeviceStatus.OFF);
	}
	
	// Turn Heater on
	public void on() {
		this.setStatus(DeviceStatus.ON);
	}
}
