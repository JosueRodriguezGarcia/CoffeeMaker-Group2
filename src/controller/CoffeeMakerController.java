package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import model.BoilerSensor;
import model.BoilerSensorStatus;
import model.CoffeeMaker;
import model.CoffeeMakerBuilder;
import model.CoffeeMakerSimulatorModel;
import model.MarkIVCoffeeMakerBuilder;
import model.PlateSensorStatus;
import view.CoffeeMakerGui;

public class CoffeeMakerController {

	private CoffeeMaker model;
	private CoffeeMakerGui view;

	public CoffeeMakerController(CoffeeMaker model, CoffeeMakerGui view) {
		this.view = view;
		this.model = model;
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
			}
		});

		view.getFillWaterSubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setFillWater();
				view.setWaterSensorAsBoilerNotEmpty();
			}
		});
		/*
		 * // Boiler header view.getBoilerHeaderOnSubMenu().addActionListener(new
		 * ActionListener() { public void actionPerformed(ActionEvent e) {
		 * view.setBoilerHeaterOn();
		 * 
		 * } });
		 * 
		 * view.getBoilerHeaderOffSubMenu().addActionListener(new ActionListener() {
		 * public void actionPerformed(ActionEvent e) { view.setBoilerHeaderOff(); } });
		 */
		
		
		// Pot
		view.getPutThePotsubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setPotEmpty();
				view.setPlateSensorAsPlateEmpty();
			}
		});

		view.getRaisethePotsubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setPotUnAvailable();
				view.setPlateSensorAsWarmerEmpty();
			}
		});
		view.getFillThePotSubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setPotNotEmpty();
				view.setPlateSensorAsPlateNotEmpty();
			}
		});

		
		
		// Valve
		view.getValveOpenSubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setValveOpened();
			}
		});

		view.getValveCloseSubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setValveClosed();
			}
		});

		/*
		 * // Plate header view.getPlateHeaderOnSubMenu().addActionListener(new
		 * ActionListener() { public void actionPerformed(ActionEvent e) {
		 * view.setPlateHeaderOn(); } });
		 * 
		 * view.getPlateHeaderOffSubMenu().addActionListener(new ActionListener() {
		 * public void actionPerformed(ActionEvent e) { view.setPlateHeaderOff(); } });
		 */
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
