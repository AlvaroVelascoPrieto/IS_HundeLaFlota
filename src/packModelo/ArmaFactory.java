package packModelo;


public class ArmaFactory {

	private static ArmaFactory mArmaFactory;

	private ArmaFactory() {
		
	}

	public static ArmaFactory getMiArmaFactory() {
		if(mArmaFactory==null) {
			mArmaFactory = new ArmaFactory();
		}
		return mArmaFactory;
	}

	public Arma createArma(String pTipo) {
		if(pTipo=="Bomba") {
			return new Bomba();
		}
		else if(pTipo=="Misil") {
			return new Misil();
		}
		else if(pTipo=="Radar") {
			return new Radar();
		}
		else {
			return new Escudo();
		}
	}

}