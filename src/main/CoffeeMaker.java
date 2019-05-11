package main;

public class CoffeeMaker {
	boolean isOn;
	boolean groundsIn;
	StartButton button;
	LightIndicator light;
	Plate plate;
	Boiler boiler;

	private CoffeeMaker (Builder builder) {
		isOn = builder.isOn;
		groundsIn = builder.groundsIn;
		button = builder.button;
		light = builder.light;
		plate = new Plate();
		boiler = new Boiler();
	}





	/* getters & setters */
	public boolean getIsOn() {
		return isOn;
	}
	public void setIsOn(boolean isOn) {
		this.isOn = isOn;
	}
	public boolean getGroundsIn() {
		return isOn;
	}
	public void setGroundsIn(boolean groundsIn) {
		this.groundsIn = groundsIn;
	}
	public StartButton getButton() {
		return this.button;
	}
	public void setButton(StartButton button) {
		this.button = button;
	}
	public LightIndicator getLightIndicator() {
		return this.light;
	}
	public void setLightIndicator(LightIndicator light) {
		this.light = light;
	}
	public Plate getPlate () {
		return this.plate;
	}
	public void setPlate(Plate plate) {
		this.plate = plate;
	}
	public Boiler getBoiler() {
		return this.boiler;
	}
	public void setBoiler(Boiler boiler) {
		this.boiler = boiler;
	}
	/* ***************** */




	/* Mr. Builder */
	public static class Builder {
		boolean isOn;
		boolean groundsIn;
		StartButton button;
		LightIndicator light;
		Boiler boiler;

		public CoffeeMaker build() {
			return new CoffeeMaker(this);
		}
		
		public Builder () {
			isOn = false;
			groundsIn = false;
		}
		
		public Builder isOn (boolean isOn) { 
			this.isOn = isOn; 
			return this; 
		}
		public Builder groundsIn (boolean groundsIn) { 
			this.groundsIn = groundsIn; 
			return this; 
		}
		public Builder button (StartButton button) { 
			this.button = button; 
			return this; 
		}
		public Builder light (LightIndicator light) { 
			this.light = light; 
			return this; 
		}
	}
	/* ***************** */
}
