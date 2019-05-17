package model;

public class Heater implements IDeviceDriver {
	DeviceStatus status;
	
	public Heater () {
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
