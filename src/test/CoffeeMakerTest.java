import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoffeeMakerTest {
	CoffeeMaker coffeeMaker;

	@Before
	public void initObject() {
		coffeeMaker = new CoffeeMaker();
	}

	@Test
	public void getStatus_gettingStatus_resultTrue() {
		assertTrue(coffeeMaker.getStatus());
	}

	@Test
	public void setStatus_settingStatus_resultFalse() {
		coffeeMaker.setStatus(false);
		assertFalse(coffeeMaker.getStatus());
	}

	@Test
	public void setStatus_settingStatus_resultTrue() {
		coffeeMaker.setStatus(true);
		assertTrue(coffeeMaker.getStatus());
	}

}
