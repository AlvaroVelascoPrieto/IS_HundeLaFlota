package packModelo;

public class Jugador extends SuperJugador{

	public Jugador() {
		this.miFlota = new Flota();
		this.armamento = new Armamento();
	}

	public Arma accionarArmamento(Coordenada pCoord, String pArma) {
		if(this.armamento.armaDisponible(pArma)) {
			System.out.println("e2");
			if(pArma.equals("Escudo")) {
				System.out.println("e3");
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
}