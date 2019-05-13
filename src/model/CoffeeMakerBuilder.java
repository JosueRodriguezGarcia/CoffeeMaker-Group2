package model;

public abstract class CoffeeMakerBuilder {
	protected CoffeeMaker coffeeMaker;
	
	public CoffeeMaker getCoffeeMaker() {
		return coffeeMaker;
	}
	
	public void createCoffeeMaker() {
		coffeeMaker = new CoffeeMaker();
	}
	
	public abstract void buildStartButton();
	public abstract void buildLightIndicator();
	public abstract void buildFilter();
	public abstract void buildPlate();
	public abstract void buildBoiler();
}
