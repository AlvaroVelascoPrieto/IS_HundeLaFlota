package packModelo;

import java.util.ArrayList;

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
	public void accionarArmamento() {
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
	public void gestionarAtaque(Coordenada pCoord, Arma pArma) {
		if (this.miFlota.contieneBarcoEnPos(pCoord)) {
			if(pArma instanceof Bomba) {
				this.miFlota.getBarcoEnPos(pCoord).tocar(pCoord);
			}
			else if (pArma instanceof Misil) {
				this.miFlota.getBarcoEnPos(pCoord).hundir();	
			}
		}
	}

}