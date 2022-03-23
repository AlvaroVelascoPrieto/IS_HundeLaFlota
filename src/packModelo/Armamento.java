package packModelo;

import java.util.ArrayList;

public class Armamento {

	private ArrayList<Arma> lArmas;

	public Armamento() {
		// TODO - implement Armamento.Armamento
		throw new UnsupportedOperationException();
	}

	public ArrayList<Arma> getLArmas() {
		// TODO Auto-generated method stub
		return this.lArmas;
	}

	public void borrar(Arma arma) {
		// TODO Auto-generated method stub
		this.lArmas.remove(arma);
	}

}