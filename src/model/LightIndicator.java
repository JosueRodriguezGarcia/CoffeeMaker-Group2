package model;

public class LightIndicator implements IDeviceDriver {
	DeviceStatus status;
	
	// Constructor
	public LightIndicator() {
		status = DeviceStatus.OFF;
	}
	
	// Getter
	public DeviceStatus getStatus () {
		return status;
	}
	
	public void setStatus(DeviceStatus status) {
		this.status = status;
	}
	
	//Turn Light off
	public void off() {
		this.setStatus(DeviceStatus.OFF);
	}
	
	// Turn Light on
	public void on() {
		this.setStatus(DeviceStatus.ON);
	}
}
