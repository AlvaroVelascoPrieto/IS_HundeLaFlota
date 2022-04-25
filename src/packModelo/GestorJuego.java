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
		report.add(jugadores.getJugador().getMiArmamento().getRadar().getActivo());
		report.add(jugadores.getJugador().getMiArmamento().getRadar().getAvistamientos());
		setChanged();
		notifyObservers(report);
	}
	
	public void accionarArmamento(Coordenada pCoord, String pArma) {
		this.jugadores.getJugador().armamento.getRadar().desactivarRadar();
		this.jugadores.getIA().armamento.getRadar().desactivarRadar();
		Arma ataqueJugador = this.jugadores.getJugador().accionarArmamento(pCoord, pArma);
		this.jugadores.getIA().gestionarAtaque(pCoord, ataqueJugador);
		Arma ataqueIA = this.jugadores.getIA().accionarArmamento(null, null);
		Coordenada coordIA = this.jugadores.getIA().determinarAtaque();
		this.jugadores.getJugador().gestionarAtaque(coordIA, ataqueIA);
		ArrayList<Object> report = new ArrayList<Object>();
		report.add(jugadores.getJugador().getMiFlota().getListaBarcos());
		report.add(jugadores.getJugador().getMiFlota().getCompleta());
		report.add(jugadores.getIA().getMiFlota().getListaBarcos());
		report.add(jugadores.getJugador().getMiFlota().getHundida());
		report.add(jugadores.getIA().getMiFlota().getHundida());
		report.add(jugadores.getJugador().getMiArmamento().getRadar().getActivo());
		report.add(jugadores.getJugador().getMiArmamento().getRadar().getAvistamientos());
		setChanged();
		notifyObservers(report);
	}
	
	public void moverRadar() {
		this.jugadores.getJugador().getMiArmamento().getRadar().moverRadar();
		this.jugadores.getIA().getMiArmamento().getRadar().moverRadar();
	}
	
	public void activarRadar() {
		this.jugadores.getJugador().getMiArmamento().getRadar().activarRadar(this.jugadores.getIA().getMiFlota());
		this.jugadores.getIA().usarRadar(this.jugadores.getJugador().getMiFlota());
		ArrayList<Object> report = new ArrayList<Object>();
		report.add(jugadores.getJugador().getMiFlota().getListaBarcos());
		report.add(jugadores.getJugador().getMiFlota().getCompleta());
		report.add(jugadores.getIA().getMiFlota().getListaBarcos());
		report.add(jugadores.getJugador().getMiFlota().getHundida());
		report.add(jugadores.getIA().getMiFlota().getHundida());
		report.add(jugadores.getJugador().getMiArmamento().getRadar().getActivo());
		report.add(jugadores.getJugador().getMiArmamento().getRadar().getAvistamientos());
		setChanged();
		notifyObservers(report);
	}
}