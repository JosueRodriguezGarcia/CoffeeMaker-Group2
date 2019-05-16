package controller;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import model.*;
import view.*;

public class CoffeeMakerController {

	private CoffeeMaker model;
	private CoffeeMakerGui view;
	/* ERROR MESSAGE ARRAY FOR SENSOR STATUSES
	 * index 0: [R]elief valve errors string if any, otherwise null
	 * index 1: [B]oiler errors string if any, otherwise null
	 * index 2: [F]ilter errors string if any, otherwise null
	 * index 3: [P]late errors string if any, otherwise null
	 */
	
	private String[] issueReport; 
	public CoffeeMakerController(CoffeeMaker model, CoffeeMakerGui view) {
		this.view = view;
		this.model = model;
		issueReport = new String[4];
		for (int i=0; i<issueReport.length; i++) {
			issueReport[i] = "";
		} 
		addCoffeeMakerListeners();
		// initCoffeeMakerSimulator();
	}

	// Init the CoffeeSimulator
	/*
	 * public void initCoffeeMakerSimulator() { model = new
	 * CoffeeMakerSimulatorModel(); CoffeeMakerBuilder coffeeMakerBuilder = new
	 * MarkIVCoffeeMakerBuilder(); model.setCoffeeMakerBuilder(coffeeMakerBuilder);
	 * CoffeeMaker MarkIVcoffeeMaker = model.getCoffeeMaker(); }
	 */
	// Adding the Mouse Listeners
	public void addCoffeeMakerListeners() {
		// adding Menus events
		view.addMouseListener(new PopupListener());

		// Boiler and its Water
		view.getCleanWaterSubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setCleanWater();
				view.setWaterSensorAsBoilerEmpty();
				model.getBoiler().getSensor().setStatus(BoilerSensorStatus.BOILER_EMPTY);
			}
		});

		view.getFillWaterSubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setFillWater();
				view.setWaterSensorAsBoilerNotEmpty();
				model.getBoiler().getSensor().setStatus(BoilerSensorStatus.BOILER_NOT_EMPTY);
			}
		});

		// Pot
		view.getPutThePotsubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setPotEmpty();
				view.setPlateSensorAsPlateEmpty();
				model.getPlate().getSensor().setStatus(PlateSensorStatus.POT_EMPTY);
				if (model.getLight().getIsOn() == true) {
					view.setPlateHeaterOff();
					model.getPlate().getHeater().off();
				}
			}
		});

		view.getRaisethePotsubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setPotUnAvailable();
				view.setPlateSensorAsWarmerEmpty();
				model.getPlate().getSensor().setStatus(PlateSensorStatus.WARMER_EMPTY);
				if (model.getLight().getIsOn() == true) {
					view.setPlateHeaterOff();
					model.getPlate().getHeater().off();
				}
			}
		});
		view.getFillThePotSubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setPotNotEmpty();
				view.setPlateSensorAsPlateNotEmpty();
				model.getPlate().getSensor().setStatus(PlateSensorStatus.POT_NOT_EMPTY);
				if (model.getLight().getIsOn() == true) {
					view.setPlateHeaterOn();
					model.getPlate().getHeater().on();
				}
			}
		});

		// Filter
		view.getPutTheFiltersubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setFilterEmpty();
				model.getSensor().setStatus(FilterSensorStatus.FILTER_EMPTY);
			}
		});

		view.getRaisetheFiltersubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setFilterRaised();
				model.getSensor().setStatus(FilterSensorStatus.NO_FILTER);
			}
		});
		view.getFillTheFilterSubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setFilterNotEmpty();
				model.getSensor().setStatus(FilterSensorStatus.FILTER_NOT_EMPTY);
			}
		});
		

		// Valve
		view.getValveOpenSubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setValveOpened();
				model.getBoiler().getValve().open();
			}
		});

		view.getValveCloseSubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setValveClosed();
				model.getBoiler().getValve().close();
			}
		});

		// start Button
		view.getStart().addActionListener(new StartButtonListener());
	}

	// Delegating the ContextMenu Listener to the View
	class PopupListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			if (e.isPopupTrigger()) {
				view.getCoffeeMakerMenu().show(e.getComponent(), e.getX(), e.getY());
			}
		}

		public void mouseReleased(MouseEvent e) {
			if (e.isPopupTrigger()) {
				view.getCoffeeMakerMenu().show(e.getComponent(), e.getX(), e.getY());
			}
		}

	}

	private boolean checkValve () {
		boolean missingConditions = true;
		//VALVE CHECK
		if (model.getBoiler().getValve().getIsOpen()) {	// 1. Is the relief valve open?
			issueReport[0] = "Relief valve must be closed!";
		}
		else { 
			issueReport[0] = "";
			missingConditions = false;
		}
		return missingConditions;
	}
	
	private boolean checkBoiler () {
		boolean missingConditions=true;
		//BOILER check
		if (model.getBoiler().getSensor().getStatus() == BoilerSensorStatus.BOILER_EMPTY) { 	// 2. Is the boiler empty?
			issueReport[1] = "Boiler is empty!";
		}
		else {
			issueReport[1] = null;
			issueReport[1] = "";
			missingConditions = false;
		}
		return missingConditions;
	}
	
	private boolean checkFilter () {
		boolean missingConditions=true;
		//FILTER check
		if (model.getSensor().getStatus() == FilterSensorStatus.NO_FILTER) {	// 3. No filter in the coffee maker?
			issueReport[2] = "Filter not present!";
		}
		else {
			if (model.getSensor().getStatus() == FilterSensorStatus.FILTER_EMPTY) {	// 4. No coffee grounds inside the filter?
				issueReport[2] = "No coffee grounds found!";
			}
			else {
				issueReport[2] = "";
				missingConditions = false;
			}
		}
		return missingConditions;
	}
	
	private boolean checkPlate () {
		boolean missingConditions=true;
		//PLATE state check
		if (model.getPlate().getSensor().getStatus() == PlateSensorStatus.WARMER_EMPTY) {	// 5. No pot on the plate/warmer? 
			issueReport[3] = "No pot found!";
		}
		else {
			if (model.getPlate().getSensor().getStatus() == PlateSensorStatus.POT_NOT_EMPTY) {	// 6. Isn't the pot empty?
				issueReport[3] = "Pot is not empty!";
			}
			else {
				issueReport[3] = "";
				missingConditions = false;
			}
		}
		return missingConditions;
	}
	
	private boolean missingComponents() {
		boolean missingBoiler = checkBoiler();
		boolean missingValve = checkValve();
		boolean missingFilter = checkFilter();
		boolean missingPlate = checkPlate();
		
		return (missingBoiler || missingValve || missingFilter || missingPlate);
	}

	private void popUp() {
		JOptionPane.showMessageDialog(null, 
				 issueReport[0]+"\n"
				+issueReport[1]+"\n"
				+issueReport[2]+"\n"
				+issueReport[3]+"\n", "Stop",JOptionPane.INFORMATION_MESSAGE);
	}
	
	// Delegating the StartButton Listener
	class StartButtonListener implements ActionListener {
		JButton startButton;
		boolean isPressed = false;

		@Override
		public void actionPerformed(ActionEvent e) {

			Thread worker = new Thread() {
				public void run() {
					// All here all operations that are in progress
					if (missingComponents()) {
						popUp();
						return;
					} else {
					view.setBrewStopped();
					view.setBoilerHeaterOn();
					view.setBoilingWater();
					model.getBoiler().getHeater().on();
					try {
						Thread.sleep(3000);
					} catch (InterruptedException ex) {
					}
					view.setdrainingWater();
					
					view.setPotFill();
					//view.setPotInProgress();
					try {
						Thread.sleep(3000);
					} catch (InterruptedException ex) {
					}
					
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							// All here all operations that are completed.
							view.setBrewCompleted();
							model.getLight().on();

							view.setPlateSensorAsPlateNotEmpty();
							view.setPotCompleted();
							model.getPlate().getSensor().setStatus(PlateSensorStatus.POT_NOT_EMPTY);

							view.setWaterSensorAsBoilerEmpty();
							view.setCleanWater();
							model.getBoiler().getSensor().setStatus(BoilerSensorStatus.BOILER_EMPTY);

							view.setValveOpened();
							model.getBoiler().getValve().open();

							view.setBoilerHeaterOff();
							model.getBoiler().getHeater().off();

							view.setPlateHeaterOn();
							model.getPlate().getHeater().on();
						}
					});
				}
				}
			};

			worker.start();

		}

		public void setBorder() {
			Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
			Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

			if (isPressed == false) {
				startButton.setBorder(raisedetched);
				// model.getPlate().getSensor().setStatus(0);
				// if (model.getPlate().getSensor().getStatus() == 0) {

				startButton.setBackground(Color.GREEN);

				// }
				isPressed = true;

			} else {
				view.remove(view.getCoffee());
				startButton.setBorder(loweredetched);
				startButton.setBackground(Color.LIGHT_GRAY);
				isPressed = false;
			}
		}
	}

}
