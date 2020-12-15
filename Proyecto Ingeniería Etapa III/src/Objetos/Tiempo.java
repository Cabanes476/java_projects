package Objetos;

public class Tiempo {
	
	//ATRIBUTOS
	private double 
	tFinSimul = 500,//Duración en ms de la ventana temporal de la representación gráfica
	tIniEstim = 100,//Tiempo en ms en que comienza el estímulo dentro de la ventana temporal 
	tFinEstim = 400,//Tiempo en ms en que acaba el estímulo dentro de la ventana temporal 
	dt = 0.1;       //Resolución temporal en ms

	
	//CONSTRUCTOR
	public Tiempo(double tFinSimul, double tIniEstim, double tFinEstim, double dt) {

		this.tFinSimul = tFinSimul;
		this.tIniEstim = tIniEstim;
		this.tFinEstim = tFinEstim;
		this.dt = dt;
	}
	
	
	//GETTERS Y SETTERS
	public double gettFinSimul() {
		return tFinSimul;
	}

	public void settFinSimul(double tFinSimul) {
		this.tFinSimul = tFinSimul;
	}

	public double gettIniEstim() {
		return tIniEstim;
	}

	public void settIniEstim(double tIniEstim) {
		this.tIniEstim = tIniEstim;
	}

	public double gettFinEstim() {
		return tFinEstim;
	}

	public void settFinEstim(double tFinEstim) {
		this.tFinEstim = tFinEstim;
	}

	public double getDt() {
		return dt;
	}

	public void setDt(double dt) {
		this.dt = dt;
	}
	
	
}
