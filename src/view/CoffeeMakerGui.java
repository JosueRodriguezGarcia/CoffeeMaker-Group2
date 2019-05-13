package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import javafx.scene.image.Image;
import view.CoffeeMakerGui.CoffeMakerEvents;

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

	private JPanel panel_1 = new JPanel();
	private JPanel panel_2 = new JPanel();
	
	private JLabel title_1 = new JLabel();
	private JLabel title_2 = new JLabel();
	private JLabel coffeeMaker = new JLabel();
	private JLabel valve = new JLabel();
	private JLabel water = new JLabel();
	private JLabel filter = new JLabel();
	private JLabel pot = new JLabel();
	private JLabel coffee = new JLabel();
	private JLabel coffeeGrounds = new JLabel();
	
	private JButton brew = new JButton();
	
	private JCheckBox check_1= new JCheckBox();
	private JCheckBox check_2= new JCheckBox();
	private JCheckBox check_3= new JCheckBox();
	private JCheckBox check_4= new JCheckBox();
	
	private CoffeeMakerGui() {

		configPanel1();
		configPanel2();
		configJFrame();
		coffeeMakerEvents();
	}

	private void configPanel1() {

		//panel_1.setBackground(Color.blue);
		panel_1.setBounds(0, 0, 700, 520);
		panel_1.setLayout(null);
		
		
		//coffeeGrounds.setIcon(new ImageIcon(COFFEE_GROUNDS));
		coffeeGrounds.setBounds(399, 170, 89, 33);
		panel_1.add(coffeeGrounds);
		
		//coffee.setIcon(new ImageIcon(COFFEE));
		coffee.setBounds(341, 283, 201, 117);
		panel_1.add(coffee);
		
		water.setIcon(new ImageIcon(NOT_WATER));
		water.setBounds(31, 93, 212, 297);
		panel_1.add(water);
		
		//pot.setIcon(new ImageIcon(POT));
		pot.setBounds(330, 223, 250, 185);
		panel_1.add(pot);
		
		//filter.setIcon(new ImageIcon(FILTER));
		filter.setBounds(395, 157, 299, 59);
		panel_1.add(filter);
		
		valve.setIcon(new ImageIcon(OPEN_VALVE));
		valve.setBounds(315, 85, 61, 35);
		panel_1.add(valve);
		
		coffeeMaker.setIcon(new ImageIcon(COFFEE_MAKER));
		coffeeMaker.setBounds(0, 0, 608, 472);
		panel_1.add(coffeeMaker);
		
		brew.setText("BREW");
		brew.setFocusPainted(false);
		brew.setBackground(Color.LIGHT_GRAY);
		brew.setBounds(210, 425, 111, 35);
		panel_1.add(brew);
		
		add(panel_1);
	}

	private void configPanel2() {

		panel_2.setBackground(Color.yellow);
		panel_2.setBounds(700, 120, 200, 200);
		panel_2.setLayout(null);
		
		title_2.setText("LIST COMPONENT");
		title_2.setHorizontalAlignment(SwingConstants.CENTER);
		title_2.setBounds(0, 0, 200, 30);
		panel_2.add(title_2);
		
		check_1.setText("FILTER");
		check_1.setBackground(Color.yellow);
		check_1.setBounds(0, 50, 200, 30);
		check_2.setText("VALVE");
		check_2.setBackground(Color.yellow);
		check_2.setBounds(0, 80, 200, 30);
		check_3.setText("POT");
		check_3.setBackground(Color.yellow);
		check_3.setBounds(0, 110, 200, 30);
		check_4.setText("WATER");
		check_4.setBackground(Color.yellow);
		check_4.setBounds(0, 140, 200, 30);
		
		panel_2.add(check_1);
		panel_2.add(check_2);
		panel_2.add(check_3);
		panel_2.add(check_4);

	}

	private void configJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 520);
		setTitle("COFFEE MAKER");
		setLayout(null);
		setVisible(true);
		
		add(panel_2);

	}
	public void coffeeMakerEvents() {
		CoffeMakerEvents events = new CoffeMakerEvents();
		//brew.setBackground(Color.BLACK);
		brew.addActionListener(events);
		check_1.addActionListener(events);
		check_2.addActionListener(events);
		check_3.addActionListener(events);
		check_4.addActionListener(events);
	}
	public static void main(String[] args) {
		new CoffeeMakerGui().setVisible(true);
	}
	class CoffeMakerEvents implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == brew) {
				if (brew.getBackground() == Color.LIGHT_GRAY) {
					coffee.setIcon(new ImageIcon(COFFEE));
					brew.setBackground(Color.GREEN);
				} else {
					brew.setBackground(Color.LIGHT_GRAY);
				}
			}
			if(e.getSource() == check_1) {
				if(check_1.isSelected()) {
					filter.setIcon(new ImageIcon(FILTER));
				}else {
					filter.setIcon(new ImageIcon());
				}
				
			}
			if(e.getSource() == check_2) {
				if(check_2.isSelected()) {
					valve.setIcon(new ImageIcon(CLOSED_VALVE));
				}else {
					valve.setIcon(new ImageIcon(OPEN_VALVE));
				}
				
			}
			if(e.getSource() == check_3) {
				if(check_3.isSelected()) {
					pot.setIcon(new ImageIcon(POT_EMPTY));
				}else {
					pot.setIcon(new ImageIcon());
				}
				
			}
			if(e.getSource() == check_4) {
				if(check_4.isSelected()) {
					water.setIcon(new ImageIcon(WATER));
				}else {
					water.setIcon(new ImageIcon(NOT_WATER));
				}
				
			}
			
		}
	}
}

