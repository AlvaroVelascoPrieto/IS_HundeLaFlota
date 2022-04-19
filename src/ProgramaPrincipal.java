import packModelo.GestorJuego;
import packModelo.Jugador;
import packVista.InterfazJuego;

public class ProgramaPrincipal {
	public static void main(String[] args) {
		GestorJuego.getMiGestorJuego();
		InterfazJuego interfaz = new InterfazJuego();
	}
}
