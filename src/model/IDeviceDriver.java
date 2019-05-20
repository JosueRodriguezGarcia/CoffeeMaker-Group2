package model;

public interface IDeviceDriver {
	DeviceStatus getStatus();
	void off();
	void on();
}
