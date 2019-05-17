package model;

public class LightIndicator implements IDeviceDriver {
	DeviceStatus status;
	
	public LightIndicator() {
		status = DeviceStatus.OFF;
	}
	
	public DeviceStatus getStatus () {
		return status;
	}
	
	public void off() {
		status = DeviceStatus.OFF;
	}
	
	public void on() {
		status = DeviceStatus.ON;
	}
}
