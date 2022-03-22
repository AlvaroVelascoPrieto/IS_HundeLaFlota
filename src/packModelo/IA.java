package packModelo;


public class IA {

	private static IA miIA;
	private Flota miFlota;

	private IA() {
		// TODO - implement IA.IA
		throw new UnsupportedOperationException();
	}

	public static IA getMiIA() {
		return miIA;
	}

	/**
	 * 
	 * @param pArma
	 */
	public void accionarArmamento(Arma pArma) {
		// TODO - implement IA.disparar
		throw new UnsupportedOperationException();
	}

	private int generarRandomInt() {
		// TODO - implement IA.generarRandomInt
		throw new UnsupportedOperationException();
	}

	private Boolean generarRandomBoolean() {
		// TODO - implement IA.generarRandomBoolean
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCoord
	 * @param pArma
	 */
	public void gestionarAtaque(Coordenada pCoord, String pArma) {
		// TODO - implement IA.gestionarAtaque
		throw new UnsupportedOperationException();
	}

}