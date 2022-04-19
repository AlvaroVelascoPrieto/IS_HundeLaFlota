package packModelo;

import java.util.Random;

public class IA extends SuperJugador {
	
	public IA() {
		this.miFlota = new Flota();
		this.armamento = new Armamento();
	}
	
	public Coordenada generarRandomCoord() {
		return new Coordenada(false,new Random().nextInt(10),new Random().nextInt(10)); //Devuelve un numero entre 0 y 9
	}

	private Boolean generarRandomBoolean() {
	     Random rd = new Random(); 
	     return rd.nextBoolean(); 
	}
	
	private int generarRandomIndiceArma() {
		return new Random().nextInt(this.armamento.getTamanoArmamento()-1); //Devuelve el indice de un arma
	}

	public Arma accionarArmamento(String pArma) {
		int indiceArma = this.generarRandomIndiceArma();
	
		return this.armamento.borrar(indiceArma);
	}

	public void anadirBarco(Coordenada pCoord, int pTamano, boolean pHorizontal) {
		Boolean horizontal = this.generarRandomBoolean();
		Coordenada coord = this.generarRandomCoord();
		while (!this.miFlota.puedeAnadir(coord,pTamano,horizontal)) {
			coord = this.generarRandomCoord();
		}
		this.miFlota.aņadirBarco(coord, pTamano, horizontal);
	}
}