package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CoffeeMakerGui extends JFrame {

	final String COFFEE_MAKER = "resources/coffeeMaker.png";
	final String OPEN_VALVE = "resources/open.png";
	final String CLOSED_VALVE = "resources/closed.png";
	final String POT = "resources/pot.png";
	final String POT_EMPTY = "resources/pot.png";
	final String POT_NOT_EMPTY = "resources/pot.png";
	final String FILTER = "resources/filter.png";
	final String NOT_WATER = "resources/notWater.png";
	final String WATER = "resources/Water.png";
	final String COFFEE = "resources/coffee.png";
	final String COFFEE_GROUNDS = "resources/coffeeGrounds.png";

	// creacion del panel que contenera todos los elementos.
	private JPanel background;

	// Creacion de los diferentes Jlabel
	private JLabel coffeeMaker;
	private JLabel valve;
	private JLabel water;
	private JLabel filter;
	private JLabel pot;
	private JLabel coffee;
	private JLabel coffeeGrounds;
	// Creacion del Boton BREW
	private JButton brew;

	public CoffeeMakerGui() {
		// Inicialiazacion del los elementos
		background = new JPanel();
		coffeeMaker = new JLabel();
		valve = new JLabel();
		water = new JLabel();
		filter = new JLabel();
		pot = new JLabel();
		coffee = new JLabel();
		coffeeGrounds = new JLabel();
		brew = new JButton();

		configCoffeeMakerGui();
		configValve();
		configCoffeeGrounds();
		configFilter();
		configPot();
		configWater();
		configButton();
		configCoffee();
		coffeeMakerEvents();
		configCoffeeMaker();

	}

	public void configCoffeeMakerGui() {
		setTitle("COFFEE MAKER");
		setLayout(null);
		setBounds(100, 100, 700, 520);
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
		valve.setIcon(new ImageIcon(OPEN_VALVE));
		valve.setBounds(315, 85, 61, 35);
		add(valve);
	}

	public void configFilter() {
		filter.setIcon(new ImageIcon(FILTER));
		filter.setBounds(395, 157, 299, 59);
		add(filter);
	}

	public void configPot() {
		pot.setIcon(new ImageIcon(POT));
		pot.setBounds(330, 223, 250, 185);
		add(pot);
	}

	public void configWater() {
		water.setIcon(new ImageIcon(NOT_WATER));
		water.setBounds(31, 93, 212, 297);
		add(water);
	}

	public void configCoffee() {
		coffee.setIcon(new ImageIcon(COFFEE));
		coffee.setBounds(341, 283, 201, 117);
		add(coffee);
	}

	public void configCoffeeGrounds() {
		coffeeGrounds.setIcon(new ImageIcon(COFFEE_GROUNDS));
		coffeeGrounds.setBounds(399, 170, 89, 33);
		add(coffeeGrounds);
	}

	public void configButton() {
		brew.setText("BREW");
		brew.setFocusPainted(false);
		brew.setBackground(Color.LIGHT_GRAY);
		brew.setBounds(210, 425, 111, 35);
		add(brew);
	}

	public void placePot() {
		pot.setIcon(new ImageIcon(POT));
	}

	public void coffeeMakerEvents() {
		CoffeMakerEvents events = new CoffeMakerEvents();
		brew.addActionListener(events);
	}

	public static void main(String[] args) {
		new CoffeeMakerGui().setVisible(true);
	}

	class CoffeMakerEvents implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == brew) {
				// pot.setIcon(new ImageIcon(POT_NOT_EMPTY));
				if (brew.getBackground() == Color.LIGHT_GRAY) {
					// placePot();
					brew.setBackground(Color.GREEN);
					// configPot();
				} else {
					brew.setBackground(Color.LIGHT_GRAY);
				}
			}
		}
	}
}
