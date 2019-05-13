package view;

import java.awt.Color;

import javax.swing.*;

public class Window extends JFrame {

	private JLabel background;
	private JLabel pot;
	
	private JPanel panel;

	
	public Window() {
		setSize(600 ,450);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setSize(700, 700);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		add(panel);
		
		
		background = new JLabel();
		background.setIcon(new ImageIcon("resources/background.png"));
		background.setBounds(0, 0, 510, 396);
		panel.add(background);

		
		pot = new JLabel();
		pot.setIcon(new ImageIcon("Principal.png"));
		pot.setBounds(280, 187, 210, 155);
		pot.setBorder(null);
		panel.add(pot);

		
	}
	public static void main(String[] args) {
		new Window().setVisible(true);
	}
	
}
