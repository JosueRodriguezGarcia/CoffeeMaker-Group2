package main;

public class MainClass {

	public static void main(String[] args) {

		/* **************** */
		/*       MODEL      */
		/* **************** */
		LightIndicator light = new LightIndicator();
		StartButton button = new StartButton();
		Filter filter = new Filter();

		// Si hay o no hay filtro depende de las opciones elegidas en el panel.
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
		
		/*
		if (controller.missingComponents()) { // ¿Is any ingredient missing?
			controller.popup();
		} 
		else {	// If all the ingredients are present, let's start the brewing cycle
			controller.brewCycle();		
			//controller.listen();		// Listen to Pot activities: Out, In w/coffee, In wo/coffee.
		}
		*/
		
	}
	
}
