package packModelo;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaJugadores {
	private ArrayList<SuperJugador> lJugadores;
	
	public ListaJugadores() {
		this.lJugadores = new ArrayList<SuperJugador>();
	}
	
	private Iterator<SuperJugador> getIterador(){
		return this.lJugadores.iterator();
	}
	
	public SuperJugador getJugador() {
		Iterator<SuperJugador> itr = this.getIterador();
		while (itr.hasNext()) {
			SuperJugador act = itr.next();
			if (act instanceof Jugador) {
				return act;
			}
		}
		return null;
	}
	
	public SuperJugador getIA() {
		Iterator<SuperJugador> itr = this.getIterador();
		while (itr.hasNext()) {
			SuperJugador act = itr.next();
			if (act instanceof IA) {
				return act;
			}
		}
		return null;
	}
	
	public void anadirJugador(SuperJugador pJugador) {
		this.lJugadores.add(pJugador);
	}
}
