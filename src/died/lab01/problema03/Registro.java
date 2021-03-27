package died.lab01.problema03;

import died.lab01.problema02.Escala;
import died.lab01.problema02.Temperatura;

public class Registro {
	private String ciudad;
	private Temperatura[] historico;
	public static final short CANTMAX = 30;
	private short indiceActual = 0;
	
	public Registro() {
		this.ciudad = "-";
		this.historico = new Temperatura[CANTMAX];
	}
	
	public Registro(String ciudad) {
		this.ciudad = ciudad;
		this.historico = new Temperatura[CANTMAX];
	}
	
	public String getCiudad() {
		return this.ciudad;
	}
	
	public void imprimir() {
		System.out.println("TEMPERATURAS REGISTRADAS EN: "+this.ciudad);
		for(int i=1;i<=this.indiceActual;i++) {
			System.out.println(i + " " + this.historico[i-1].toString());
		}
	}
	
	public void agregar(Temperatura t) {
		if(this.indiceActual < CANTMAX) {
			this.historico[this.indiceActual] = t;
			this.indiceActual += 1;
		}
	}
	
	public Double mediaAsCelcius() {
		Double suma = 0.0;
		Double promedio;
		for(int i=0;i<this.indiceActual;i++) {
			if(this.historico[i].getEscala() == Escala.FAHRENHEIT) suma += this.historico[i].asCelcius();
			else suma += this.historico[i].getGrados();
		}
		promedio = suma / this.indiceActual; 
		return promedio;
	}
	
	public Double mediaAsFahrenheit() {
		Double suma = 0.0;
		Double promedio;
		for(int i=0;i<this.indiceActual;i++) {
			if(this.historico[i].getEscala() == Escala.CELCIUS) suma += this.historico[i].asFahrenheit();
			else suma += this.historico[i].getGrados();
		}
		promedio = suma / this.indiceActual; 
		return promedio;
	}
	
	public Temperatura maximo() {
		return this.maximoRecursivo(this.historico,this.historico[0],1);
	}
	
/*	public Temperatura maximoRecursivo(Temperatura[] temperaturas,Temperatura mayor,int indice) {
		if(indice != this.indiceActual-1) {
			if(temperaturas[indice].getGrados() > mayor.getGrados()) {
				mayor = maximoRecursivo(temperaturas, temperaturas[indice], indice+1);
			}
			else {
				mayor = maximoRecursivo(temperaturas, mayor, indice+1);
			}
		}
		return mayor;
	}*/
	
	public Temperatura maximoRecursivo(Temperatura[] temperaturas,Temperatura mayor,int indice) {
		if(indice == this.indiceActual-1) {
			if(temperaturas[indice].getGrados() > mayor.getGrados()) {
				return temperaturas[indice];
			}
			else {
				return mayor;
			}
		}
		else {
			if(temperaturas[indice].getGrados() > mayor.getGrados()) {
				mayor = this.maximoRecursivo(temperaturas, temperaturas[indice], indice+1);
				return mayor;
			}
			else {
				mayor = this.maximoRecursivo(temperaturas, mayor, indice+1);
				return mayor;
			}
		}
	}

}
