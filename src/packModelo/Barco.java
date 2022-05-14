package packModelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Barco {

	private ArrayList<Coordenada> listaC;
	private Boolean hundido;
	private boolean escudo;
	private boolean escudoTocado;

	public Barco() {
		this.listaC = new ArrayList<Coordenada>();
		this.hundido = false;
		this.escudo = false;
		this.escudoTocado = false;
	}

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
		System.out.println("Hola");
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
	
	public void setEscudo() {
		this.escudo = true;
		this.escudoTocado = false;
	}
	
	public void tocarEscudo(Coordenada pCoord) {
		if(this.escudoTocado) {
			this.romperEscudo();
		}
		else {
			this.escudoTocado = true;
			Iterator<Coordenada> itr = this.getIterador();
			while(itr.hasNext()) {
				Coordenada act = itr.next();
				if (act.esCoordenada(pCoord)) {
					act.setEscudoTocado(true);
				}
			}
			
		}
	}
	
	public void romperEscudo() {
		this.escudo = false;
		this.escudoTocado = false;
		Iterator <Coordenada> itr = this.getIterador();
		while(itr.hasNext()) {
			Coordenada act = itr.next();
			act.setEscudoTocado(false);
		}
	}
	
	public boolean getEscudo() {
		return this.escudo;
	}
	
	public boolean getEscudoTocado() {
		return this.escudoTocado;
	}

	public boolean getBarcoTocado() {
		boolean estaTocado = false;
		Iterator<Coordenada> itr = this.getIterador();
		while(itr.hasNext()) {
			Coordenada act = itr.next();
			if(act.getTocado()) {
				estaTocado = true;
			}
		}
		return estaTocado;
	}
	
	public void reparar() {
		Iterator<Coordenada> itr = this.getIterador();
		while (itr.hasNext()) {
			Coordenada act = itr.next();
			if(act.getTocado()) {
				act.reparar();
			}
		}
	}
	
}