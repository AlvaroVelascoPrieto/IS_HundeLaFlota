package packModelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Armamento {

	private ArrayList<Arma> lArmas;

	public Armamento() {
		this.lArmas = new ArrayList<Arma>();
		this.generarArmamentoInicial();
	}

	public ArrayList<Arma> getLArmas() {
		return this.lArmas;
	}

	public void borrar(String pArma) {
		Arma aBorrar = this.getArma(pArma);
		this.lArmas.remove(aBorrar);
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
		return false;
	}

	public void generarArmamentoInicial() {
		for(int i=0;i<100;i++) {
			this.lArmas.add(ArmaFactory.getMiArmaFactory().createArma("Bomba"));
		}
		for(int i=0;i<100;i++) {
			this.lArmas.add(ArmaFactory.getMiArmaFactory().createArma("Misil"));
		}
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

}