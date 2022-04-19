package packModelo;

public class Jugador extends SuperJugador{

	public Jugador() {
		this.miFlota = new Flota();
		this.armamento = new Armamento();
	}

	public Arma accionarArmamento(String pArma) {
		if(this.armamento.armaDisponible(pArma)) {
			return this.armamento.borrar(pArma);
		}
		return null;
	}	

	public void anadirBarco(Coordenada pCoord, int pTamano, boolean pHorizontal) {
			this.miFlota.añadirBarco(pCoord, pTamano, pHorizontal);
			this.miFlota.comprobarCompleta();
	}

}