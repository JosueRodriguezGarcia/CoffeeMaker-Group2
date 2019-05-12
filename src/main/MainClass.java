package main;

public class MainClass {

	public static void main(String[] args) {

		/* **************** */
		/*       MODEL      */
		/* **************** */
		LightIndicator light = new LightIndicator();
		StartButton button = new StartButton();
		Filter filter = new Filter();

		/* Con filtro */
		//CoffeeMaker model = new CoffeeMaker.Builder().button(button).light(light).filter(filter).build();
		/* Sin filtro */
		CoffeeMaker model = new CoffeeMaker.Builder().button(button).light(light).build();



		
		
		/* **************** */
		/*       VIEW       */
		/* **************** */
		// Algunos pasos previos si fuere necesario
		CoffeeMakerGui view = new CoffeeMakerGui();
		
		
		
		
		
		/* **************** */
		/*    CONTROLLER    */
		/* **************** */
		CoffeeMakerController controller = new CoffeeMakerController(model, view);
		
		/* ¿Falta algo? */
		/*
		if (controller.missingComponents()) {
			controller.popup();
		} 
		else {
			controller.brewCycle();
			//controller.listen();
		}
		*/
		
	}
	
}
