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
		this.lArmas.remove(aBorrar);
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
		for(int i=0;i<100;i++) {
			this.lArmas.add(ArmaFactory.getMiArmaFactory().createArma("Misil"));
		}
		for(int i=0;i<10;i++) {
			this.lArmas.add(ArmaFactory.getMiArmaFactory().createArma("Escudo"));
		}
		this.lArmas.add(ArmaFactory.getMiArmaFactory().createArma("Radar"));
	}
	
	private Iterator<Arma> getIterador(){
		return this.lArmas.iterator();
	}
	
	private Arma getArma(String pArma) {
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

}