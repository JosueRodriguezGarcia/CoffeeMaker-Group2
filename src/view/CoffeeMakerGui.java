package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CoffeeMakerGui extends JFrame {
	
	final String COFFEE_MAKER = "resources/coffeeMaker.png";
	
	final String OPEN_VALVE = "resources/open.png";
	final String CLOSED_VALVE = "resources/closed.png";
	
	final String NOT_WATER = "resources/notWater.png";
	final String WATER_DRAINING = "resources/Water.gif";
	//final String WATER = "resources/boilerWater.gif";
	final String WATER = "resources/Water.png";
	final String WATER_BOILING = "resources/boilerWater.gif";
	final String COFFEE = "resources/coffee.png";
	final String COFFEE_GROUNDS = "resources/coffeeGrounds.png";

	final String BREW_STOPPED = "resources/brewStopped.png";
	final String BREW_INPROGRESS = "resources/brewInProgress.png";
	final String BREW_COMPLETED = "resources/brewCompleted.png";

	final String POT = "resources/pot.png";
	final String POT_UNAVAILABLE = "resources/potUnAvailable.png";
	final String POT_EMPTY = "resources/potEmpty.png";
	final String POT_NOT_EMPTY = "resources/potNotEmpty.png";
	final String POT_INPROGRESS = "resources/potInProgress.png";
	final String POT_COFFEE = "resources/potCoffeeFill.gif";
	final String POT_COMPLETED = "resources/potCompleted.png";

	final String BOILER_NOT_EMPTY = "resources/boilerNotEmpty.png";
	final String BOILER_EMPTY = "resources/boilerEmpty.png";
	
	final String BOILER_HEATER_ON = "resources/boilerHeaterOn.png";
	final String BOILER_HEATER_OFF = "resources/boilerHeaterOff.png";

	final String PLATE_HEATER_ON = "resources/plateHeaterOn.png";
	final String PLATE_HEATER_OFF = "resources/plateHeaterOff.png";

	final String PLATE_SENSOR_POT_EMPTY = "resources/potEmpty_plateSensor.png";
	final String PLATE_SENSOR_POT_NOT_EMPTY = "resources/potNotEmpty_plateSensor.png";
	final String PLATE_SENSOR_WARMER_EMPTY = "resources/warmerEmpty_plateSensor.png";

	final String FILTER = "resources/filter.png";
	final String FILTER_EMPTY = "resources/filterEmpty.png";
	final String FILTER_NOT_EMPTY = "resources/filterNotEmpty.png";
	final String FILTER_RAISED = "";

	// creacion del panel que contenera todos los elementos.
	private JPanel background;

	// Creacion de los diferentes Jlabel
	private JLabel coffeeMaker;
	private JLabel valve;
	private JLabel water;
	private JLabel waterSensor;
	private JLabel plateSensor;
	private JLabel boiler;
	private JLabel boilerHeater;
	private JLabel plateHeater;
	private JLabel filter;
	private JLabel pot;
	private JLabel coffee;
	private JLabel coffeeGrounds;

	// Creacion del Boton START
	public JButton start;

	// Creacion del Label BREW
	public JLabel brew;

	// Menus
	private JPopupMenu coffeeMakerMenu;

	private JMenu boilerMenu;
	private JMenuItem cleanWatersubMenu;
	private JMenuItem fillWaterSubMenu;

	private JMenu boilerHeaterMenu;
	private JMenuItem boilerHeaterOnSubMenu;
	private JMenuItem boilerHeaterOffSubMenu;

	private JMenu potMenu;
	private JMenuItem putThePotsubMenu;
	private JMenuItem raisethePotsubMenu;
	// private JMenuItem emptyThePotsubMenu;
	private JMenuItem fillThePotSubMenu;

	private JMenu filterMenu;
	private JMenuItem putTheFiltersubMenu;
	private JMenuItem raisetheFiltersubMenu;
	private JMenuItem fillTheFilterSubMenu;

	private JMenu plateHeaterMenu;
	private JMenuItem plateHeaterOnSubMenu;
	private JMenuItem plateHeaterOffSubMenu;

	private JMenu valveMenu;
	private JMenuItem valveOpenSubMenu;
	private JMenuItem valveCloseSubMenu;

	public CoffeeMakerGui() {

		// Initialization of varibles.
		background = new JPanel();
		coffeeMaker = new JLabel();
		valve = new JLabel();
		water = new JLabel();
		waterSensor = new JLabel();
		plateSensor = new JLabel();

		filter = new JLabel();
		pot = new JLabel();
		coffee = new JLabel();
		coffeeGrounds = new JLabel();
		start = new JButton();
		brew = new JLabel();
		boiler = new JLabel();
		boilerHeater = new JLabel();
		plateHeater = new JLabel();

		configMouseIcon();
		configCoffeeMakerGui();
		configButton();
		configBrew();
		configValve();
		//configCoffeeGrounds();
		configFilter();
		configPot();
		configBoilerHeater();
		configWaiterSensor();
		configWater();
		configCoffeMakerMenu();
		configBoiler();
		configPlateHeater();
		configPlateSensor();
		configCoffeeMaker();
		setVisible(true);
	}

	public void configMouseIcon() {
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		setCursor(cursor);
	}

	public void configCoffeMakerMenu() {
		coffeeMakerMenu = new JPopupMenu();

		// boiler and its water
		boilerMenu = new JMenu("Boiler");
		cleanWatersubMenu = new JMenuItem("Clean Water");
		fillWaterSubMenu = new JMenuItem("Fill Water");
		boilerMenu.add(cleanWatersubMenu);
		boilerMenu.add(fillWaterSubMenu);
		coffeeMakerMenu.add(boilerMenu);

		// pot and its coffee
		potMenu = new JMenu("Pot");
		putThePotsubMenu = new JMenuItem("Empty Put");
		raisethePotsubMenu = new JMenuItem("Raise the put");
		fillThePotSubMenu = new JMenuItem("Add coffee");
		// emptyThePotsubMenu = new JMenuItem("Empty the coffee");
		potMenu.add(putThePotsubMenu);
		potMenu.add(raisethePotsubMenu);
		potMenu.add(fillThePotSubMenu);
		// potMenu.add(emptyThePotsubMenu);
		coffeeMakerMenu.add(potMenu);

		// filter and coffee grounds
		filterMenu = new JMenu("Filter");
		putTheFiltersubMenu = new JMenuItem("Empty Put");
		raisetheFiltersubMenu = new JMenuItem("Raise the put");
		fillTheFilterSubMenu = new JMenuItem("Add coffee grounds");
		filterMenu.add(putTheFiltersubMenu);
		filterMenu.add(raisetheFiltersubMenu);
		filterMenu.add(fillTheFilterSubMenu);
		coffeeMakerMenu.add(filterMenu);

		// valve
		valveMenu = new JMenu("Valve");
		valveOpenSubMenu = new JMenuItem("Open");
		valveCloseSubMenu = new JMenuItem("Close");
		valveMenu.add(valveOpenSubMenu);
		valveMenu.add(valveCloseSubMenu);
		coffeeMakerMenu.add(valveMenu);
	}

	public void configPlateSensor() {
		setPlateSensorAsPlateEmpty();
		plateSensor.setBounds(415, 395, 60, 23);
		add(plateSensor);
	}

	public void setPlateSensorAsPlateNotEmpty() {
		plateSensor.setIcon(new ImageIcon(PLATE_SENSOR_POT_NOT_EMPTY));
	}

	public void setPlateSensorAsPlateEmpty() {
		plateSensor.setIcon(new ImageIcon(PLATE_SENSOR_POT_EMPTY));
	}

	public void setPlateSensorAsWarmerEmpty() {
		plateSensor.setIcon(new ImageIcon(PLATE_SENSOR_WARMER_EMPTY));
	}

	public void configBoiler() {
		setFillWater();
		boiler.setBounds(90, 318, 201, 117);
		add(boiler);
	}

	public void configBoilerHeater() {
		setBoilerHeaterOff();
		boilerHeater.setBounds(31, 388, 212, 23);
		add(boilerHeater);
	}

	public void configPlateHeater() {
		setPlateHeaterOff();
		plateHeater.setBounds(338, 408, 212, 23);
		add(plateHeater);
	}

	// Valve Getter
	public JMenuItem getValveOpenSubMenu() {
		return valveOpenSubMenu;
	}

	public JMenuItem getValveCloseSubMenu() {
		return valveCloseSubMenu;
	}

	// Pot Getter
	public JMenuItem getPutThePotsubMenu() {
		return putThePotsubMenu;
	}

	public JMenuItem getRaisethePotsubMenu() {
		return raisethePotsubMenu;
	}

	public JMenuItem getFillThePotSubMenu() {
		return fillThePotSubMenu;
	}

	// Filter Getter
	public JMenuItem getPutTheFiltersubMenu() {
		return putTheFiltersubMenu;
	}

	public JMenuItem getRaisetheFiltersubMenu() {
		return raisetheFiltersubMenu;
	}

	public JMenuItem getFillTheFilterSubMenu() {
		return fillTheFilterSubMenu;
	}

	// Boiler Heater Setter
	public void setBoilerHeaterOn() {
		boilerHeater.setIcon(new ImageIcon(BOILER_HEATER_ON));
	}

	public void setBoilerHeaterOff() {
		boilerHeater.setIcon(new ImageIcon(BOILER_HEATER_OFF));
	}

	// Plate Heater Setter
	public void setPlateHeaterOn() {
		plateHeater.setIcon(new ImageIcon(PLATE_HEATER_ON));
	}

	public void setPlateHeaterOff() {
		plateHeater.setIcon(new ImageIcon(PLATE_HEATER_OFF));
	}

	// PopUp Getter
	public JPopupMenu getCoffeeMakerMenu() {
		return coffeeMakerMenu;
	}

	// Boiler Water Getter
	public JMenuItem getCleanWaterSubMenu() {
		return cleanWatersubMenu;
	}

	public JMenuItem getFillWaterSubMenu() {
		return fillWaterSubMenu;
	}
	

	// Boiler Heater Getter
	public JMenuItem getBoilerHeaterOnSubMenu() {
		return boilerHeaterOnSubMenu;
	}

	public JMenuItem getBoilerHeaterOffSubMenu() {
		return boilerHeaterOffSubMenu;
	}

	// Plate Heater Getter
	public JMenuItem getPlateHeaterOnSubMenu() {
		return plateHeaterOnSubMenu;
	}

	public JMenuItem getPlateHeaterOffSubMenu() {
		return plateHeaterOffSubMenu;
	}

	// Boiler Sensor Setter
	public void setWaterSensorAsBoilerNotEmpty() {
		waterSensor.setIcon(new ImageIcon(BOILER_NOT_EMPTY));
	}

	public void setWaterSensorAsBoilerEmpty() {
		waterSensor.setIcon(new ImageIcon(BOILER_EMPTY));
	}

	// Water Setter
	public void setCleanWater() {
		water.setIcon(new ImageIcon(NOT_WATER));
	}

	public void setFillWater() {
		water.setIcon(new ImageIcon(WATER));
	}
	public void setBoilingWater() {
		water.setIcon(new ImageIcon(WATER_BOILING));
	}
	public void setdrainingWater() {
		water.setIcon(new ImageIcon(WATER_DRAINING));
	}

	// Button Getter
	public JButton getStart() {
		return start;
	}

	// Button Setter
	public void setStart(JButton start) {
		this.start = start;
	}

	// Light Getter
	public JLabel getBrew() {
		return brew;
	}

	// Light Setter
	public void setBrewStopped() {
		brew.setIcon(new ImageIcon(BREW_STOPPED));
	}

	public void setBrewInProgress() {
		brew.setIcon(new ImageIcon(BREW_INPROGRESS));
	}

	public void setBrewCompleted() {
		brew.setIcon(new ImageIcon(BREW_COMPLETED));
	}

	// Pot Getter
	public JLabel getPot() {
		return pot;
	}

	// Pot Setter
	public void setPotUnAvailable() {
		pot.setIcon(new ImageIcon(POT_UNAVAILABLE));
	}

	public void setPotEmpty() {
		pot.setIcon(new ImageIcon(POT_EMPTY));
	}

	public void setPotNotEmpty() {
		pot.setIcon(new ImageIcon(POT_NOT_EMPTY));
	}

	public void setPotInProgress() {
		pot.setIcon(new ImageIcon(POT_INPROGRESS));
	}
	public void setPotFill() {
		pot.setIcon(new ImageIcon(POT_COFFEE));
	}
	public void setPotCompleted() {
		pot.setIcon(new ImageIcon(POT_COMPLETED));
	}

	// Filter Getter
	public JLabel getFilter() {
		return filter;
	}

	// Filter Setter
	public void setFilterEmpty() {
		filter.setIcon(new ImageIcon(FILTER_EMPTY));
	}

	public void setFilterNotEmpty() {
		filter.setIcon(new ImageIcon(FILTER_NOT_EMPTY));
	}

	public void setFilterRaised() {
		filter.setIcon(new ImageIcon(FILTER_RAISED));
	}

	public void configBrew() {
		setBrewStopped();
		brew.setBounds(180, 385, 201, 117);
		add(brew);
	}

	public void configWaiterSensor() {
		setWaterSensorAsBoilerNotEmpty();
		waterSensor.setBounds(110, 377, 60, 23);
		add(waterSensor);
	}

	public void configCoffeeMakerGui() {
		setTitle("COFFEE MAKER");
		setLayout(null);
		setSize(700, 520);
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - this.getSize().width / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2 - this.getSize().height / 2);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void configJPanel() {
		background = new JPanel();
		background.setBounds(0, 0, 638, 520);
		add(background);
	}

	public void configCoffeeMaker() {
		coffeeMaker.setIcon(new ImageIcon(COFFEE_MAKER));
		coffeeMaker.setBounds(0, 0, 608, 472);
		add(coffeeMaker);
	}

	public void configValve() {
		setValveClosed();
		valve.setBounds(315, 85, 61, 35);
		add(valve);
	}

	public void setValveOpened() {
		valve.setIcon(new ImageIcon(OPEN_VALVE));
	}

	public void setValveClosed() {
		valve.setIcon(new ImageIcon(CLOSED_VALVE));
	}

	public void configFilter() {
		filter.setIcon(new ImageIcon(FILTER_NOT_EMPTY));
		filter.setBounds(395, 157, 299, 59);
		add(filter);
	}

	public void configPot() {
		setPotEmpty();
		pot.setBounds(330, 223, 250, 185);
		add(pot);
	}

	public void configWater() {
		water.setBounds(31, 93, 212, 297);
		add(water);
	}

	public void placePot() {
		pot.setIcon(new ImageIcon(POT));
	}

	public JLabel getCoffee() {
		return coffee;
	}
/*
	public void configCoffeeGrounds() {
		coffeeGrounds.setIcon(new ImageIcon(COFFEE_GROUNDS));
		coffeeGrounds.setBounds(399, 170, 89, 33);
		add(coffeeGrounds);
	}
*/
	public void configButton() {
		start.setText("START");
		start.setFocusPainted(false);
		start.setBackground(Color.LIGHT_GRAY);
		start.setBounds(210, 425, 111, 35);
		add(start);
	}
}
