package died.lab01.problema01;

public class Recta {
	private Punto p1;
	private Punto p2;
	
	public Recta() {
		this.p1 = new Punto(0,0);
		this.p2 = new Punto(1,1);
	}
	
	public Recta(Punto p1, Punto p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public float pendiente() {
		float m = (this.p2.getY() - this.p1.getY()) / (this.p2.getX() - this.p1.getX());
		return m;
	}
	
	public boolean paralelas(Recta otraRecta) {
		return this.pendiente() == otraRecta.pendiente();
	}

	@Override
	public boolean equals(Object otraRecta) {
		if(this == otraRecta) return true;
		if(otraRecta != null && otraRecta instanceof Recta) {
			Recta otra = (Recta) otraRecta;
			if(this.p1.equals(otra.p1) && this.p2.equals(otra.p2)) return true;
			else {
				Recta aux = new Recta(this.p1,otra.p2);
				return (aux.pendiente()==this.pendiente() && aux.pendiente()==otra.pendiente());
			}
		}
		return false;
	}
}