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
	private String armaAtaqueSeleccionada;
	private String armaDefensaSeleccionada;
	private boolean completa;
	
	private infoControler() {
		this.tamanoSeleccionado = 1;
		this.horizontalSeleccionado = true;
		this.armaAtaqueSeleccionada = "Bomba";
		this.armaDefensaSeleccionada = "Escudo";
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
			this.armaAtaqueSeleccionada = "Bomba";
		}
		else if (indexBoton==7) { //Misil
			System.out.println("CAMBIO");
			this.armaAtaqueSeleccionada = "Misil";
		}
		else if (indexBoton==8) { //Escudo
			this.armaDefensaSeleccionada = "Escudo";
		}
		else if (indexBoton==9) { //Escudo
			this.armaDefensaSeleccionada = "Reparacion";
		}
	}
	
	public int getTamanoSeleccionado() {
		return this.tamanoSeleccionado;
	}
	
	public boolean getHorizontalSeleccionado(){
		return this.horizontalSeleccionado;
	}
	
	public String getArmaAtaqueSeleccionada(){
		return this.armaAtaqueSeleccionada;
	}
	
	public String getArmaDefensaSeleccionada(){
		return this.armaDefensaSeleccionada;
	}
	
	public void addRadiButton(JRadioButton pBoton) {
		radibuttons.add(pBoton);
	}
	
	public void setCompleta(boolean pEstado) {
		completa = pEstado;
	}
	
	public boolean getCompleta() {
		return completa;
	}

}
