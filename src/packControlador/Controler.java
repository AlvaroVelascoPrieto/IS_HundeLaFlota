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
	private boolean jugando;

	private Controler() {
		jugando = false;
	}

	public static Controler getMiControlador() {
		if (miControlador==null) {
			miControlador=new Controler();
		}
		return miControlador;
	}


	public void actionPerformed(ActionEvent e) {
		if (InterfazJuego.getMiInferfaz().getLabelsJugador().contains(e.getSource())){
			
			System.out.print("pX: ");
			System.out.println(InterfazJuego.getMiInferfaz().getLabelsJugador().indexOf(e.getSource())%10);
			System.out.print("pY: ");
			System.out.println(InterfazJuego.getMiInferfaz().getLabelsJugador().indexOf(e.getSource())/10);
			/*
			if (jugando) { //En juego
				InterfazJuego.getMiInferfaz().getLabelsJugador().get(InterfazJuego.getMiInferfaz().getLabelsJugador().indexOf(e.getSource())).setBackground(Color.BLACK);
			}
			else { //En proceso de colocacion
				if (InterfazJuego.getMiInferfaz().getbotonHorizantal().isSelected()) { //Horizontal
					if (InterfazJuego.getMiInferfaz().getbotonTamano1().isSelected()) { //Tamaño 1
						Coordenada origenBarco = new Coordenada(false,InterfazJuego.getMiInferfaz().getLabelsJugador().indexOf(e.getSource())%10,InterfazJuego.getMiInferfaz().getLabelsJugador().indexOf(e.getSource())/10);
						Jugador.getMiJugador().añadirBarco(origenBarco, 1, true);
					}
					else if (InterfazJuego.getMiInferfaz().getbotonTamano2().isSelected()) { //Tamaño 2
						Coordenada origenBarco = new Coordenada(false,InterfazJuego.getMiInferfaz().getLabelsJugador().indexOf(e.getSource())%10,InterfazJuego.getMiInferfaz().getLabelsJugador().indexOf(e.getSource())/10);
						Jugador.getMiJugador().añadirBarco(origenBarco, 2, true);
					}
					else if (InterfazJuego.getMiInferfaz().getbotonTamano3().isSelected()) { //Tamaño 3
						Coordenada origenBarco = new Coordenada(false,InterfazJuego.getMiInferfaz().getLabelsJugador().indexOf(e.getSource())%10,InterfazJuego.getMiInferfaz().getLabelsJugador().indexOf(e.getSource())/10);
						Jugador.getMiJugador().añadirBarco(origenBarco, 3, true);
					}
					else if (InterfazJuego.getMiInferfaz().getbotonTamano4().isSelected()) { //Tamaño 4
						Coordenada origenBarco = new Coordenada(false,InterfazJuego.getMiInferfaz().getLabelsJugador().indexOf(e.getSource())%10,InterfazJuego.getMiInferfaz().getLabelsJugador().indexOf(e.getSource())/10);
						Jugador.getMiJugador().añadirBarco(origenBarco, 4, true);
					}
					else {
						//Imprimir error
					}
				}
				else if(InterfazJuego.getMiInferfaz().getbotonVertical().isSelected()) { //Vertical
					if (InterfazJuego.getMiInferfaz().getbotonTamano1().isSelected()) { //Tamaño 1
						Coordenada origenBarco = new Coordenada(false,InterfazJuego.getMiInferfaz().getLabelsJugador().indexOf(e.getSource())%10,InterfazJuego.getMiInferfaz().getLabelsJugador().indexOf(e.getSource())/10);
						Jugador.getMiJugador().añadirBarco(origenBarco, 1, false);
					}
					else if (InterfazJuego.getMiInferfaz().getbotonTamano2().isSelected()) { //Tamaño 2
						Coordenada origenBarco = new Coordenada(false,InterfazJuego.getMiInferfaz().getLabelsJugador().indexOf(e.getSource())%10,InterfazJuego.getMiInferfaz().getLabelsJugador().indexOf(e.getSource())/10);
						Jugador.getMiJugador().añadirBarco(origenBarco, 2, false);
					}
					else if (InterfazJuego.getMiInferfaz().getbotonTamano3().isSelected()) { //Tamaño 3
						Coordenada origenBarco = new Coordenada(false,InterfazJuego.getMiInferfaz().getLabelsJugador().indexOf(e.getSource())%10,InterfazJuego.getMiInferfaz().getLabelsJugador().indexOf(e.getSource())/10);
						Jugador.getMiJugador().añadirBarco(origenBarco, 3, false);
					}
					else if (InterfazJuego.getMiInferfaz().getbotonTamano4().isSelected()) { //Tamaño 4
						Coordenada origenBarco = new Coordenada(false,InterfazJuego.getMiInferfaz().getLabelsJugador().indexOf(e.getSource())%10,InterfazJuego.getMiInferfaz().getLabelsJugador().indexOf(e.getSource())/10);
						Jugador.getMiJugador().añadirBarco(origenBarco, 4, false);
					}
					else {
						//Imprimir error
					}
				}
				else { //Ni horizontal ni vertical
					//Imprimir error
				}
			}
			*/
		}
	}

}