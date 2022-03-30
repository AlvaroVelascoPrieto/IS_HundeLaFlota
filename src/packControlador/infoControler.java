package packControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JRadioButton;

public class infoControler implements ActionListener {
	private static infoControler miControlador;
	private ArrayList<JRadioButton> radibuttons;
	private int tamanoSeleccionado;
	private boolean horizontalSeleccionado;
	private int armaSeleccionada;
	
	private infoControler() {
		this.tamanoSeleccionado = 1;
		this.horizontalSeleccionado = true;
		this.radibuttons = new ArrayList<JRadioButton>();
	}

	public static infoControler getMiInfoControler() {
		if (miControlador==null) {
			miControlador=new infoControler();
		}
		return miControlador;
	}
	
	public void actionPerformed(ActionEvent e) {
		int indexBoton = radibuttons.indexOf(e.getSource());
		if (indexBoton==0) { //Tamano 1
			this.tamanoSeleccionado = 1;
		}
		else if (indexBoton==1) { //Tamano 2
			this.tamanoSeleccionado = 2;
		}
		else if (indexBoton==2) { //Tamano 3
			this.tamanoSeleccionado = 3;
		}
		else if (indexBoton==3) { //Tamano 4
			this.tamanoSeleccionado = 4;
		}
		else if (indexBoton==4) { //Horizontal
			this.horizontalSeleccionado = true;
		}
		else if (indexBoton==5) { 	//Vertical
			this.horizontalSeleccionado = false;
		}
		else if (indexBoton==6) { //Bomba
			this.armaSeleccionada = 1;
		}
		
		else if (indexBoton==7) { //Misil
			this.armaSeleccionada = 2;
		}
		else if (indexBoton==8) { //Escudo
			this.armaSeleccionada = 3;
		}
		else if (indexBoton==9) { //Radar
			this.armaSeleccionada = 4;
		}
	}
	
	public int getTamanoSeleccionado() {
		return this.tamanoSeleccionado;
	}
	
	public boolean getHorizontalSeleccionado(){
		return this.horizontalSeleccionado;
	}
	
	public int getArmaSeleccionada(){
		return this.armaSeleccionada;
	}
	
	public void addRadiButton(JRadioButton pBoton) {
		radibuttons.add(pBoton);
	}

}
