package packModelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Flota {

	private ArrayList<Barco> listaB;
	private Armamento misArmas;
	private int numBar1;
	private int numBar2;
	private int numBar3;
	private int numBar4;
	private boolean completa;
	private boolean hundida;

	public Flota() {
		this.listaB = new ArrayList<Barco>();
		completa = false;
		this.misArmas = new Armamento();
		this.misArmas.generarArmamentoInicial();
	}

	public void añadirBarco(Coordenada pCoord, int pTamano, Boolean pHorizontal) {
		Barco nuevoBarco = new Barco();
		nuevoBarco.anadirCoordenadas(pCoord, pTamano, pHorizontal);
		this.listaB.add(nuevoBarco);
		if(pTamano==1) {
			numBar1 += 1;
		}
		else if(pTamano==2) {
			numBar2 += 1;
		}
		else if(pTamano==3) {
			numBar3 += 1;
		}
		else {
			numBar4 += 1;
		}
		this.comprobarCompleta();
	}

	public Boolean puedeAnadir(Coordenada pCoord, int pTamano, Boolean pHorizontal) {
		if(pTamano==1&&numBar1>=4) {
			return false;
		}
		else if (pTamano==2&&numBar2>=3) {
			return false;
		}
		else if (pTamano==3&&numBar3>=2) {
			return false;
		}
		else if(pTamano==4&&numBar4>=1) {
			return false;
		}
		if (pHorizontal){//horizontal
			if (pCoord.getX()+pTamano-1<10){
				if (pCoord.getX()==0){//columna izq
					if(pCoord.getY()==0){//esquina sup izq
						for (int i=0;i<pTamano+1;i++){
							if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i,pCoord.getY()+1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i,pCoord.getY()))){
								return false;
							}
						}
					}
					else if(pCoord.getY()==9){//esquina inf izq
						for (int i=0;i<pTamano+1;i++){
							if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i,pCoord.getY()-1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i,pCoord.getY()))){
								return false;
							}
						}
					}
					else{
						for (int i=0;i<pTamano+1;i++){
							if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i,pCoord.getY()-1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i,pCoord.getY()+1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i,pCoord.getY()))){
								return false;
							}
						}
						
					}
				}
				else if(pCoord.getX()+pTamano-1==9){//columna dcha
					if(pCoord.getY()==0){//esquina sup der
						for (int i=0;i<pTamano+1;i++){
							if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i-1,pCoord.getY()+1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i-1,pCoord.getY()))){
								return false;
							}
						}
					}
					else if(pCoord.getY()==9){//esquina inf der
						for (int i=0;i<pTamano+1;i++){
							if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i-1,pCoord.getY()-1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i-1,pCoord.getY()))){
								return false;
							}
						}
					}
					else{
						for (int i=0;i<pTamano+1;i++){
							if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i-1,pCoord.getY()-1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i-1,pCoord.getY()+1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i-1,pCoord.getY()))){
								return false;
							}
						}
						
					}
				}
				else if(pCoord.getY()==0){//fila arriba sin esquinas
					for (int i=0;i<pTamano+2;i++){
						if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i-1,pCoord.getY()+1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i-1,pCoord.getY()))){
							return false;
						}
					}
					
				}
				else if(pCoord.getY()==9){//fila abajo sin esquinas
					for (int i=0;i<pTamano+2;i++){
						if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i-1,pCoord.getY()-1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i-1,pCoord.getY()))){
							return false;
						}
					}
				}
				else{
					for (int i=0;i<pTamano+2;i++){
						if (this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i-1,pCoord.getY()-1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i-1,pCoord.getY()+1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+i-1,pCoord.getY()))){
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
						for (int i=0; i<pTamano+1; i++){
							if(this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+1,pCoord.getY()+i))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX(),pCoord.getY()+i))){
								return false;
							}
						}
					}
					else if(pCoord.getX()==9){//Esquina superior der
						for (int i=0; i<pTamano+1; i++){
							if(this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()-1,pCoord.getY()+i))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX(),pCoord.getY()+i))){
								return false;
							}
						}
					}
					else{//Fila superior menos esquinas
						for (int i=0; i<pTamano+1; i++){
							if(this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()-1,pCoord.getY()+i))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+1,pCoord.getY()+i))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX(),pCoord.getY()+i))){
								return false;
							}
						}
					}
				}
				else if(pCoord.getY()+pTamano-1==9){//Fila inferior
					if(pCoord.getX()==0){//Esquina inferior izq
						for (int i=0; i<pTamano+1; i++){
							if(this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+1,pCoord.getY()+i-1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX(),pCoord.getY()+i-1))){
								return false;
							}
						}
					}
					else if (pCoord.getX()==9){//Esquina inferior derecha
						for (int i=0; i<pTamano+1; i++){
							if(this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()-1,pCoord.getY()+i-1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX(),pCoord.getY()+i-1))){
								return false;
							}
						}
					}
					else{//Fila inferior sin esquinas
						for (int i=0; i<pTamano+1; i++){
							if(this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()-1,pCoord.getY()+i-1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+1,pCoord.getY()+i-1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX(),pCoord.getY()+i-1))){
								return false;
							}
						}
					}
				}
				else if(pCoord.getX()==0){//Columna izq sin esquinas
					for (int i=0; i<pTamano+2; i++){
						if(this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+1,pCoord.getY()+i-1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX(),pCoord.getY()+i-1))){
							return false;
						}
					}
				}
				else if(pCoord.getX()==9){//Columna derecha sin esquinas
					for (int i=0; i<pTamano+2; i++){
						if(this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()-1,pCoord.getY()+i-1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX(),pCoord.getY()+i-1))){
							return false;
						}
					}
				}
				else{
					for (int i=0; i<pTamano+2; i++){
						if(this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()-1,pCoord.getY()+i-1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX()+1,pCoord.getY()+i-1))||this.contieneBarcoEnPos(new Coordenada(false,pCoord.getX(),pCoord.getY()+i-1))){
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

	public void comprobarCompleta() {
		if(numBar1==4 && numBar2==3 && numBar3==2 && numBar4==1) {
			this.completa = true;
		}
	}
	
	public void comprobarHundimiento() {
		Iterator<Barco> itr = this.getIterador();
		boolean hundido = true;
		while(itr.hasNext()) {
			Barco act = itr.next();
			if (!act.getHundido()) {
				hundido = false;
			}
		}
		this.hundida = hundido;
	}

	public boolean getCompleta() {
		return completa;
	}
	
	public boolean getHundida() {
		return this.hundida;
	}

	public void activarEscudo(Coordenada pCoord) {
		Iterator<Barco> itr = this.getIterador();
		while (itr.hasNext()) {
			Barco act = itr.next();
			if(act.estaEn(pCoord)) {
				act.setEscudo();
				break;
			}
		}
	}

	public int getTamanoFlota() {
		return this.listaB.size();
	}

}