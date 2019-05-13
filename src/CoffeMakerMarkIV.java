import controller.CoffeeMakerController;
import model.CoffeeMaker;
import model.CoffeeMakerSimulatorModel;
import view.CoffeeMakerGui;

public class CoffeMakerMarkIV {
	public static void main(String[] args) {
		CoffeeMakerSimulatorModel myModel = new CoffeeMakerSimulatorModel();
		CoffeeMakerGui myView = new CoffeeMakerGui();				
		CoffeeMakerController myController = new CoffeeMakerController(myModel, myView);
		//adding behavior
	}
}
