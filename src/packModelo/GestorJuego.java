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
	
	
	public void gestionarColocacionBarcosJugador(int pX, int pY, int pTamano, boolean pDireccion){ //direccion: true=horizontal, false =vertical
		//poner a true las casillas de barcoJugador 
		if (puedeColocar(pX,pY,pTamano,pDireccion)){
			for (int i=0;i<pTamano-1;i++){
				if (pDireccion){
					this.barcosJugador.get(pY).set(pX+i, true);
				}else{
					this.barcosJugador.get(pY+i).set(pX, true);
				}
			}
		}
		setChanged();
		notifyObservers();
	}
	
	
	private boolean puedeColocar(int pX, int pY, int pTamano, boolean pDireccion){
		if (pDireccion){//horizontal
			if (pX+pTamano-1<10){
				if (pX==0){//columna izq
					if(pY==0){//esquina sup izq
						if ((this.barcosJugador.get(pY).get(pX+pTamano))){
							return false;
						}
						for (int i=0;i<pTamano+1;i++){
							if (this.barcosJugador.get(pY+1).get(pX+i)){
								return false;
							}
						}
					}
					else if(pY==9){//esquina inf izq
						if (this.barcosJugador.get(pY).get(pX+pTamano)){
							return false;
						}
						for (int i=0;i<pTamano+1;i++){
							if ((this.barcosJugador.get(pY-1).get(pX+i))){
								return false;
							}
						}
					}
					else{
						if (this.barcosJugador.get(pY).get(pX+pTamano)){
							return false;
						}
						for (int i=0;i<pTamano+1;i++){
							if ((this.barcosJugador.get(pY-1).get(pX+i))||this.barcosJugador.get(pY+1).get(pX+i)){
								return false;
							}
						}
						
					}
				}
				else if(pX+pTamano-1==9){//columna dcha
					if(pY==0){//esquina sup der
						if (this.barcosJugador.get(pY).get(pX-1)){
							return false;
						}
						for (int i=0;i<pTamano+1;i++){
							if (this.barcosJugador.get(pY+1).get(pX-1+i)){
								return false;
							}
						}
					}
					else if(pY==9){//esquina inf der
						if (this.barcosJugador.get(pY).get(pX-1)){
							return false;
						}
						for (int i=0;i<pTamano+1;i++){
							if (this.barcosJugador.get(pY-1).get(pX-1+i)){
								return false;
							}
						}
					}
					else{
						if (this.barcosJugador.get(pY).get(pX-1)){
							return false;
						}
						for (int i=0;i<pTamano+1;i++){
							if ((this.barcosJugador.get(pY-1).get(pX-1+i))||this.barcosJugador.get(pY+1).get(pX-1+i)){
								return false;
							}
						}
						
					}
				}
				else if(pY==0){//fila arriba sin esquinas
					if ((this.barcosJugador.get(pY).get(pX-1))||(this.barcosJugador.get(pY).get(pX+pTamano))){
						return false;
					}
					for (int i=0;i<pTamano+2;i++){
						if (this.barcosJugador.get(pY+1).get(pX-1+i)){
							return false;
						}
					}
					
				}
				else if(pY==9){//fila abajo sin esquinas
					if ((this.barcosJugador.get(pY).get(pX-1))||(this.barcosJugador.get(pY).get(pX+pTamano))){
						return false;
					}
					for (int i=0;i<pTamano+2;i++){
						if ((this.barcosJugador.get(pY-1).get(pX-1+i))){
							return false;
						}
					}
				}
				else{
					if ((this.barcosJugador.get(pY).get(pX-1))||(this.barcosJugador.get(pY).get(pX+pTamano))){
						return false;
					}
					for (int i=0;i<pTamano+2;i++){
						if ((this.barcosJugador.get(pY-1).get(pX-1+i))||this.barcosJugador.get(pY+1).get(pX-1+i)){
							return false;
						}
					}
					
				}
			}
			else{
				return false;
			}
		}	
		
		else{//vertical 
			if (pY+pTamano-1<10){
				if(pY==0){//Fila superior
					if (pX==0){//Esquina superior izq
						if (this.barcosJugador.get(pY+pTamano).get(pX)){
							return false;
						}
						for (int i=0; i<pTamano+1; i++){
							if(this.barcosJugador.get(pY+i).get(pX+1)){
								return false;
							}
						}
					}
					else if(pX==9){//Esquina superior der
						if (this.barcosJugador.get(pY+pTamano).get(pX)){
							return false;
						}
						for (int i=0; i<pTamano+1; i++){
							if(this.barcosJugador.get(pY+i).get(pX-1)){
								return false;
							}
						}
					}
					else{//Fila superior menos esquinas
						if (this.barcosJugador.get(pY+pTamano).get(pX)){
							return false;
						}
						for (int i=0; i<pTamano+1; i++){
							if(this.barcosJugador.get(pY+i).get(pX-1)||this.barcosJugador.get(pY+i).get(pX+1)){
								return false;
							}
						}
					}
				}
				else if(pY+pTamano-1==9){//Fila inferior
					if(pX==0){//Esquina inferior izq
						if (this.barcosJugador.get(pY-1).get(pX)){
							return false;
						}
						for (int i=0; i<pTamano+1; i++){
							if(this.barcosJugador.get(pY-1+i).get(pX+1)){
								return false;
							}
						}
					}
					else if (pX==9){//Esquina inferior derecha
						if (this.barcosJugador.get(pY-1).get(pX)){
							return false;
						}
						for (int i=0; i<pTamano+1; i++){
							if(this.barcosJugador.get(pY-1+i).get(pX-1)){
								return false;
							}
						}
					}
					else{//Fila inferior sin esquinas
						if (this.barcosJugador.get(pY-1).get(pX)){
							return false;
						}
						for (int i=0; i<pTamano+1; i++){
							if(this.barcosJugador.get(pY-1+i).get(pX-1)||this.barcosJugador.get(pY-1+i).get(pX+1)){
								return false;
							}
						}
					}
				}
				else if(pX==0){//Columna izq sin esquinas
					if (this.barcosJugador.get(pY-1).get(pX)||this.barcosJugador.get(pY+pTamano).get(pX)){
						return false;
					}
					for (int i=0; i<pTamano+2; i++){
						if(this.barcosJugador.get(pY-1+i).get(pX+1)){
							return false;
						}
					}
				}
				else if(pX==9){//Columna derecha sin esquinas
					if (this.barcosJugador.get(pY-1).get(pX)||this.barcosJugador.get(pY+pTamano).get(pX)){
						return false;
					}
					for (int i=0; i<pTamano+2; i++){
						if(this.barcosJugador.get(pY-1+i).get(pX-1)){
							return false;
						}
					}
				}
				else{
					if (this.barcosJugador.get(pY-1).get(pX)||this.barcosJugador.get(pY+pTamano).get(pX)){
						return false;
					}
					for (int i=0; i<pTamano+2; i++){
						if(this.barcosJugador.get(pY-1+i).get(pX-1)||this.barcosJugador.get(pY-1+i).get(pX+1)){
							return false;
						}
					}
				}
			}
			else{
				return false;
			}
		}
		return true;
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
	
	public ArrayList<ArrayList<Boolean>> getBarcosJugador(){
		return this.barcosJugador;
	}
}
