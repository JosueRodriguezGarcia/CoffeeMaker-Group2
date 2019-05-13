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
	final String POT = "resources/pot.png";
	//final String POT_EMPTY = "resources/pot.png";
	//final String POT_NOT_EMPTY = "resources/pot.png";
	final String FILTER = "resources/filter.png";
	final String NOT_WATER = "resources/notWater.png";
	final String WATER = "resources/Water.png";
	final String COFFEE = "resources/coffee.png";
	final String COFFEE_GROUNDS = "resources/coffeeGrounds.png";
	
	final String BREW_STOPPED = "resources/brewStopped.png";
	final String BREW_INPROGRESS = "resources/brewInProgress.png";
	final String BREW_COMPLETED = "resources/brewCompleted.png";
	
	final String POT_UNAVAILABLE = "resources/potUnAvailable.png";
	final String POT_EMPTY = "resources/potEmpty.png";
	final String POT_NOT_EMPTY = "resources/potNotEmpty.png";
	final String POT_INPROGRESS = "resources/potInProgress.png";
	final String POT_COMPLETED = "resources/potCompleted.png";
	
	final String BOILER_NOT_EMPTY = "resources/boilerNotEmpty.png";
	final String BOILER_EMPTY = "resources/boilerEmpty.png";

	final String BOILER_HEADER_ON = "resources/boilerHeaterOn.png";
	final String BOILER_HEADER_OFF = "resources/boilerHeaterOff.png";

	final String PLATE_HEADER_ON = "resources/plateHeaterOn.png";
	final String PLATE_HEADER_OFF = "resources/plateHeaterOff.png";
	
	final String PLATE_HEADER_POT_EMPTY = "resources/potEmpty_plateSensor.png";
	final String PLATE_HEADER_POT_NOT_EMPTY = "resources/potNotEmpty_plateSensor.png";
	final String PLATE_HEADER_WARMER_EMPTY = "resources/warmerEmpty_plateSensor.png";

	// creacion del panel que contenera todos los elementos.
	private JPanel background;

	// Creacion de los diferentes Jlabel
	private JLabel coffeeMaker;
	private JLabel valve;
	private JLabel water;
	private JLabel waterSensor;
	private JLabel plateSensor;	
	private JLabel boiler;
	private JLabel boilerHeader;
	private JLabel plateHeader;
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

	private JMenu boilerHeaderMenu;
	private JMenuItem boilerHeaderOnSubMenu;
	private JMenuItem boilerHeaderOffSubMenu;
	
	private JMenu potMenu;
	private JMenuItem putThePotsubMenu;
	private JMenuItem raisethePotsubMenu;
	private JMenuItem emptyThePotsubMenu;
	private JMenuItem fillThePotSubMenu;
	
	private JMenu plateHeaderMenu;
	private JMenuItem plateHeaderOnSubMenu;
	private JMenuItem plateHeaderOffSubMenu;
	
	private JMenu valveMenu;
	private JMenuItem valveOpenSubMenu;
	private JMenuItem valveCloseSubMenu;
	
	public CoffeeMakerGui() {
		// Inicialiazacion del los elementos
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
		boilerHeader = new JLabel();
		plateHeader = new JLabel();
		
		configMouseIcon();
		
		configCoffeeMakerGui();
		configButton();
		configBrew();	
		configValve();
		configCoffeeGrounds();
		configFilter();
		configPot();
		configBoilerHeader();
		configWaiterSensor();
		configWater();	
		//configCoffee();
		configCoffeMakerMenu();
		configBoiler();
		configBoilerHeader();
		configPlateHeader();
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

		//boiler and its water
		boilerMenu = new JMenu("   Boiler");
		cleanWatersubMenu = new JMenuItem("Clean Water");
		fillWaterSubMenu = new JMenuItem("Fill Water");
		boilerMenu.add(cleanWatersubMenu);
		boilerMenu.add(fillWaterSubMenu);
		coffeeMakerMenu.add(boilerMenu);
		
		//boiler Header
		boilerHeaderMenu = new JMenu("   Boiler Heater");
		boilerHeaderOnSubMenu = new JMenuItem("Turn On");
		boilerHeaderOffSubMenu = new JMenuItem("Turn Off");
		boilerHeaderMenu.add(boilerHeaderOnSubMenu);
		boilerHeaderMenu.add(boilerHeaderOffSubMenu);
		coffeeMakerMenu.add(boilerHeaderMenu);
		
		
		//boiler and its water
		potMenu = new JMenu("   Pot");
		putThePotsubMenu = new JMenuItem("Put an Empty Put");
		raisethePotsubMenu = new JMenuItem("Raise the put");
		fillThePotSubMenu = new JMenuItem("Add coffee");
		emptyThePotsubMenu = new JMenuItem("Empty the coffee");
		potMenu.add(putThePotsubMenu);
		potMenu.add(raisethePotsubMenu);
		potMenu.add(fillThePotSubMenu);
		potMenu.add(emptyThePotsubMenu);
		coffeeMakerMenu.add(potMenu);		
		
		//Plate Header
		plateHeaderMenu = new JMenu("   Pot Heater");
		plateHeaderOnSubMenu = new JMenuItem("Turn On");
		plateHeaderOffSubMenu = new JMenuItem("Turn Off");
		plateHeaderMenu.add(plateHeaderOnSubMenu);
		plateHeaderMenu.add(plateHeaderOffSubMenu);
		coffeeMakerMenu.add(plateHeaderMenu);

		//valve
		valveMenu = new JMenu("   Valve");
		valveOpenSubMenu = new JMenuItem("Open");
		valveCloseSubMenu = new JMenuItem("Close");
		valveMenu.add(valveOpenSubMenu);
		valveMenu.add(valveCloseSubMenu);
		coffeeMakerMenu.add(valveMenu);
	}
	


	public void configPlateSensor() {
		setPlateSensorAsPlateEmpty();
		plateSensor.setBounds(400, 335, 201, 117);
		add(plateSensor);
	}
	
	public void setPlateSensorAsPlateNotEmpty() {
		plateSensor.setIcon(new ImageIcon(PLATE_HEADER_POT_NOT_EMPTY));
	}
	
	public void setPlateSensorAsPlateEmpty() {
		plateSensor.setIcon(new ImageIcon(PLATE_HEADER_POT_EMPTY));
	}
	
	public void setPlateSensorAsWarmerEmpty() {
		plateSensor.setIcon(new ImageIcon(PLATE_HEADER_WARMER_EMPTY));
	}	
	
	public void configBoiler() {
		setFillWater();
		boiler.setBounds(90, 318, 201, 117);
		add(boiler);
	}
	public void configBoilerHeader() {
		setBoilerHeaderOn();
		boilerHeader.setBounds(95, 341, 201, 117);
		add(boilerHeader);
	}
	
	public void configPlateHeader() {
		setPlateHeaderOn();
		plateHeader.setBounds(409, 360, 201, 117);
		add(plateHeader);
	}
	
	public JMenuItem getValveOpenSubMenu() {
		return valveOpenSubMenu;
	}

	public JMenuItem getValveCloseSubMenu() {
		return valveCloseSubMenu;
	}

	public JMenuItem getPutThePotsubMenu() {
		return putThePotsubMenu;
	}

	public JMenuItem getRaisethePotsubMenu() {
		return raisethePotsubMenu;
	}

	public JMenuItem getEmptyThePotsubMenu() {
		return emptyThePotsubMenu;
	}

	public JMenuItem getFillThePotSubMenu() {
		return fillThePotSubMenu;
	}
	
	public void setBoilerHeaderOn() {
		boilerHeader.setIcon(new ImageIcon(BOILER_HEADER_ON));
	}
	public void setBoilerHeaderOff() {
		boilerHeader.setIcon(new ImageIcon(BOILER_HEADER_OFF));
	}
	
	public void setPlateHeaderOn() {
		plateHeader.setIcon(new ImageIcon(PLATE_HEADER_ON));
	}
	public void setPlateHeaderOff() {
		plateHeader.setIcon(new ImageIcon(PLATE_HEADER_OFF));
	}
	
	public JPopupMenu getCoffeeMakerMenu() {
		return coffeeMakerMenu;
	}
	
	public JMenuItem getCleanWaterSubMenu() {
		return cleanWatersubMenu;
	}

	public JMenuItem getFillWaterSubMenu() {
		return fillWaterSubMenu;
	}
	
	

	public JMenuItem getBoilerHeaderOnSubMenu() {
		return boilerHeaderOnSubMenu;
	}

	public JMenuItem getBoilerHeaderOffSubMenu() {
		return boilerHeaderOffSubMenu;
	}
	
	public JMenuItem getPlateHeaderOnSubMenu() {
		return plateHeaderOnSubMenu;
	}

	public JMenuItem getPlateHeaderOffSubMenu() {
		return plateHeaderOffSubMenu;
	}

	public void setWaterSensorAsBoilerNotEmpty() {
		waterSensor.setIcon(new ImageIcon(BOILER_NOT_EMPTY));
	}
	public void setWaterSensorAsBoilerEmpty() {
		waterSensor.setIcon(new ImageIcon(BOILER_EMPTY));
	}
	
	public void setCleanWater() {
		water.setIcon(new ImageIcon(NOT_WATER));
	}

	public void setFillWater() {
		water.setIcon(new ImageIcon(WATER));
	}

	public JButton getStart() {
		return start;
	}

	public void setStart(JButton start) {
		this.start = start;
	}
	
	public JLabel getBrew() {
		return brew;
	}	

	public void setBrewStopped() {
		brew.setIcon(new ImageIcon(BREW_STOPPED));
	}
	
	public void setBrewInProgress() {
		brew.setIcon(new ImageIcon(BREW_INPROGRESS));
	}

	public void setBrewCompleted() {
		brew.setIcon(new ImageIcon(BREW_COMPLETED));
	}
	
	public JLabel getPot() {
		return pot;
	}
	
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
	
	public void setPotCompleted() {
		pot.setIcon(new ImageIcon(POT_COMPLETED));
	}
	
	
	
	public void configBrew() {
		setBrewStopped();
		brew.setBounds(180, 385, 201, 117);
		add(brew);
	}
	
	public void configWaiterSensor() {
		setWaterSensorAsBoilerNotEmpty();
		waterSensor.setBounds(95, 318, 201, 117);
		add(waterSensor);
	}

	public void configCoffeeMakerGui() {
		setTitle("COFFEE MAKER");
		setLayout(null);
		//setBounds(100, 100, 700, 520);
		setSize(700, 520);		
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-this.getSize().width/2, Toolkit.getDefaultToolkit().getScreenSize().height/2-this.getSize().height/2);
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
		filter.setIcon(new ImageIcon(FILTER));
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
/*
	public void configCoffee() {
		coffee.setIcon(new ImageIcon(COFFEE));
		coffee.setBounds(341, 283, 201, 117);
		//add(coffee);
	}
*/
	public JLabel getCoffee() {
		return coffee;
	}

	public void configCoffeeGrounds() {
		coffeeGrounds.setIcon(new ImageIcon(COFFEE_GROUNDS));
		coffeeGrounds.setBounds(399, 170, 89, 33);
		add(coffeeGrounds);
	}

	public void configButton() {
		start.setText("START");
		start.setFocusPainted(false);
		start.setBackground(Color.LIGHT_GRAY);
		start.setBounds(210, 425, 111, 35);
		add(start);		
	}
}
