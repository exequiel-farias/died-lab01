package died.lab01.problema01;

public class Punto {
	private float x;
	private float y;
	
	public Punto(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float nuevoValor) {
		this.x = nuevoValor;
	}

	public float getY() {
		return y;
	}

	public void setY(float nuevoValor) {
		this.y = nuevoValor;
	}
	
	@Override
	public boolean equals(Object otroPunto) {
		if(this == otroPunto) return true;
		if( otroPunto != null && otroPunto instanceof Punto) {
			Punto otro = (Punto) otroPunto;
			return (this.x == otro.getX() && this.y == otro.getY());
		}
		return false;
	}
}
