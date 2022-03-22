package packModelo;

import java.util.Observable;

public class Jugador extends Observable {

	private static Jugador miJugador;
	private Flota miFlota;
	private Armamento armamento;

	private Jugador() {
		// TODO - implement Jugador.Jugador
		
	}

	public static Jugador getMiJugador() {
		if(miJugador==null) {
			miJugador = new Jugador();
		}
		return miJugador;
	}

	/**
	 * 
	 * @param pCoord
	 * @param pTamaño
	 * @param pHorizontal
	 */
	public void añadirBarco(Coordenada pCoord, int pTamaño, Boolean pHorizontal) {
		// TODO - implement Jugador.añadirBarco
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCoord
	 * @param pArma
	 */
	public void accionarArmamento(Coordenada pCoord, String pArma) {
		// TODO - implement Jugador.disparar
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCoord
	 * @param pArma
	 */
	public void gestionarAtaque(Coordenada pCoord, String pArma) {
		// TODO - implement Jugador.gestionarAtaque
		throw new UnsupportedOperationException();
	}
	
	public Flota getMiFLota() {
		return this.miFlota;
	}

}