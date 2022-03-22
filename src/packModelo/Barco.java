package packModelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Barco {

	private ArrayList<Coordenada> listaC;
	private Boolean hundido;

	public Barco() {
		// TODO - implement Barco.Barco
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCoord
	 * @param pTamaño
	 * @param pHorizontal
	 */
	public void añadirCoordenada(Coordenada pCoord, int pTamaño, Boolean pHorizontal) {
		// TODO - implement Barco.añadirCoordenada
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCoord
	 */
	public Boolean estaEn(Coordenada pCoord) {
		// TODO - implement Barco.estaEn
		throw new UnsupportedOperationException();
	}

	private Iterator<Coordenada> getIterador() {
		// TODO - implement Barco.getIterador
		throw new UnsupportedOperationException();
	}
	
	public ArrayList<Coordenada> getCoordenadas() {
		return this.listaC;
	}

}