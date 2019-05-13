package graficos;

import javax.swing.*;
import java.awt.*;

public class EscrbiendoEnMarco {
	public static void main(String args[]) {
		MarcoConTexto mimarco=new MarcoConTexto();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoConTexto extends JFrame {
	public MarcoConTexto() {
		setVisible(true);
		setBounds(300, 300, 600, 450);
		setTitle("COFFEE MAKER3");
		setResizable(false);
		
		Lamina milamina=new Lamina();
		add(milamina);
	}
}

class Lamina extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Aprendiendo Swing", 100, 100);
	}
}