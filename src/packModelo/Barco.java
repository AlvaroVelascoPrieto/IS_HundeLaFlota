package packModelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Barco {

	private ArrayList<Coordenada> listaC;
	private Boolean hundido;

	public Barco() {
		this.listaC = new ArrayList<Coordenada>();
		this.hundido = false;
	}

	/**
	 * 
	 * @param pCoord
	 * @param pTamaño
	 * @param pHorizontal
	 */
	public void anadirCoordenadas(Coordenada pCoord, int pTamano, Boolean pHorizontal) {
		for (int i=0; i<pTamano; i++) {
			if(pHorizontal) {
				Coordenada nuevaCoordenada = new Coordenada(false, pCoord.getX()+i, pCoord.getY());
				this.listaC.add(nuevaCoordenada);
			}
			else {
				Coordenada nuevaCoordenada = new Coordenada(false, pCoord.getX(), pCoord.getY()+i);
				this.listaC.add(nuevaCoordenada);
			}
		}
	}

	/**
	 * 
	 * @param pCoord
	 */
	public Boolean estaEn(Coordenada pCoord) {
		// TODO - implement Barco.estaEn
		boolean enc=false;
		Coordenada auxCoord;
		Iterator<Coordenada> itr=this.getIterador();
		while (itr.hasNext()) {
			auxCoord = itr.next();
			if(auxCoord.esCoordenada(pCoord)) {
				return true;
			}
		}
		return false;
	}

	private Iterator<Coordenada> getIterador() {
		return this.listaC.iterator();
	}
	
	public ArrayList<Coordenada> getCoordenadas() {
		return this.listaC;
	}

	public void hundir() {
		Iterator<Coordenada> itr = this.getIterador();
		while (itr.hasNext()) {
			Coordenada coordAct = itr.next();
			coordAct.setTocado();
		}
		this.hundido = true;
	}

	public void tocar(Coordenada pCoord) {
		boolean hundidoPosible = true;
		Iterator<Coordenada> itr = this.getIterador();
		while (itr.hasNext()) {
			Coordenada coordAct = itr.next();
			if (coordAct.esCoordenada(pCoord)) {
				coordAct.setTocado();
			}
			if (!coordAct.getTocado()){
				hundidoPosible = false;
			}
		}
		if (hundidoPosible) {
			this.hundido = true;
		}
	}

	public int getTamano() {
		return this.listaC.size();
	}
	
	public boolean getHundido() {
		return this.hundido;
	}

}