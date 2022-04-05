package packModelo;

import java.util.ArrayList;
import java.util.Observable;

public class Jugador extends Observable {

	private static Jugador miJugador;
	private Flota miFlota;
	private Armamento armamento;

	private Jugador() {
		this.miFlota = new Flota();
		this.armamento = new Armamento();
	}

	public static Jugador getMiJugador() {
		if(miJugador==null) {
			miJugador = new Jugador();
		}
		return miJugador;
	}

	public void anadirBarco(Coordenada pCoord, int pTamano, Boolean pHorizontal) {
		if (this.miFlota.puedeAnadir(pCoord, pTamano, pHorizontal)) {
			this.miFlota.añadirBarco(pCoord, pTamano, pHorizontal);
			IA.getMiIA().anadirBarco(pTamano);
			this.miFlota.comprobarCompleta();
			setChanged();
			notifyObservers();
		}
	}

	public void accionarArmamento(Coordenada pCoord, String pArma) {
		if (pArma.equals("Bomba")) {
			if(this.armamento.armaDisponible(pArma)) {
				this.armamento.borrar(pArma);
				IA.getMiIA().gestionarAtaque(pCoord, pArma);	
			}
		}
		else if (pArma.equals("Misil")) {
			if(this.armamento.armaDisponible(pArma)) {
				this.armamento.borrar(pArma);
				IA.getMiIA().gestionarAtaque(pCoord, pArma);
			}
		}
		else if (pArma.equals("Escudo")) {
			//Gestionar escudo
		}
		else {
			//Gestionar radar
		}
		IA.getMiIA().accionarArmamento();
		setChanged();
		notifyObservers();
	}

	public void gestionarAtaque(Coordenada pCoord, Arma pArma) {
		if (this.miFlota.contieneBarcoEnPos(pCoord)) {
			if(pArma instanceof Bomba) {
				this.miFlota.getBarcoEnPos(pCoord).tocar(pCoord);
			}
			else if (pArma instanceof Misil) {
				this.miFlota.getBarcoEnPos(pCoord).hundir();	
			}
			this.miFlota.comprobarHundimiento();
		}
	}
	
	/*PARA USO FUTURO public void gestorAccion(Coordenada pCoord, int pTamano, Boolean pHorizontal, String pArma) {
		if (this.miFlota.getCompleta()) {
			this.accionarArmamento(pCoord, pArma);
		}
		else {
			this.anadirBarco(pCoord, pTamano, pHorizontal);
		}
	}*/
	
	public Flota getMiFLota() {
		return this.miFlota;
	}

}