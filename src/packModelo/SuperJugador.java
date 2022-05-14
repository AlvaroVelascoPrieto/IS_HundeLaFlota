package packModelo;

public abstract class SuperJugador {
	protected Flota miFlota;
	protected Armamento armamento;
	protected int dinero;
	
	public abstract Arma accionarArmamento(Coordenada pCoord, String pArma);
	public abstract void anadirBarco(Coordenada pCoord, int pTamano, boolean pHorizontal);
	public void gestionarAtaque(Coordenada pCoord, Arma pArma) {
		if (this.miFlota.contieneBarcoEnPos(pCoord)) {
			if(this.miFlota.getBarcoEnPos(pCoord).getEscudo()) {
				System.out.print("Esc activo");
				if(pArma instanceof Bomba) {
					this.miFlota.getBarcoEnPos(pCoord).tocarEscudo(pCoord);
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
	
	public void repararBarco(Coordenada pCoord) {
		if(dinero>=25) {
			this.dinero-=25;
			miFlota.repararBarco(pCoord);
		}
	}
	
	public Flota getMiFlota(){
		return this.miFlota;
	}
	
	public Armamento getMiArmamento() {
		return this.armamento;
	}
	
	public boolean tieneDinero(Arma pArma){
		if (pArma instanceof Misil){
			return this.dinero>=10;
		}
		else if (pArma instanceof Escudo){
			return this.dinero>=20;
		}
		return false;
	}
	
	public void decrementarDinero(Arma pArma) {
		if (pArma instanceof Misil){
			this.dinero-=10;
		}
		else if (pArma instanceof Escudo){
			this.dinero-=20;
		}
	}
}
