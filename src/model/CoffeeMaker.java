package model;

public class CoffeeMaker {
	StartButton button;
	IDeviceDriver light;
	ISensor sensor;
	Plate plate;
	Boiler boiler;

	public CoffeeMaker () {
		button = new StartButton();
		light = new LightIndicator();
		sensor = SensorFactory.create(SensorType.FILTER_SENSOR);
		plate = new Plate();
		boiler = new Boiler();
	}

	public StartButton getButton() {
		return this.button;
	}
	public IDeviceDriver getLight() {
		return this.light;
	}
	public ISensor getSensor() {
		return sensor;
	}
	public Plate getPlate () {
		return this.plate;
	}
	public Boiler getBoiler() {
		return this.boiler;
	}
}
