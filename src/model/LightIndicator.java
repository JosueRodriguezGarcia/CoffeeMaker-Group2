package model;

public class LightIndicator implements IDeviceDriver {
	DeviceStatus status;
	
	public LightIndicator() {
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
