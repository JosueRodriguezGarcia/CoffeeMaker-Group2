package model;

public class CoffeeMaker {
	private boolean isOn;
	private StartButton button;
	private LightIndicator light;
	private Plate plate;
	private Boiler boiler;
	public CoffeeMaker() {
		isOn = false;
	}
	public boolean isOn() {
		return isOn;
	}
}
