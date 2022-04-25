package packModelo;

import java.util.ArrayList;
import java.util.Random;

public class IA extends SuperJugador {
	private ArrayList<Coordenada> targetsVistos;
	
	public IA() {
		this.miFlota = new Flota();
		this.armamento = new Armamento();
		this.targetsVistos = new ArrayList<Coordenada>();
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

	public Arma accionarArmamento(Coordenada pCoord, String pArma) {
		Arma miArma = this.armamento.borrar(generarRandomIndiceArma());
		if(miArma instanceof Escudo) {
			System.out.println("ESCUDO");
			Coordenada coordEscudo = this.getRandomBarcoNoTocado();
			this.miFlota.activarEscudo(coordEscudo);
		}
		return miArma;
	}

	public void anadirBarco(Coordenada pCoord, int pTamano, boolean pHorizontal) {
		Boolean horizontal = this.generarRandomBoolean();
		Coordenada coord = this.generarRandomCoord();
		while (!this.miFlota.puedeAnadir(coord,pTamano,horizontal)) {
			coord = this.generarRandomCoord();
		}
		this.miFlota.añadirBarco(coord, pTamano, horizontal);
	}
	
	public void usarRadar(Flota pFlotaContrincante) {
		this.armamento.getRadar().activarRadar(pFlotaContrincante);
		targetsVistos.addAll(this.armamento.getRadar().getAvistamientos());
	}
	
	public void anadirTargetVisto(Coordenada pCoord) {
		this.targetsVistos.add(pCoord);
	}
	
	public Coordenada determinarAtaque() {
		if(targetsVistos.size()!=0) {
			return targetsVistos.remove(0);
		}else {
			return this.generarRandomCoord();
		}
	}

	public Coordenada getRandomBarcoNoTocado() {
		Barco randomBarco = this.miFlota.getListaBarcos().get(new Random().nextInt(this.miFlota.getTamanoFlota()-1));
		while (randomBarco.getBarcoTocado()&&!this.miFlota.getHundida()) {
			randomBarco = this.miFlota.getListaBarcos().get(new Random().nextInt(this.miFlota.getTamanoFlota()-1));
		}
		if(this.miFlota.getHundida()) {
			return this.miFlota.getListaBarcos().get(new Random().nextInt(this.miFlota.getTamanoFlota()-1)).getCoordenadas().get(0);
		}
		return randomBarco.getCoordenadas().get(0);
	}
}