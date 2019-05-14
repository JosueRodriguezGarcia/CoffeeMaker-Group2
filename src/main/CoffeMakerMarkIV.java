package main;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import controller.CoffeeMakerController;
import model.CoffeeMaker;
import model.CoffeeMakerSimulatorModel;
import view.CoffeeMakerGui;

public class CoffeMakerMarkIV {
	public static void main(String[] args) {
		
		CoffeeMaker myModel = new CoffeeMaker();
		CoffeeMakerGui myView = new CoffeeMakerGui();				
		CoffeeMakerController myController = new CoffeeMakerController(myModel, myView);
		
	}
}
