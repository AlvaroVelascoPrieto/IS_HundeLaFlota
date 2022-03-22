package packModelo;


public class Jugador {

	private static Jugador miJugador;
	private Flota miFlota;
	private Armamento armamento;

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

}