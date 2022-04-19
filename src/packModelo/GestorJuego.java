package packModelo;

import java.util.ArrayList;
import java.util.Observable;

public class GestorJuego extends Observable {
	private static GestorJuego miGestorJuego;
	private ListaJugadores jugadores;
	
	private GestorJuego() {
		this.jugadores = new ListaJugadores();
		this.jugadores.anadirJugador(new Jugador());
		this.jugadores.anadirJugador(new IA());
	}
	
	public static GestorJuego getMiGestorJuego() {
		if(miGestorJuego == null) {
			miGestorJuego = new GestorJuego();
		}
		return miGestorJuego;
	}
	
	public void anadirBarco(Coordenada pCoord, int pTamano, boolean pHorizontal) {
		if(jugadores.getJugador().getMiFlota().puedeAnadir(pCoord, pTamano, pHorizontal)) {
			this.jugadores.getJugador().anadirBarco(pCoord, pTamano, pHorizontal);
			this.jugadores.getIA().anadirBarco(null, pTamano, false);
		}
		ArrayList<Object> report = new ArrayList<Object>();
		report.add(jugadores.getJugador().getMiFlota().getListaBarcos());
		report.add(jugadores.getJugador().getMiFlota().getCompleta());
		report.add(jugadores.getIA().getMiFlota().getListaBarcos());
		report.add(jugadores.getJugador().getMiFlota().getHundida());
		report.add(jugadores.getIA().getMiFlota().getHundida());
		setChanged();
		notifyObservers(report);
	}
	
	public void accionarArmamento(Coordenada pCoord, String pArma) {
		Arma ataqueJugador = this.jugadores.getJugador().accionarArmamento(pArma);
		this.jugadores.getIA().gestionarAtaque(pCoord, ataqueJugador);
		Arma ataqueIA = this.jugadores.getIA().accionarArmamento(pArma);
		this.jugadores.getJugador().gestionarAtaque(pCoord, ataqueIA);
		ArrayList<Object> report = new ArrayList<Object>();
		report.add(jugadores.getJugador().getMiFlota().getListaBarcos());
		report.add(jugadores.getJugador().getMiFlota().getCompleta());
		report.add(jugadores.getIA().getMiFlota().getListaBarcos());
		report.add(jugadores.getJugador().getMiFlota().getHundida());
		report.add(jugadores.getIA().getMiFlota().getHundida());
		setChanged();
		notifyObservers(report);
	}
}