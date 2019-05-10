package main;

public class MainClass {


	public static void main(String[] args) {
		LightIndicator light = new LightIndicator();
		
		// CoffeeMaker laCafetera = new CoffeeMaker.Builder().light(light).isOn(true).build();
		CoffeeMaker laCafetera = new CoffeeMaker.Builder().build();
		System.out.println("Builder: I'm done, I've just built a coffee maker for you, enjoy it!");
		
		laCafetera.getLightIndicator();
	}
	
	
}
