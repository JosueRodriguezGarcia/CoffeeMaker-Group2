package test;
import main.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class CoffeeMarkerTest {
	CoffeeMaker coffee = new CoffeeMaker.Builder().build();
	
	@Test
	public void isOn_false_resultFalse() { 
		assertEquals(false,coffee.getLight().getIsOn());
	}
	@Test
	public void isOn_false_resultTrue() { 
		assertNotEquals(true,coffee.getLight().getIsOn());
	}

}
