package packModelo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Radar extends Arma {

	private int consultas;
	private Coordenada coord;
	private Coordenada coordAnt;
	private boolean activo;
	private ArrayList<Coordenada> avistamientos;

	public Radar(int pconsulta) {
			this.consultas = pconsulta;
			this.coord = this.generarRandomCoord();
			this.activo = false;
			this.avistamientos = new ArrayList<Coordenada>();
	}
	
	private Coordenada generarRandomCoord() {
		return new Coordenada(false, new Random().nextInt(10),new Random().nextInt(10)); //Devuelve un numero entre 0 y 9
	}
	
	public void activarRadar(Flota pFlotaContrincante) {
		if (this.consultas != 0) {
			this.activo = true;
			this.infoRadar(pFlotaContrincante);
			this.consultas = this.consultas -1;
		}
	}
	
	public void moverRadar() {
		this.coordAnt=this.coord;
		this.coord=this.generarRandomCoord();
	}
	
	public void desactivarRadar() {
		this.activo = false;
	}
	
	public Coordenada getPos() {
		return this.coord;
	}
	
	public Coordenada getPosAnt() {
		return this.coordAnt;
	}
	
	private void infoRadar(Flota pFlotaContrincante){
		this.avistamientos = new ArrayList<Coordenada>();
		if(this.coord.getX()==0) {//Fila superior
			if (this.coord.getY()==0) {//Esquina superior izq
				if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX(),this.coord.getY()))) {
					this.avistamientos.add(new Coordenada(false,this.coord.getX(),this.coord.getY()));
				}
				if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX()+1,this.coord.getY()))) {
					this.avistamientos.add(new Coordenada(false,this.coord.getX()+1,this.coord.getY()));
				}
				if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX(),this.coord.getY()+1))) {
					this.avistamientos.add(new Coordenada(false,this.coord.getX(),this.coord.getY()+1));
				}
				if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX()+1,this.coord.getY()+1))) {
					this.avistamientos.add(new Coordenada(false,this.coord.getX()+1,this.coord.getY()+1));
				}
			}else if(this.coord.getY()==9) {//Esquina superior der
				if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX(),this.coord.getY()))) {
					this.avistamientos.add(new Coordenada(false,this.coord.getX(),this.coord.getY()));
				}
				if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX()-1,this.coord.getY()))) {
					this.avistamientos.add(new Coordenada(false,this.coord.getX()-1,this.coord.getY()));
				}
				if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX(),this.coord.getY()+1))) {
					this.avistamientos.add(new Coordenada(false,this.coord.getX(),this.coord.getY()+1));
				}
				if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX()-1,this.coord.getY()+1))) {
					this.avistamientos.add(new Coordenada(false,this.coord.getX()-1,this.coord.getY()+1));
				}
			}else {//Fila superior
				for (int i = 0; i<3; i++) {
					if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX()-1+i,this.coord.getY()))) {
						this.avistamientos.add(new Coordenada(false,this.coord.getX()-1+i,this.coord.getY()));
					}
					if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX()-1+i,this.coord.getY()+1))) {
						this.avistamientos.add(new Coordenada(false,this.coord.getX()-1+i,this.coord.getY()+1));
					}
				}
			}
		}else if(this.coord.getX()==9) {//Fila inferior
			if (this.coord.getY()==0) {//Esquina inferior izq
				if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX(),this.coord.getY()))) {
					this.avistamientos.add(new Coordenada(false,this.coord.getX(),this.coord.getY()));
				}
				if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX()+1,this.coord.getY()))) {
					this.avistamientos.add(new Coordenada(false,this.coord.getX()+1,this.coord.getY()));
				}
				if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX(),this.coord.getY()-1))) {
					this.avistamientos.add(new Coordenada(false,this.coord.getX(),this.coord.getY()-1));
				}
				if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX()+1,this.coord.getY()-1))) {
					this.avistamientos.add(new Coordenada(false,this.coord.getX()+1,this.coord.getY()-1));
				}
			}else if(this.coord.getY()==9) {//Esquina inferior der
				if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX(),this.coord.getY()))) {
					this.avistamientos.add(new Coordenada(false,this.coord.getX(),this.coord.getY()));
				}
				if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX()-1,this.coord.getY()))) {
					this.avistamientos.add(new Coordenada(false,this.coord.getX()-1,this.coord.getY()));
				}
				if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX(),this.coord.getY()-1))) {
					this.avistamientos.add(new Coordenada(false,this.coord.getX(),this.coord.getY()-1));
				}
				if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX()-1,this.coord.getY()-1))) {
					this.avistamientos.add(new Coordenada(false,this.coord.getX()-1,this.coord.getY()-1));
				}
			}else {//Fila inferior
				for (int i = 0; i<3; i++) {
					if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX()-1+i,this.coord.getY()))) {
						this.avistamientos.add(new Coordenada(false,this.coord.getX()-1+i,this.coord.getY()));
					}
					if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX()-1+i,this.coord.getY()-1))) {
						this.avistamientos.add(new Coordenada(false,this.coord.getX()-1+i,this.coord.getY()-1));
					}
				}
			}
		}else {
			if (this.coord.getY()==0) {//Columna izquierda sin esquinas
				for (int i = 0; i<3; i++) {
					if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX(),this.coord.getY()-1+i))) {
						this.avistamientos.add(new Coordenada(false,this.coord.getX(),this.coord.getY()-1+i));
					}
					if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX()+1,this.coord.getY()-1+i))) {
						this.avistamientos.add(new Coordenada(false,this.coord.getX()+1,this.coord.getY()-1+i));
					}
				}
			}else if(this.coord.getY()==9) {//Columna derecha sin esquinas
				for (int i = 0; i<3; i++) {
					if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX(),this.coord.getY()-1+i))) {
						this.avistamientos.add(new Coordenada(false,this.coord.getX(),this.coord.getY()-1+i));
					}
					if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false,this.coord.getX()-1,this.coord.getY()-1+i))) {
						this.avistamientos.add(new Coordenada(false,this.coord.getX()-1,this.coord.getY()-1+i));
					}
				}
			}else {//Centro sin casos criticos
				for (int i = 0; i<3; i++) {
					if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false, this.coord.getX()-1+i,this.coord.getY()))) {
						this.avistamientos.add(new Coordenada(false, this.coord.getX()-1+i,this.coord.getY()));
					}
					if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false, this.coord.getX()-1+i,this.coord.getY()-1))) {
						this.avistamientos.add(new Coordenada(false, this.coord.getX()-1+i,this.coord.getY()-1));
					}
					if(pFlotaContrincante.contieneBarcoEnPos(new Coordenada(false, this.coord.getX()-1+i,this.coord.getY()+1))) {
						this.avistamientos.add(new Coordenada(false, this.coord.getX()-1+i,this.coord.getY()+1));
					}
				}
			}
		}
	}

	public ArrayList<Coordenada> getAvistamientos() {
		return this.avistamientos;
	}

	public boolean getActivo() {
		return this.activo;
	}

	public int getConsultasRestantes() {
		// TODO Auto-generated method stub
		return this.consultas;
	}
}