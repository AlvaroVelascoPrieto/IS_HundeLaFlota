package packModelo;

public class Coordenada {

	private Boolean tocado;
	private Boolean escudoTocado;
	private Integer x;
	private Integer y;

	public Coordenada(Boolean pTocado, int pX, int pY) {
		this.tocado = pTocado;
		this.x = pX;
		this.y = pY;
		this.escudoTocado = false;
	}

	public Boolean esCoordenada(Coordenada pCoord) {
		if (this.x.equals(pCoord.getX())) {
			if(this.y.equals(pCoord.getY())) {
				return true;
			}
		}
		return false;
	}

	public void setTocado() {
		this.tocado = true;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean getTocado() {
		return this.tocado;
	}
	
	public void reparar() {
		this.tocado = false;
	}

	public boolean getEscudoTocado() {
		return this.escudoTocado;
	}
	
	public void setEscudoTocado(boolean pEstado){
		this.escudoTocado = pEstado;
	}
	
}