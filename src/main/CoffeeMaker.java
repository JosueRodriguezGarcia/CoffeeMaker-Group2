package main;

public class CoffeeMaker {
	StartButton button;
	DeviceDriver light;
	Filter filter;
	Plate plate;
	Boiler boiler;

	private CoffeeMaker (Builder builder) {
		button = builder.button;
		light = builder.light;
		filter = builder.filter;
		plate = new Plate();
		boiler = new Boiler();
	}





	/* getters & setters */
	public StartButton getButton() {
		return this.button;
	}
	public void setButton(StartButton button) {
		this.button = button;
	}
	public DeviceDriver getLightIndicator() {
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
	public void removeFilter() {
		this.filter = null;
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
		Filter filter;

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
		public Builder filter (Filter filter) { 
			this.filter = filter; 
			return this; 
		}
	}
	/* ***************** */
}
