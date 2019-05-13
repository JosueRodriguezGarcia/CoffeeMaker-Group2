package graficos;

import java.awt.*;

import javax.swing.*;

public class CreandoSegundoMarco {
	public static void main(String args[]) {
		SegundoMarco mimarco = new SegundoMarco();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}
}

class SegundoMarco extends JFrame {
	public SegundoMarco() {
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = mipantalla.getScreenSize();
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		setBounds(anchoPantalla / 4, alturaPantalla / 4, 600, 400);
		setTitle("COFFEE MAKER2");
		//crear icono en ventana
		Image miIcono=mipantalla.getImage("resources/logoTeam2.jpg");
		setIconImage(miIcono);
	}
}