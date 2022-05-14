package packModelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Armamento {

	private ArrayList<Arma> lArmas;

	public Armamento() {
		this.lArmas = new ArrayList<Arma>();
		this.generarArmamentoInicial();
	}
	
	public Arma borrar(int pIndice) {
		return this.lArmas.remove(pIndice);
	}
	
	public int getTamanoArmamento() {
		return this.lArmas.size();
	}

	public Arma borrar(String pArma) {
		Arma aBorrar = this.getArma(pArma);
		System.out.println(this.getNumEscudos());
		this.lArmas.remove(aBorrar);
		System.out.println(this.getNumEscudos());
		return aBorrar;
	}
	
	public boolean armaDisponible(String pArma) {
		Iterator<Arma> itr = this.getIterador();
		if(pArma == "Bomba") {
			while(itr.hasNext()) {
				Arma act = itr.next();
				if(act instanceof Bomba) {
					return true;
				}
			}
		}
		else if(pArma == "Misil") {
			while(itr.hasNext()) {
				Arma act = itr.next();
				if(act instanceof Misil) {
					return true;
				}
			}
		}
		else if(pArma == "Escudo") {
			while(itr.hasNext()) {
				Arma act = itr.next();
				if(act instanceof Escudo) {
					return true;
				}
			}
		}
		return false;
	}

	public void generarArmamentoInicial() {
		for(int i=0;i<100;i++) {
			this.lArmas.add(ArmaFactory.getMiArmaFactory().createArma("Bomba"));
		}
		for(int i=0;i<10;i++) {
			this.lArmas.add(ArmaFactory.getMiArmaFactory().createArma("Misil"));
		}
		for(int i=0;i<4;i++) {
			this.lArmas.add(ArmaFactory.getMiArmaFactory().createArma("Escudo"));
		}
		this.lArmas.add(ArmaFactory.getMiArmaFactory().createArma("Radar"));
	}
	
	private Iterator<Arma> getIterador(){
		return this.lArmas.iterator();
	}
	
	public Arma getArma(String pArma) {
		Iterator<Arma> itr = this.getIterador();
		if(pArma=="Bomba") {
			while(itr.hasNext()) {
				Arma act = itr.next();
				if (act instanceof Bomba) {
					return act;
				}
			}
		}
		else if(pArma=="Misil") {
			while(itr.hasNext()) {
				Arma act = itr.next();
				if (act instanceof Misil) {
					return act;
				}
			}
		}
		else if(pArma=="Escudo") {
			while(itr.hasNext()) {
				Arma act = itr.next();
				if (act instanceof Escudo) {
					return act;
				}
			}
		}
		return null;
	}
	
	public Radar getRadar() {
		Iterator<Arma> itr = this.getIterador();
		while(itr.hasNext()) {
			Arma act = itr.next();
			if (act instanceof Radar) {
				return (Radar) act;
			}
		}
		return null;
	}
	
	public void GenerarArmamentoAlmacen(){
		for(int i=0;i<10;i++) {
			this.lArmas.add(ArmaFactory.getMiArmaFactory().createArma("Misil"));
		}
		for(int i=0;i<6;i++) {
			this.lArmas.add(ArmaFactory.getMiArmaFactory().createArma("Escudo"));
		}
	}

	public void anadirArma(Arma pArma){
		this.lArmas.add(pArma);
	}

	public Arma getArma(int indexCompraIA) {
		return this.lArmas.get(indexCompraIA);
	}
	
	public int getNumMisiles() {
		Iterator<Arma> itr = this.getIterador();
		int cont = 0;
		while (itr.hasNext()) {
			Arma act = itr.next();
			if(act instanceof Misil) {
				cont += 1; 
			}
		}
		return cont;
	}
	
	public int getNumEscudos() {
		Iterator<Arma> itr = this.getIterador();
		int cont = 0;
		while (itr.hasNext()) {
			Arma act = itr.next();
			if(act instanceof Escudo) {
				cont += 1; 
			}
		}
		return cont;
	}

}