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

import model.CoffeeMaker;
import model.CoffeeMakerBuilder;
import model.CoffeeMakerSimulatorModel;
import model.MarkIVCoffeeMakerBuilder;
import view.CoffeeMakerGui;

public class CoffeeMakerController {
	
	private CoffeeMakerSimulatorModel coffeeMakerSimulator;
	private CoffeeMakerGui view;

	public CoffeeMakerController(CoffeeMakerSimulatorModel model, CoffeeMakerGui view) {
		this.view = view;
		addCoffeeMakerListeners();
		initCoffeeMakerSimulator();
	}
	
	// Init the CoffeeSimulator
	public void initCoffeeMakerSimulator() {
		coffeeMakerSimulator = new CoffeeMakerSimulatorModel();
		CoffeeMakerBuilder coffeeMakerBuilder = new MarkIVCoffeeMakerBuilder(); 
		coffeeMakerSimulator.setCoffeeMakerBuilder(coffeeMakerBuilder);
		CoffeeMaker MarkIVcoffeeMaker = coffeeMakerSimulator.getCoffeeMaker();
	}	
	
	// Adding the Mouse Listeners 
	public void addCoffeeMakerListeners() {		
		//adding Menus events
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
				
		    }
		});
		
		view.getBoilerHeaderOffSubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setBoilerHeaderOff();
		    }
		});
			
		//Pot
		view.getPutThePotsubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setPotEmpty();
		    }
		});
		
		view.getRaisethePotsubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setPotUnAvailable();
		    }
		});
		
		view.getEmptyThePotsubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setPotEmpty();
		    }
		});
		
		view.getFillThePotSubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setPotNotEmpty();
		    }
		});
		
		
		//Valve
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
		
		
		// Plate header
		view.getPlateHeaderOnSubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setPlateHeaderOn();
		    }
		});
		
		view.getPlateHeaderOffSubMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setPlateHeaderOff();
		    }
		});
		
		// start Button 
		view.getStart().addActionListener(new StartButtonListener());
	}

	// Delegating the ContextMenu Listener to the View
	class PopupListener extends MouseAdapter {
	      public void mousePressed(MouseEvent ev) {
	    	  if (ev.isPopupTrigger()) {
	    		  view.getCoffeeMakerMenu().show(ev.getComponent(), ev.getX(), ev.getY());
	    	  }
	      }

	      public void mouseReleased(MouseEvent ev) {
	    	  if (ev.isPopupTrigger()) {
	    		  view.getCoffeeMakerMenu().show(ev.getComponent(), ev.getX(), ev.getY());
	    	  }
	      }

	      public void mouseClicked(MouseEvent ev) {
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
        	  //All here all operations that are in progress
        	  view.setPotInProgress();        	  
            try {
              Thread.sleep(3000);
            } catch (InterruptedException ex) {
            }

            SwingUtilities.invokeLater(new Runnable() {
              public void run() {
            	  //All here all operations that are completed.
            	  view.setBrewCompleted();
            	  view.setPotCompleted();
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
				//model.getPlate().getSensor().setStatus(0);
				//if (model.getPlate().getSensor().getStatus() == 0) {

					startButton.setBackground(Color.GREEN);

				//}
				isPressed = true;

			} else {
				view.remove(view.getCoffee());
				startButton.setBorder(loweredetched);
				startButton.setBackground(Color.LIGHT_GRAY);
				isPressed = false;
			}
		}
	}
	

	/*
	public void waterHeating(){
		if (model.getBoiler().getSensor().getStatus() == 1) {
			model.getBoiler().getValve().open();
			model.getBoiler().getHeater().on();			
		}
	}
	
	*/
	/*
	public void stoppingHeatingWater() {
		model.getBoiler().getValve().isOpen();
		model.getBoiler().getHeater().off();
	}
	*/	
	/*
	void warmingPot() {
		if (model.getPlate().getSensor().getStatus() == 2) {
			model.getPlate().getHeater().on();
		}
	}
/*
	// ****
	void puttingPot() {
		model.getPlate().getSensor().setStatus(1);
	}

	void removingPot() {
		model.getPlate().getSensor().setStatus(0);
	}

	void stopWarmingPot() {
		model.getPlate().getHeater().off();
	}
	
	//CoffeeMaker
	
	public void Start() {
		model.getPlate().getSensor().getStatus();

		if (model.getPlate().getSensor().getStatus() == 0 ) {
			model.getButton().setIsPushed(true);
			view.configButton();
			startPrepared();
			if (drippingCoffee() == true) {
				view.placePot();
				view.configCoffee();
				view.configFilter();
				model.getLightIndicator().on();
			}
		}

	}

	public void startPrepared() {
		if (model.getBoiler().getSensor().getStatus() == 1) {
			model.getBoiler().getValve().open();
			model.getBoiler().getHeater().on();			
		}
	}

	public boolean drippingCoffee() {
		stoppingFlowWater();
		return true;
	}

	public void stoppingFlowWater() {
		model.getBoiler().getValve().isOpen();
		model.getBoiler().getHeater().off();
		
	}

	public void verificar() {
	}

	public void comenzar() {

	}

	public void reportarProblema() {

	}
*/
}
