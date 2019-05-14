package CoffeeMaker;

public class LightIndicator implements IDeviceDriver {
	boolean isOn;
	
	public LightIndicator() {
		isOn = false;
	}
	
	public boolean getIsOn () {
		return isOn;
	}
	
	public void off() {
		isOn = false;
	}
	
	public void on() {
		isOn = true;
	}
}
