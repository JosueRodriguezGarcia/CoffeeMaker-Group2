package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.*;

public class CoffeeMarkerTest {
	CoffeeMaker coffee = new CoffeeMaker();
	
	@Test
	public void isOn_false_resultFalse() { 
		assertEquals(false,coffee.isOn());
	}
	@Test
	public void isOn_false_resultTrue() { 
		assertNotEquals(true,coffee.isOn());
	}
	
	
}
