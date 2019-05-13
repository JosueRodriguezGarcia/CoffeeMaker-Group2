package graficos;

import java.awt.Frame;

import javax.swing.*;

public class CreandoMarcos {
	public static void main(String args[]) {
		miMarco marco1=new miMarco();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class miMarco extends JFrame{
	public miMarco() {
//		setSize(600, 400);
//		setLocation(300, 300);
		setBounds(350, 300, 600, 400);
		//anular modificacion de tamaño
		setResizable(false);		
//		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("PROJECT - COFFEE MAKER");
	}
}