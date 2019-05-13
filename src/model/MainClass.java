package model;

public class MainClass {

	public static void main2(String[] args) {

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
/*
		/* Please do keep in mind that the parameter passed to boiler has to be a PressureValve object 
		CoffeeMaker model = new CoffeeMaker.Builder().button(button).light(light).build();
		System.out.println("Builder: I'm done, I've just built a coffee maker for you, enjoy it!");

		
		/* EJEMPLO BASICO de proceso que deberia estar dentro de los metodos de CONTROLLER */
	//	model.getIsOn();  	// preguntar si estar prendido y demas...
	//	model.getBoiler().getValve().isOpen();	// preguntar si la valvula esta cerrada, y... demas    pop-up nuevamente al panel
	//	model.getBoiler().getSensor().getStatus(); // pregutnar si la caldera esta llena ... y demas
		//verificar filtro --> si hay granos
		
	//	model.getPlate().getSensor().getStatus();	// preguntar si hay POT y que esta vacio? ... y demas
		//
	//	model.getLightIndicator().on();	// si todo esta bien, prender la luz e iniciar el proceso
		// view.animate();
		//encender calentador
		//verificar si esta lleno;
		//
	//	model.getLightIndicator().off();	// una vez terminado el proceso apagar la luz
		//
		// prender calentador del plato
		// averigurar retiros del pot, por ejemplo cuando la gente se sirve y luego devuelve el pot, puede devolver lleno, o no lleno, considerar eso tambien.
		/* ************************************************************************ */
		
		
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
