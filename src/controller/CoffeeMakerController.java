package controller;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import model.*;
import view.CoffeeMakerGui;

public class CoffeeMakerController {

	private CoffeeMaker model;
	private CoffeeMakerGui view;
	
	private String[]  issueReport;

	public CoffeeMakerController(CoffeeMaker model, CoffeeMakerGui view) {
		this.view = view;
		this.model = model;
		issueReport = new String[5];
		addCoffeeMakerListeners();
	}

	public void addCoffeeMakerListeners() {
		// adding Menus events
		view.addMouseListener(new PopupListener());

		// Boiler and its Water
		view.getCleanWaterSubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setCleanWater();
				view.setWaterSensorAsBoilerEmpty();
			}
		});

		view.getFillWaterSubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setFillWater();
				view.setWaterSensorAsBoilerNotEmpty();
			}
		});

		// Boiler header
		view.getBoilerHeaderOnSubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setBoilerHeaterOn();
				model.getBoiler().getHeater().on();

			}
		});

		view.getBoilerHeaderOffSubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setBoilerHeaderOff();
				model.getBoiler().getHeater().off();
			}
		});

		// Pot
		view.getPutThePotsubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setPotEmpty();
				model.getPlate().getSensor().setStatus(PlateSensorStatus.POT_EMPTY);
			}
		});

		view.getRaisethePotsubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setPotUnAvailable();
				model.getPlate().getSensor().setStatus(PlateSensorStatus.WARMER_EMPTY);
			}
		});

		view.getEmptyThePotsubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setPotNotEmpty();
				model.getPlate().getSensor().setStatus(PlateSensorStatus.POT_NOT_EMPTY);
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

		// Plate header
		view.getPlateHeaderOnSubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setPlateHeaderOn();
				model.getPlate().getHeater().on();
			}
		});

		view.getPlateHeaderOffSubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setPlateHeaderOff();
				model.getPlate().getHeater().off();
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

	// Delegating the StartButton Listener
	class StartButtonListener implements ActionListener {
		JButton startButton;
		boolean isPressed = false;

		@Override
		public void actionPerformed(ActionEvent e) {

			Thread worker = new Thread() {
				public void run() {
					// All here all operations that are in progress
					view.setPotInProgress();
					view.setBoilerHeaterOn();
					model.getBoiler().getHeater().on();
					try {
						Thread.sleep(3000);
					} catch (InterruptedException ex) {
					}

					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							// All here all operations that are completed.
							verificacion();
							setValues();
							brewing();

						}
						private void setValues() {
							
							
							
								
						}
						private void popUp() {
							JOptionPane.showMessageDialog(null, 
									issueReport[0]+"\n"
									+issueReport[1]+"\n"
									+issueReport[2]+"\n"
									+issueReport[3]+"\n"
									+issueReport[4]+"\n", "Stop",JOptionPane.INFORMATION_MESSAGE);
						}
						
						private boolean verificacion() {
							boolean missingConditions = true;
							
							//retrieveCheckBox();
							if (model.getBoiler().getValve().getIsOpen()) {	// 1. Is the relief valve open?
								issueReport[0] = "Relief valve must be closed prior starting the brewing cycle!";
								missingConditions &= false;
							}
							else { 
								issueReport[0] = null;
							}
								
							if (model.getBoiler().getSensor().getStatus() == BoilerSensorStatus.BOILER_EMPTY) { 	// 2. Is the boiler empty?
								issueReport[0] = "Boiler is empty!";
								missingConditions &= false;
							}
							else {
								issueReport[0] = "";
							}
							
							if (model.getSensor().getStatus() == FilterSensorStatus.NO_FILTER) {	// 3. No filter in the coffee maker?
								issueReport[1] = "Filter not present!";
								missingConditions &= false;
							}
							else {
								issueReport[1] = "";
							}
							if (model.getSensor().getStatus() == FilterSensorStatus.FILTER_EMPTY) {	// 4. No coffee grounds inside the filter?
								issueReport[1] = "No coffee grunds found!";
								missingConditions &= false;
							}
							else {
								issueReport[1] = "";
							}
							
							if (model.getPlate().getSensor().getStatus() == PlateSensorStatus.WARMER_EMPTY) {	// 5. No pot on the plate/warmer? 
								issueReport[2] = "No pot found!";
								missingConditions &= false;
							}
							else {
								issueReport[2] = "";
							}
							if (model.getPlate().getSensor().getStatus() == PlateSensorStatus.POT_NOT_EMPTY) {	// 6. Isn't the pot empty?
								issueReport[2] = "Pot is empty!";
								missingConditions &= false;
							}
							else {
								issueReport[2] = "";
							}
							
							return missingConditions;
						}

						private void brewing() {
							view.setBrewCompleted();
							model.getLight().on();

							view.setPotCompleted();
							model.getPlate().getSensor().setStatus(PlateSensorStatus.POT_NOT_EMPTY);

							view.setWaterSensorAsBoilerEmpty();
							view.setCleanWater();
							model.getBoiler().getSensor().setStatus(BoilerSensorStatus.BOILER_EMPTY);

							view.setValveOpened();
							model.getBoiler().getValve().close();

							view.setBoilerHeaderOff();
							model.getBoiler().getHeater().off();

							view.setPlateHeaderOn();
							model.getPlate().getHeater().on();

							popUp();
						}
					});
				}
			};

			worker.start();

		}

		public void setBorder() {
			Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
			Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

			if (isPressed == false) {
				startButton.setBorder(raisedetched);
				startButton.setBackground(Color.GREEN);
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
