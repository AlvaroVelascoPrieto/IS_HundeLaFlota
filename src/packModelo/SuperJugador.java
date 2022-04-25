package packModelo;

public abstract class SuperJugador {
	protected Flota miFlota;
	protected Armamento armamento;
	
	public abstract Arma accionarArmamento(Coordenada pCoord, String pArma);
	public abstract void anadirBarco(Coordenada pCoord, int pTamano, boolean pHorizontal);
	public void gestionarAtaque(Coordenada pCoord, Arma pArma) {
		if (this.miFlota.contieneBarcoEnPos(pCoord)) {
			if(this.miFlota.getBarcoEnPos(pCoord).getEscudo()) {
				System.out.print("Esc activo");
				if(pArma instanceof Bomba) {
					this.miFlota.getBarcoEnPos(pCoord).tocarEscudo();
				}
				else if (pArma instanceof Misil) {
					this.miFlota.getBarcoEnPos(pCoord).romperEscudo();	
				}
			}
			else {
				System.out.print("No activo");
				if(pArma instanceof Bomba) {
					this.miFlota.getBarcoEnPos(pCoord).tocar(pCoord);
				}
				else if (pArma instanceof Misil) {
					this.miFlota.getBarcoEnPos(pCoord).hundir();	
				}
				this.miFlota.comprobarHundimiento();
			}
		}
	}
	public Flota getMiFlota(){
		return this.miFlota;
	}
	
	public Armamento getMiArmamento() {
		return this.armamento;
	}
}
