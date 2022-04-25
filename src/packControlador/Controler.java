package packControlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import packModelo.Coordenada;
import packModelo.GestorJuego;
import packModelo.Jugador;
import packVista.InterfazJuego;

public class Controler implements ActionListener {
	private static Controler miControlador;
	private ArrayList<JButton> tableroJugador;
	private ArrayList<JButton> tableroIA;
	private JButton moverRadar;
	private JButton consultarRadar;
	

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
		if(infoControler.getMiInfoControler().getArmaSeleccionada().equals("Escudo")) {
			System.out.println("e1");
			Coordenada origenAccion = new Coordenada(false,tableroJugador.indexOf(e.getSource())%10,tableroJugador.indexOf(e.getSource())/10);
			GestorJuego.getMiGestorJuego().accionarArmamento(origenAccion, "Escudo");
		}
		else if (tableroJugador.contains(e.getSource())){
			System.out.print("pX: ");
			System.out.println(tableroJugador.indexOf(e.getSource())%10);
			System.out.print("pY: ");
			System.out.println(tableroJugador.indexOf(e.getSource())/10);
			Coordenada origenBarco = new Coordenada(false,tableroJugador.indexOf(e.getSource())%10,tableroJugador.indexOf(e.getSource())/10);
			int tamano = infoControler.getMiInfoControler().getTamanoSeleccionado();
			boolean horizontal = infoControler.getMiInfoControler().getHorizontalSeleccionado();
			if (horizontal) { //Horizontal
					GestorJuego.getMiGestorJuego().anadirBarco(origenBarco, tamano, true);
			}
			else { //Vertical
				GestorJuego.getMiGestorJuego().anadirBarco(origenBarco, tamano, false);
			}				
		}
		else if (tableroIA.contains(e.getSource())) {
			tableroIA.get(tableroIA.indexOf(e.getSource())).setBackground(Color.BLACK);
			Coordenada origenAccion = new Coordenada(false,tableroIA.indexOf(e.getSource())%10,tableroIA.indexOf(e.getSource())/10);
			String arma = infoControler.getMiInfoControler().getArmaSeleccionada();
			GestorJuego.getMiGestorJuego().accionarArmamento(origenAccion, arma);
		}
		else if (e.getSource().equals(this.moverRadar)) {
			GestorJuego.getMiGestorJuego().moverRadar();
		}
		else if (e.getSource().equals(this.consultarRadar)) {
			GestorJuego.getMiGestorJuego().activarRadar();
		}
	}
	
	
	public void anadirBotonJugador(JButton pBoton) {
		this.tableroJugador.add(pBoton);
	}
	
	public void anadirBotonIA(JButton pBoton) {
		this.tableroIA.add(pBoton);
	}
	
	public void registrarMoverRadar(JButton pBoton) {
		this.moverRadar = pBoton;
	}
	
	public void registrarConsultarRadar(JButton pBoton) {
		this.consultarRadar = pBoton;
	}

}