package packModelo;

public class Coordenada {

	private Boolean tocado;
	private Integer x;
	private Integer y;

	public Coordenada(Boolean pTocado, int pX, int pY) {
		this.tocado = pTocado;
		this.x = pX;
		this.y = pY;
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
}