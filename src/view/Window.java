package view;

import javax.swing.*;

public class Window extends JFrame {

	private JLabel background;
	private JButton button;
	private JLabel pot;
	public Window() {
		setSize(600,450);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		background = new JLabel(new ImageIcon("resources/background.png"));
		pot = new JLabel(new ImageIcon("resources/coffee.png"));
		background.setBounds(0, 0, 600, 400);
		add(background);
		//button=new JButton("hola");
		//button.setBounds(100, 100, 200, 50);
		//add(button);
		pot.setBounds(330, 190, 210, 155);
		add(pot);
		pot.setVisible(true);
		
	}
	public static void main(String[] args) {
		Window w = new Window();
		w.setVisible(true);
	}
	
}
