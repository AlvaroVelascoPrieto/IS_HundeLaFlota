package packControlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import packModelo.Coordenada;
import packModelo.Jugador;
import packVista.InterfazJuego;

public class Controler implements ActionListener {
	private static Controler miControlador;
	private ArrayList<JButton> tableroJugador;
	private ArrayList<JButton> tableroIA;

	private Controler() {
		tableroJugador = new ArrayList<JButton>();
		tableroIA = new ArrayList<JButton>();
	}

	public static Controler getMiControlador() {
		if (miControlador==null) {
			miControlador=new Controler();
		}
		return miControlador;
	}


	public void actionPerformed(ActionEvent e) {
		if (tableroJugador.contains(e.getSource())){
			System.out.print("pX: ");
			System.out.println(tableroJugador.indexOf(e.getSource())%10);
			System.out.print("pY: ");
			System.out.println(tableroJugador.indexOf(e.getSource())/10);
			Coordenada origenBarco = new Coordenada(false,tableroJugador.indexOf(e.getSource())%10,tableroJugador.indexOf(e.getSource())/10);
			int tamano = infoControler.getMiInfoControler().getTamanoSeleccionado();
			boolean horizontal = infoControler.getMiInfoControler().getHorizontalSeleccionado();
			if (horizontal) { //Horizontal
					Jugador.getMiJugador().anadirBarco(origenBarco, tamano, true);
			}
			else { //Vertical
					Jugador.getMiJugador().anadirBarco(origenBarco, tamano, false);
			}				
		}
		else if (tableroIA.contains(e.getSource())) {
			tableroIA.get(tableroIA.indexOf(e.getSource())).setBackground(Color.BLACK);
			Coordenada origenAccion = new Coordenada(false,tableroIA.indexOf(e.getSource())%10,tableroIA.indexOf(e.getSource())/10);
			String arma = infoControler.getMiInfoControler().getArmaSeleccionada();
			Jugador.getMiJugador().accionarArmamento(origenAccion, arma);
		}
	}
	
	
	public void anadirBotonJugador(JButton pBoton) {
		this.tableroJugador.add(pBoton);
	}
	
	public void anadirBotonIA(JButton pBoton) {
		this.tableroIA.add(pBoton);
	}

}