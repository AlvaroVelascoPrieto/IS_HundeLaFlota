package packModelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Flota {

	private ArrayList<Barco> listaB;

	public Flota() {
		// TODO - implement Flota.Flota
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCoord
	 * @param pTama�o
	 * @param pHorizontal
	 */
	public void a�adirBarco(Coordenada pCoord, int pTama�o, Boolean pHorizontal) {
		// TODO - implement Flota.a�adirBarco
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCoord
	 * @param pTama�o
	 * @param pHorizontal
	 */
	private Boolean puedeA�adir(Coordenada pCoord, int pTama�o, Boolean pHorizontal) {
		// TODO - implement Flota.puedeA�adir
		throw new UnsupportedOperationException();
	}

	private Iterator<Barco> getIterador() {
		// TODO - implement Flota.getIterador
		throw new UnsupportedOperationException();
	}
	
	public ArrayList<Barco> getListaBarcos(){
		return this.listaB;
	}

	public boolean contieneBarcoEnPos(Coordenada pCoord) {
		for(Barco barcoAct : listaB) {
			if (barcoAct.estaEn(pCoord)) {
				return true;
			}
		}
		return false;
	}

	public Barco getBarcoEnPos(Coordenada pCoord) {
		for(Barco barcoAct : listaB) {
			if (barcoAct.estaEn(pCoord)) {
				return barcoAct;
			}
		}
		return null;
	}

}