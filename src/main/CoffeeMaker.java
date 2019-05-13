package main;

public class CoffeeMaker {
	StartButton button;
	IDeviceDriver light;
	ISensor sensor;
	Plate plate;
	Boiler boiler;

	private CoffeeMaker (Builder builder) {
		button = new StartButton();
		light = new LightIndicator();
		sensor = new FilterSensor();
		plate = new Plate();
		boiler = new Boiler();
	}





	/* getters & setters */
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
	/* ***************** */




	/* Mr. Builder */
	public static class Builder {
		StartButton button;
		LightIndicator light;
		FilterSensor sensor;

		public CoffeeMaker build() {
			return new CoffeeMaker(this);
		}
		
		public Builder () {
		}
		
		public Builder button (StartButton button) { 
			this.button = button; 
			return this; 
		}
		public Builder light (LightIndicator light) { 
			this.light = light; 
			return this; 
		}
		public Builder sensor (FilterSensor sensor) { 
			this.sensor = sensor; 
			return this; 
		}
	}
}
