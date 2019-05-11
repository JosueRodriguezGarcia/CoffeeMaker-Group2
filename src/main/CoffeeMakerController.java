package main;

public class CoffeeMakerController {
	
	String issueReport = "";
	
	CoffeeMaker model;
	CoffeeMakerGui view;

	public CoffeeMakerController (CoffeeMaker model, CoffeeMakerGui view) {
		this.model = model;
		this.view = view;
	}
	
	public boolean missingComponents () {
		boolean missingComponents = true;  
		if (model.getBoiler().getValve().isOpen()) {
			issueReport = "Error: Relief valve must be closed prior starting the brewing cycle!";
			missingComponents = true;
		}
		else if (model.getBoiler().getSensor().getStatus() == BoilerSensor.BOILER_EMPTY) { 
			issueReport = "Error: Boiler is empty!";
			missingComponents = true;
		}
		else if (model.getFilter() == null) {
			issueReport = "Error: Filter not present!";
			missingComponents = true;
		}
		else if (!model.getFilter().getGroundsIn()) {
			issueReport = "Error: No coffee grunds found!";
			missingComponents = true;
		}
		else if (model.getPlate().getSensor().getStatus() == PlateSensor.WARMER_EMPTY) {
			issueReport = "Error: No pot found!";
			missingComponents = true;
		}
		else if (model.getPlate().getSensor().getStatus() == PlateSensor.POT_EMPTY) {
			issueReport = "Error: Pot is empty!";
			missingComponents = true;
		}
		return missingComponents;
	}

	public void startBrew () {
		
	}

	public void popup () {
		view.issueReport();
	}
	
}




/* EJEMPLO BASICO de proceso que deberia estar dentro de los metodos de CONTROLLER */
//model.getIsOn();  	// ya no
//model.getBoiler().getValve().isOpen();	// preguntar si la valvula esta cerrada, y... demas    pop-up nuevamente al panel
//model.getBoiler().getSensor().getStatus(); // pregutnar si la caldera esta llena ... y demas
//verificar filtro --> si hay granos

//model.getPlate().getSensor().getStatus();	// preguntar si hay POT y que esta vacio? ... y demas
//
//model.getLightIndicator().on();	// si todo esta bien, prender la luz e iniciar el proceso
// view.animate();
//encender calentador
//verificar si esta lleno;
//
//model.getLightIndicator().off();	// una vez terminado el proceso apagar la luz
//
// prender calentador del plato
// averigurar retiros del pot, por ejemplo cuando la gente se sirve y luego devuelve el pot, puede devolver lleno, o no lleno, considerar eso tambien.
/* ************************************************************************ */
