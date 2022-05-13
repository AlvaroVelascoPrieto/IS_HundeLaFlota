package packModelo;

public class Jugador extends SuperJugador{

	public Jugador() {
		this.miFlota = new Flota();
		this.armamento = new Armamento();
		this.dinero = 100;
	}

	public Arma accionarArmamento(Coordenada pCoord, String pArma) {
		if(this.armamento.armaDisponible(pArma)) {
			if(pArma.equals("Escudo")) {
				this.miFlota.activarEscudo(pCoord);
			}
			return this.armamento.borrar(pArma);
		}
		return null;
	}	

	public void anadirBarco(Coordenada pCoord, int pTamano, boolean pHorizontal) {
			this.miFlota.añadirBarco(pCoord, pTamano, pHorizontal);
			this.miFlota.comprobarCompleta();
	}

	public int getDinero() {
		return this.dinero;
	}

}