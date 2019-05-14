package CoffeeMaker;

public class Heater implements IDeviceDriver {
	boolean isOn;
	ISensor sensor;
	
	public Heater () {
		isOn = false;
	}
	
	public boolean getIsOn () {
		return isOn;
	}
	
	public ISensor getSensor () {
		return sensor;
	}
	
	public void off() {
		isOn = false;
	}
	
	public void on() {
		isOn = true;
	}
}
