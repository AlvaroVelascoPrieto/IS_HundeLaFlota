package packModelo;

import java.util.Observable;

public class Jugador extends Observable {

	private static Jugador miJugador;
	private Flota miFlota;

	private Jugador() {
		// TODO - implement Jugador.Jugador
		throw new UnsupportedOperationException();
	}

	public static Jugador getMiJugador() {
		return miJugador;
	}

	/**
	 * 
	 * @param pCoord
	 * @param pTama�o
	 * @param pHorizontal
	 */
	public void a�adirBarco(Coordenada pCoord, int pTama�o, Boolean pHorizontal) {
		// TODO - implement Jugador.a�adirBarco
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCoord
	 */
	public void disparar(Coordenada pCoord) {
		// TODO - implement Jugador.disparar
		throw new UnsupportedOperationException();
	}

}