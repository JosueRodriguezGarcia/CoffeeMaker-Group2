package WindowCoffeMaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WindowCoffeeMaker extends JFrame {
	ImageIcon imagen = new ImageIcon("Principal.png");
	JLabel etiqueta = new JLabel(imagen);
	public WindowCoffeeMaker() {
		getContentPane().add(etiqueta);
		this.setSize(600, 450);
	}
	public static void main(String args[]) {
		JFrame WindowTittle = new JFrame("Project - Coffee Maker");
		JMenuBar WindowMenuBar = new JMenuBar();
		JMenu WindowMenu = new JMenu("Help");
		JMenuItem WindowMenuItem = new JMenuItem("About Group2");

		WindowTittle.setSize(600, 500);
		WindowTittle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		WindowTittle.setVisible(true);

		WindowMenu.add(WindowMenuItem);
		WindowMenuBar.add(WindowMenu);
		WindowTittle.setJMenuBar(WindowMenuBar);
		
		WindowCoffeeMaker p = new WindowCoffeeMaker();
		p.show();
		p.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				System.exit(0);
			}
		});
	}
}
