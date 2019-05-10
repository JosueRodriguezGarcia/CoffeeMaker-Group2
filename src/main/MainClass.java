package main;

public class MainClass {


	public static void main(String[] args) {
		LightIndicator light = new LightIndicator();
		StartButton button = new StartButton();
		PressureValve valve = new PressureValve();
		
		/* You may pass as many parameters as you wish */
		// CoffeeMaker laCafetera = new CoffeeMaker.Builder().light(light).isOn(true).build();

		/* ...or no one! */
		// CoffeeMaker laCafetera = new CoffeeMaker.Builder().build();

		/* Please do keep in mind that the parameter pass to boiler has to be an PressureValve object */
		CoffeeMaker laCafetera = new CoffeeMaker.Builder().button(button).light(light).boiler(valve).build();
		System.out.println("Builder: I'm done, I've just built a coffee maker for you, enjoy it!");
		
		laCafetera.getLightIndicator();
	}
	
	
}
