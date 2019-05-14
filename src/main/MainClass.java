package main;

public class MainClass {

	public static void main(String[] args) {

		/* **************** */
		/*       MODEL      */
		/* **************** */
		// Whether model is instantiated with or without filter is up to values retrieved from GUI panel.
		/* Filter present */
		//CoffeeMaker model = new CoffeeMaker.Builder().button(new StartButton()).light(new LightIndicator()).filter(filter).build();
		/* No Filter      */
		CoffeeMaker model = new CoffeeMaker.Builder().button(new StartButton()).light(new LightIndicator()).build();
		//model.getBoiler().getSensor().setStatus(BoilerSensorStatus.BOILER_NOT_EMPTY);
		
		
		
		
		/* **************** */
		/*       VIEW       */
		/* **************** */
		// Preliminary steps if necessary.
		CoffeeMakerGui view = new CoffeeMakerGui();
		
		
		
		
		
		/* **************** */
		/*    CONTROLLER    */
		/* **************** */
		CoffeeMakerController controller = new CoffeeMakerController(model, view);
		
		/*
		if (controller.missingComponents()) { // �Is any ingredient missing?
			controller.popup();			// Display all errors found.
		} 
		else {	// If all the ingredients are present, let's start the brewing cycle
			controller.brewCycle();		// Operations during brewing cycle,		
			controller.listen();		// Listen to Pot activities: Out, In w/coffee, In wo/coffee.
		}
		*/
		
	}
	
}