package model;

public interface IValveDriver {
	PressureValveStatus getStatus();
	void open();
	void close();
}
