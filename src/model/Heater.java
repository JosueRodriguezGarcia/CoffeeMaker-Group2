package model;

public class Heater implements IDeviceDriver {
	DeviceStatus status;
	
	public Heater () {
		status = DeviceStatus.OFF;
	}
	
	public DeviceStatus getStatus () {
		return status;
	}
	
	public void setStatus(DeviceStatus status) {
		this.status = status;
	}
	
	public void off() {
		this.setStatus(DeviceStatus.OFF);
	}
	
	public void on() {
		this.setStatus(DeviceStatus.ON);
	}
}
