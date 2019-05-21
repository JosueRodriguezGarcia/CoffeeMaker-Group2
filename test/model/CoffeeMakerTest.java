package model;

import static org.junit.Assert.*;
import org.junit.Test;

public class CoffeeMakerTest {

	CoffeeMaker coffeemaker = new CoffeeMaker();
	
	@Test
	public void getButton_retrieveStartButton_resultStartButton() {
		assertTrue(coffeemaker.getButton() instanceof StartButton);
	}

	@Test
	public void getLight_retrieveLightIndicator_resultLightIndicator() {
		assertTrue(coffeemaker.getLight() instanceof LightIndicator);
	}
	
	@Test
	public void getSensor_retrieveIsensor_resultISensor() {
		assertTrue(coffeemaker.getSensor() instanceof ISensor);
	}

	@Test
	public void getPlate_retrievePlate_resultPlate() {
		assertTrue(coffeemaker.getPlate() instanceof Plate);
	}

	@Test
	public void getBoiler_retrieveBoiler_resultBoiler() {
		assertTrue(coffeemaker.getBoiler() instanceof Boiler);
	}
}
