package packModelo;

import java.util.ArrayList;
import java.util.Observable;

public class GestorJuego extends Observable {
	private static GestorJuego miGestorJuego;
	private ArrayList<ArrayList<Boolean>> barcosJugador;
	private ArrayList<ArrayList<Boolean>> casillasTocadasJugador;
	private ArrayList<ArrayList<Boolean>> barcosIA;
	private ArrayList<ArrayList<Boolean>> casillasTocadasIA;

	
	private GestorJuego() {
		this.barcosJugador = new ArrayList<ArrayList<Boolean>>();
		this.casillasTocadasJugador = new ArrayList<ArrayList<Boolean>>();
		this.barcosIA = new ArrayList<ArrayList<Boolean>>();
		this.casillasTocadasIA = new ArrayList<ArrayList<Boolean>>();
		this.inicializarArrays();
	}
	
	public static  GestorJuego getGestorJuego() {
		if (miGestorJuego==null) {
			miGestorJuego=new GestorJuego();
		}
		return miGestorJuego;
	}
	
	private void inicializarArrays() {
		for (int i = 0; i<10; i++) {
			this.barcosJugador.add(new ArrayList<Boolean>());
			this.casillasTocadasJugador.add(new ArrayList<Boolean>());
			this.barcosIA.add(new ArrayList<Boolean>());
			this.casillasTocadasIA.add(new ArrayList<Boolean>());
			for (int j=0; j<10; j++) {
				this.barcosJugador.get(i).add(false);
				this.casillasTocadasJugador.get(i).add(false);
				this.barcosIA.get(i).add(false);
				this.casillasTocadasIA.get(i).add(false);
			}
		}
	}
	
	public void gestionarDisparoJugador(int pX, int pY) {
		this.casillasTocadasIA.get(pY).set(pX, true);	
		setChanged();
		notifyObservers();
	}
	
	public ArrayList<ArrayList<Boolean>> getCasillasTocadasIA() {
		return this.casillasTocadasIA;
	}
	
	
	public ArrayList<ArrayList<Boolean>> getBarcosIA() {
		return this.barcosIA;
	}
}
