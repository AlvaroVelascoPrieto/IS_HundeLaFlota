package packModelo;

import java.util.ArrayList;
import java.util.Random;

public class IA {

	private static IA miIA;
	private Flota miFlota;
	private Armamento armamento;

	private IA() {
		this.miFlota = new Flota();
		this.armamento = new Armamento();
	}

	public static IA getMiIA() {
		if (miIA==null) {
			miIA = new IA();
		}
		return miIA;
	}

	public void accionarArmamento() {
		int indiceArma = this.generarRandomIndiceArma();
		Arma arma = this.armamento.getArma(indiceArma);
		this.armamento.borrar(indiceArma);
		Coordenada coord = new Coordenada(false, this.generarRandomIndex(), this.generarRandomIndex());
		Jugador.getMiJugador().gestionarAtaque(coord, arma);		
	}

	private int generarRandomIndex() {
		return new Random().nextInt(10); //Devuelve un numero entre 0 y 9
	}

	private Boolean generarRandomBoolean() {
	     Random rd = new Random(); 
	     return rd.nextBoolean(); 
	}
	
	private int generarRandomIndiceArma() {
		return new Random().nextInt(this.armamento.getTamanoArmamento()-1); //Devuelve el indice de un arma
	}

	public void anadirBarco(int pTamano) {
		Boolean horizontal = this.generarRandomBoolean();
		Coordenada coord = new Coordenada(false, this.generarRandomIndex(), this.generarRandomIndex());
		while (!this.miFlota.puedeAnadir(coord,pTamano,horizontal)) {
			coord = new Coordenada(false, this.generarRandomIndex(), this.generarRandomIndex());
		}
		this.miFlota.añadirBarco(coord, pTamano, horizontal);
	}
	
	public void gestionarAtaque(Coordenada pCoord, String pArma) {
		if (this.miFlota.contieneBarcoEnPos(pCoord)) {
			if(pArma == "Bomba") {
				this.miFlota.getBarcoEnPos(pCoord).tocar(pCoord);
			}
			else if (pArma == "Misil") {
				this.miFlota.getBarcoEnPos(pCoord).hundir();	
			}
			this.miFlota.comprobarHundimiento();
		}
	}
	
	public Flota getMiFLota() {
		return this.miFlota;
	}

}