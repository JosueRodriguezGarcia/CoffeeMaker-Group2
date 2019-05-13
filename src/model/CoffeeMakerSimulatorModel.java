package model;

public class CoffeeMakerSimulatorModel {
	private CoffeeMakerBuilder coffeeMakerBuilder;
	
	public void simulateCoffeeMaker() {
		coffeeMakerBuilder.buildStartButton();
		coffeeMakerBuilder.buildLightIndicator();
		coffeeMakerBuilder.buildFilter();
		coffeeMakerBuilder.buildPlate();
		coffeeMakerBuilder.buildBoiler();
	}
	
	public void setCoffeeMakerBuilder (CoffeeMakerBuilder coffeeMakerBuilder) {
		this.coffeeMakerBuilder = coffeeMakerBuilder;
	}
	
	public CoffeeMaker getCoffeeMaker() {
		return coffeeMakerBuilder.getCoffeeMaker();
	}
}
