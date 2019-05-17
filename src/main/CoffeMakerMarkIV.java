package main;

import model.*;
import view.*;
import controller.*;

public class CoffeMakerMarkIV {
	public static void main(String[] args) {
		
		CoffeeMaker myModel = new CoffeeMaker();
		CoffeeMakerGui myView = new CoffeeMakerGui();				
		CoffeeMakerController myController = new CoffeeMakerController(myModel, myView);
		
	}
}
