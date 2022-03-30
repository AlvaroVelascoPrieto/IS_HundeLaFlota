package packModelo;

import java.util.ArrayList;
import java.util.Observable;

public class Jugador extends Observable {

	private static Jugador miJugador;
	private Flota miFlota;
	private Armamento armamento;

	private Jugador() {
		this.miFlota = new Flota();
		//this.armamento = new Armamento();
	}

	public static Jugador getMiJugador() {
		if(miJugador==null) {
			miJugador = new Jugador();
		}
		return miJugador;
	}

	public void añadirBarco(Coordenada pCoord, int pTamano, Boolean pHorizontal) {
		this.miFlota.añadirBarco(pCoord, pTamano, pHorizontal);
		setChanged();
		notifyObservers();
	}

	public void accionarArmamento(Coordenada pCoord, String pArma) {
		ArrayList<Arma> misArmas = this.armamento.getLArmas();
		if (pArma.equals("Bomba")) {
			for (Arma arma : misArmas) {
				if (arma instanceof Bomba) {
					this.armamento.borrar(arma);
					IA.getMiIA().gestionarAtaque(pCoord, arma);
					break;
				}
			}
		}
		else if (pArma.equals("Misil")) {
			for (Arma arma : misArmas) {
				if (arma instanceof Misil) {
					this.armamento.borrar(arma);
					IA.getMiIA().gestionarAtaque(pCoord, arma);
					break;
				}
			}
		}
		else if (pArma.equals("Escudo")) {
			//Gestionar escudo
		}
		else {
			//Gestionar radar
		}
		IA.getMiIA().accionarArmamento();
	}

	public void gestionarAtaque(Coordenada pCoord, Arma pArma) {
		ArrayList<Barco> misBarcos = this.miFlota.getListaBarcos();
		if (this.miFlota.contieneBarcoEnPos(pCoord)) {
			if(pArma instanceof Bomba) {
				this.miFlota.getBarcoEnPos(pCoord).tocar(pCoord);
			}
			else if (pArma instanceof Misil) {
				this.miFlota.getBarcoEnPos(pCoord).hundir();	
			}
		}
	}
	
	public Flota getMiFLota() {
		return this.miFlota;
	}

}