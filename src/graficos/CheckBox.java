package graficos;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.event.*;

import jdk.nashorn.internal.runtime.regexp.joni.Option;

import javax.swing.JFrame;

public class CheckBox {

	public static void main(String[] args) {
		VentanaCheckBox checkbox = new VentanaCheckBox();
		checkbox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		checkbox.setVisible(true);
		OptionWork op = new OptionWork();
		op.setBounds(0,0,100,200);
		op.setVisible(true);
	}

}

class VentanaCheckBox extends JFrame {
	public VentanaCheckBox() {
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = pantalla.getScreenSize();
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		setBounds(anchoPantalla / 4, alturaPantalla / 4, 600, 400);
		setTitle("VENTANA CHECKBOX");
		// crear icono en ventana
		Image icono = pantalla.getImage("resources/logoTeam2.jpg");
		setIconImage(icono);
	}
}

public class CheckBoxOptions extends JFrame implements ChangeListener {
	private JCheckBox check1, check2, check3, check4;
	public void OptionWork() {
		setLayout(null);
		check1=new JCheckBox("Filtro");
		check1.setBounds(0, 0, 10, 10);
		check1.addChangeListener(this);
		add(check1);
		check2=new JCheckBox("Pot");
		check2.setBounds(0, 10, 10, 10);
		check2.addChangeListener(this);
		add(check2);
		check3=new JCheckBox("Valve");
		check3.setBounds(0, 20, 10, 10);
		check3.addChangeListener(this);
		add(check3);
		check4=new JCheckBox("Boiler");
		check4.setBounds(0, 30, 10, 10);
		check4.addChangeListener(this);
		add(check4);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
	    String cad="";
	    if (check1.isSelected()==true) {
	        cad=cad+"Filtro";
	    }
	    if (check2.isSelected()==true) {
	        cad=cad+"Pot";
	    }
	    if (check3.isSelected()==true) {
	        cad=cad+"Valve";
	    }
	    if (check4.isSelected()==true) {
	        cad=cad+"Boiler";
	    }
	    setTitle(cad);
	}
}


