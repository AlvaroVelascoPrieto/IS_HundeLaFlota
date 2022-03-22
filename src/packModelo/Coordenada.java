package packModelo;

public class Coordenada {

	private Boolean tocado;
	private int x;
	private int y;

	/**
	 * 
	 * @param pTocado
	 * @param pX
	 * @param pY
	 */
	public Coordenada(Boolean pTocado, int pX, int pY) {
		this.tocado = pTocado;
		this.x = pX;
		this.y = pY;
	}

	/**
	 * 
	 * @param pCoord
	 */
	public Boolean esCoordenada(Coordenada pCoord) {
		// TODO - implement Coordenada.esCoordenada
		throw new UnsupportedOperationException();
	}

	public void setTocado() {
		// TODO - implement Coordenada.setTocado
		throw new UnsupportedOperationException();
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

}