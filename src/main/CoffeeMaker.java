package main;

public class CoffeeMaker {
	boolean isOn;
	StartButton button;
	LightIndicator light;
	Filter filter;
	Plate plate;
	Boiler boiler;

	private CoffeeMaker (Builder builder) {
		isOn = builder.isOn;
		button = builder.button;
		light = builder.light;
		filter = builder.filter;
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
	public Filter getFilter() {
		return filter;
	}
	public void setFilter(Filter filter) {
		this.filter = filter;
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
		StartButton button;
		LightIndicator light;
		Filter filter;

		public CoffeeMaker build() {
			return new CoffeeMaker(this);
		}
		
		public Builder () {
			isOn = false;
		}
		
		public Builder isOn (boolean isOn) { 
			this.isOn = isOn; 
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
		public Builder filter (Filter filter) { 
			this.filter = filter; 
			return this; 
		}
	}
	/* ***************** */
}
