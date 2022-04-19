package packModelo;

public abstract class SuperJugador {
	protected Flota miFlota;
	protected Armamento armamento;
	
	public abstract Arma accionarArmamento(String pArma);
	public abstract void anadirBarco(Coordenada pCoord, int pTamano, boolean pHorizontal);
	public void gestionarAtaque(Coordenada pCoord, Arma pArma) {
		if (this.miFlota.contieneBarcoEnPos(pCoord)) {
			if(pArma instanceof Bomba) {
				this.miFlota.getBarcoEnPos(pCoord).tocar(pCoord);
			}
			else if (pArma instanceof Misil) {
				this.miFlota.getBarcoEnPos(pCoord).hundir();	
			}
			this.miFlota.comprobarHundimiento();
		}
	}
	public Flota getMiFlota(){
		return this.miFlota;
	}
}
