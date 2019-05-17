package model;

import static org.junit.Assert.*;
import org.junit.Test;

import model.*;

public class CoffeeMakerTest {

	CoffeeMaker coffeemaker = new CoffeeMaker();
	
	@Test
	public void isOn_true_resultTrue() {
		assertTrue(coffeemaker.getButton() instanceof StartButton);
	}

	@Test
	public void getLight_resultLightIndicator() {
		assertTrue(coffeemaker.getLight() instanceof LightIndicator);
	}
	
	@Test
	public void getSensor_resultISensor() {
		assertTrue(coffeemaker.getSensor() instanceof ISensor);
	}

	@Test
	public void getPlate_resultPlate() {
		assertTrue(coffeemaker.getPlate() instanceof Plate);
	}

	@Test
	public void getBoiler_resultBoiler() {
		assertTrue(coffeemaker.getBoiler() instanceof Boiler);
	}
}
