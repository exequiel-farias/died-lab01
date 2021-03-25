package died.lab01.problema02;

public class Temperatura {
	private Double grados;
	private Escala escala;
	
	public Temperatura() {
		this.grados = 0.0;
		this.escala = Escala.CELCIUS;
	}
	
	public Temperatura(Double temperatura, Escala escala) {
		this.grados = temperatura;
		this.escala = escala;
	}
	
	public Double getGrados() {
		return grados;
	}
	
	public Escala getEscala() {
		return escala;
	}
	
	@Override
	public String toString() {
		if(this.escala == Escala.CELCIUS) return this.grados + " °C";
		else return this.grados + " °F";
	}
	
	public Double asCelcius() {
		if(this.escala == Escala.CELCIUS) return this.grados;
		else return (this.grados - 32) * 5 / 9;
	}
	
	public Double asFahrenheit() {
		if(this.escala == Escala.FAHRENHEIT) return this.grados;
		else return (this.grados * 9 / 5) + 32;
	}
	
	public void aumentar(Temperatura temperatura) {
		if(this.grados <= 0.0) System.out.println("La temperatura debe ser mayor a 0.0");
		if(this.escala == temperatura.getEscala()) this.grados = this.grados + temperatura.getGrados();
		else {
			if(this.escala == Escala.CELCIUS) this.grados = this.grados + temperatura.asCelcius();
			else this.grados = this.grados + temperatura.asFahrenheit();
		}
	}
	
	public void disminuir(Temperatura temperatura) {
		if(this.grados <= 0.0) System.out.println("La temperatura debe ser mayor a 0.0");
		if(this.escala == temperatura.getEscala()) this.grados = this.grados - temperatura.getGrados();
		else {
			if(this.escala == Escala.CELCIUS) this.grados = this.grados - temperatura.asCelcius();
			else this.grados = this.grados - temperatura.asFahrenheit();
		}
	}
}
