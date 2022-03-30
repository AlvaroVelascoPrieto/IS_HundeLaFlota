package packModelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Flota {

	private ArrayList<Barco> listaB;

	public Flota() {
		this.listaB = new ArrayList<Barco>();
	}

	/**
	 * 
	 * @param pCoord
	 * @param pTamaño
	 * @param pHorizontal
	 */
	public void añadirBarco(Coordenada pCoord, int pTamano, Boolean pHorizontal) {
		// TODO - implement Flota.añadirBarco
		if (this.puedeAnadir(pCoord,pTamano,pHorizontal)) {
			Barco nuevoBarco = new Barco();
			nuevoBarco.anadirCoordenadas(pCoord, pTamano, pHorizontal);
			this.listaB.add(nuevoBarco);
		}
	}

	/**
	 * 
	 * @param pCoord
	 * @param pTamaño
	 * @param pHorizontal
	 */
	private Boolean puedeAnadir(Coordenada pCoord, int pTamano, Boolean pHorizontal) {
		if (pHorizontal){//horizontal
			if (pCoord.getX()+pTamano-1<10){
				if (pCoord.getX()==0){//columna izq
					if(pCoord.getY()==0){//esquina sup izq
						if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+pTamano,pCoord.getY()))){
							return false;
						}
						for (int i=0;i<pTamano+1;i++){
							if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i,pCoord.getY()+1))){
								return false;
							}
						}
					}
					else if(pCoord.getY()==9){//esquina inf izq
						if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+pTamano,pCoord.getY()))){
							return false;
						}
						for (int i=0;i<pTamano+1;i++){
							if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i,pCoord.getY()-1))){
								return false;
							}
						}
					}
					else{
						if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+pTamano,pCoord.getY()))){
							return false;
						}
						for (int i=0;i<pTamano+1;i++){
							if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i,pCoord.getY()-1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i,pCoord.getY()+1))){
								return false;
							}
						}
						
					}
				}
				else if(pCoord.getX()+pTamano-1==9){//columna dcha
					if(pCoord.getY()==0){//esquina sup der
						if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()-1,pCoord.getY()))){
							return false;
						}
						for (int i=0;i<pTamano+1;i++){
							if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i-1,pCoord.getY()+1))){
								return false;
							}
						}
					}
					else if(pCoord.getY()==9){//esquina inf der
						if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()-1,pCoord.getY()))){
							return false;
						}
						for (int i=0;i<pTamano+1;i++){
							if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i-1,pCoord.getY()-1))){
								return false;
							}
						}
					}
					else{
						if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()-1,pCoord.getY()))){
							return false;
						}
						for (int i=0;i<pTamano+1;i++){
							if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i-1,pCoord.getY()-1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i-1,pCoord.getY()+1))){
								return false;
							}
						}
						
					}
				}
				else if(pCoord.getY()==0){//fila arriba sin esquinas
					if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()-1,pCoord.getY()))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+pTamano,pCoord.getY()))){
						return false;
					}
					for (int i=0;i<pTamano+2;i++){
						if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i-1,pCoord.getY()+1))){
							return false;
						}
					}
					
				}
				else if(pCoord.getY()==9){//fila abajo sin esquinas
					if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()-1,pCoord.getY()))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+pTamano,pCoord.getY()))){
						return false;
					}
					for (int i=0;i<pTamano+2;i++){
						if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i-1,pCoord.getY()-1))){
							return false;
						}
					}
				}
				else{
					if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()-1,pCoord.getY()))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+pTamano,pCoord.getY()))){
						return false;
					}
					for (int i=0;i<pTamano+2;i++){
						if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i-1,pCoord.getY()-1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i-1,pCoord.getY()+1))){
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
			if (pCoord.getY()+pTamano-1<10){
				if(pCoord.getY()==0){//Fila superior
					if (pCoord.getX()==0){//Esquina superior izq
						if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX(),pCoord.getY()+pTamano))){
							return false;
						}
						for (int i=0; i<pTamano+1; i++){
							if(this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+1,pCoord.getY()+i))){
								return false;
							}
						}
					}
					else if(pCoord.getX()==9){//Esquina superior der
						if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX(),pCoord.getY()+pTamano))){
							return false;
						}
						for (int i=0; i<pTamano+1; i++){
							if(this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()-1,pCoord.getY()+i))){
								return false;
							}
						}
					}
					else{//Fila superior menos esquinas
						if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX(),pCoord.getY()+pTamano))){
							return false;
						}
						for (int i=0; i<pTamano+1; i++){
							if(this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()-1,pCoord.getY()+i))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+1,pCoord.getY()+i))){
								return false;
							}
						}
					}
				}
				else if(pCoord.getY()+pTamano-1==9){//Fila inferior
					if(pCoord.getX()==0){//Esquina inferior izq
						if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX(),pCoord.getY()-1))){
							return false;
						}
						for (int i=0; i<pTamano+1; i++){
							if(this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+1,pCoord.getY()+i-1))){
								return false;
							}
						}
					}
					else if (pCoord.getX()==9){//Esquina inferior derecha
						if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX(),pCoord.getY()-1))){
							return false;
						}
						for (int i=0; i<pTamano+1; i++){
							if(this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()-1,pCoord.getY()+i-1))){
								return false;
							}
						}
					}
					else{//Fila inferior sin esquinas
						if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX(),pCoord.getY()-1))){
							return false;
						}
						for (int i=0; i<pTamano+1; i++){
							if(this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()-1,pCoord.getY()+i-1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+1,pCoord.getY()+i-1))){
								return false;
							}
						}
					}
				}
				else if(pCoord.getX()==0){//Columna izq sin esquinas
					if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX(),pCoord.getY()-1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX(),pCoord.getY()+pTamano))){
						return false;
					}
					for (int i=0; i<pTamano+2; i++){
						if(this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+1,pCoord.getY()+i-1))){
							return false;
						}
					}
				}
				else if(pCoord.getX()==9){//Columna derecha sin esquinas
					if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX(),pCoord.getY()-1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX(),pCoord.getY()+pTamano))){
						return false;
					}
					for (int i=0; i<pTamano+2; i++){
						if(this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()-1,pCoord.getY()+i-1))){
							return false;
						}
					}
				}
				else{
					if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX(),pCoord.getY()-1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX(),pCoord.getY()+pTamano))){
						return false;
					}
					for (int i=0; i<pTamano+2; i++){
						if(this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()-1,pCoord.getY()+i-1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+1,pCoord.getY()+i-1))){
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

	private Iterator<Barco> getIterador() {
		return this.listaB.iterator();
	}
	
	public ArrayList<Barco> getListaBarcos(){
		return this.listaB;
	}

	public boolean contieneBarcoEnPos(Coordenada pCoord) {
		Iterator<Barco> itr = this.getIterador();
		while(itr.hasNext()) {
			Barco barcoAct = itr.next();
			if (barcoAct.estaEn(pCoord)) {
				return true;
			}
		}
		return false;
	}

	public Barco getBarcoEnPos(Coordenada pCoord) {
		Iterator<Barco> itr = this.getIterador();
		while(itr.hasNext()) {
			Barco barcoAct = itr.next();
			if (barcoAct.estaEn(pCoord)) {
				return barcoAct;
			}
		}
		return null;
	}

}