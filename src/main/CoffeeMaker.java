package main;

import java.util.Scanner;

public class CoffeeMaker {
	// boolean isOn;
	private StartButton button;
	private LightIndicator light;
	private Plate plate;
	private Boiler boiler;

	public CoffeeMaker() {
		// isOn = builder.isOn;
		button = new StartButton();
		light = new LightIndicator();
		plate = new Plate();
		boiler = new Boiler();
	}

	public void Start() {
		plate.getSensor().getStatus();

		if (plate.getSensor().getStatus() == 1) {
			button.setStatus(true);
			startPrepared();
			if (drippingCoffee() == true) {
				light.on();
			}
		}

	}

	public void startPrepared() {
		boiler.waterHeating();

	}

	public boolean drippingCoffee() {
		stoppingFlowWater();
		return true;
	}

	public void stoppingFlowWater() {
		boiler.stoppingHeatingWater();
	}
}
