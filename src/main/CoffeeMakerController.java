package main;

public class CoffeeMakerController {
	
	String issueReport = "";
	
	CoffeeMaker model;
	CoffeeMakerGui view;

	public CoffeeMakerController (CoffeeMaker model, CoffeeMakerGui view) {
		this.model = model;
		this.view = view;
	}
	
	public boolean missingConditions () {
		boolean missingConditions = true;
		retrieveCheckBox();
		
		if (((PressureValve)model.getBoiler().getValve()).isOpen()) {	// 1. Is the relief valve open?
			issueReport = "Error: Relief valve must be closed prior starting the brewing cycle!";
			missingConditions = true;
		}
		else if (model.getBoiler().getSensor().getStatus() == BoilerSensorStatus.BOILER_EMPTY) { 	// 2. Is the boiler empty?
			issueReport = "Error: Boiler is empty!";
			missingConditions = true;
		}
		else if (model.getFilter() == null) {	// 3. No filter in the coffee maker?
			issueReport = "Error: Filter not present!";
			missingConditions = true;
		}
		else if (!model.getFilter().getGroundsIn()) {	// 4. No coffee grounds inside the filter?
			issueReport = "Error: No coffee grunds found!";
			missingConditions = true;
		}
		else if (model.getPlate().getSensor().getStatus() == PlateSensorStatus.WARMER_EMPTY) {	// 5. No pot on the plate/warmer? 
			issueReport = "Error: No pot found!";
			missingConditions = true;
		}
		else if (model.getPlate().getSensor().getStatus() == PlateSensorStatus.POT_NOT_EMPTY) {	// 6. Isn't the pot empty?
			issueReport = "Error: Pot is empty!";
			missingConditions = true;
		}
		else {
			missingConditions = false;
		}

		return missingConditions;
	}

	public void brewCycle () {
		
	}
	
	public void cycleComplete () {
		model.getPlate().getSensor().setStatus(PlateSensorStatus.POT_NOT_EMPTY);
		model.getPlate().getHeater().on();
	}
	
	public void placePotOut () {
		model.getPlate().getSensor().setStatus(PlateSensorStatus.WARMER_EMPTY);
		model.getPlate().getHeater().off();
	}
	public void placePotIn () {
		retrieveCheckBox();	
		if (model.getPlate().getSensor().getStatus() == PlateSensorStatus.POT_NOT_EMPTY) {
			model.getPlate().getHeater().off();
		}
	}

	public void retrieveCheckBox() {
		// Retrieve and set options from GUI panel.
	}
	
	public void popup () {
		view.issueReport();
	}
	
}

/*VERIFICAR LAS CONDICIONES NECESARIAS
 * 1. ¿Está la válvula abierta?
 *    SI: Añadir mensaje de error.
 *        Marcar bandera missingConditions como true. 
 * 2. NO: ¿Está la caldera sin agua?
 *        SI: Añadir mensaje de error.
 *            Marcar bandera missingConditions como true.
 * 3.     NO: ¿No Hay filtro en la cafetera?
 *            SI: Añadir mensaje de error.
 *                Marcar bandera missingConditions como true.
 * 4.         NO: ¿No hay granos en el filtro?
 *                SI: Añadir mensaje de error.
 *                    Marcar bandera missingConditions como true.
 * 5.             NO: ¿Está el plato sin jarra?
 *                    SI: Añadir mensaje de error.
 *                        Marcar bandera missingConditions como true.
 * 6.                 NO: ¿Hay contenido en la jarra?
 *                        SI: Añadir mensaje de error.
 *                            Marcar bandera missingConditions como true.
 *                        NO: Marcar bandera missingConditions como false.
 * /


/* INICIAR PREPARADO
 * 1. Encender el indicador luminoso.
 * 2. Encender la caldera
 * 3. Animación del preparado.
 * 4. Setear BoilerSensor con BOILER_EMPTY
 * 5. Setear PlateSensor con POT_NOT_EMPTY
 * 6. Apagar el indicador luminoso.
 * 7. Encender el calentador del plato.
 */


/* POST-PREPARADO
 * 
 * MIENTRAS no se cierre la ventana {
 * ¿Escuchar si hay cambios?
 * SI: Recuperar opciones de panel GUI.
 *     ¿La jarra está ausente?
 *     SI: Apagar PlateHeater 
 *     NO: ¿La jarra está vacía?
 *         SI: Apagar PlateHeater
 * }
 * 
 */ 
