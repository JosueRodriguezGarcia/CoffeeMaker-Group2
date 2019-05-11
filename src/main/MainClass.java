package main;

public class MainClass {

	public static void main(String[] args) {

		/* **************** */
		/*       MODEL      */
		/* **************** */
		LightIndicator light = new LightIndicator();
		StartButton button = new StartButton();
		PressureValve valve = new PressureValve();
		
		/* You may pass as many parameters as you wish */
		// CoffeeMaker laCafetera = new CoffeeMaker.Builder().light(light).isOn(true).build();

		/* ...or no one! */
		// CoffeeMaker laCafetera = new CoffeeMaker.Builder().build();

		/* Please do keep in mind that the parameter passed to boiler has to be a PressureValve object */
		CoffeeMaker model = new CoffeeMaker.Builder().button(button).light(light).boiler(valve).build();
		System.out.println("Builder: I'm done, I've just built a coffee maker for you, enjoy it!");

		
		
		
		
		/* **************** */
		/*       VIEW       */
		/* **************** */
		// Algunos pasos previos si fuere necesario
		//CoffeeMakerGui view = new CoffeeMakerGui();
		
		
		
		
		
		/* **************** */
		/*    CONTROLLER    */
		/* **************** */
		//CoffeeMakerController controller = new CoffeeMakerController(model, view)
		
		/* Aqui todo el proceso */
		//controller.tantosTantos();   // <--- Aqui la logica: metodos de controlar que consultan y settean al model y que actualizan el estado del view
		//controller.otrosOtros();     // <--- aqui la logica: metodos de controlar que consultan y settean al model y que actualizan el estado del view
		//controller.unosUnos();       // <--- aqui la logica: metodos de controlar que consultan y settean al model y que actualizan el estado del view
		//controller.pocosPocos();     // <--- aqui la logica: metodos de controlar que consultan y settean al model y que actualizan el estado del view
		
	}

}
