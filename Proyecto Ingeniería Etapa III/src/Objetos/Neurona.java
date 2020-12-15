package Objetos;

public class Neurona {
	//ATRIBUTOS
	private double 
	R = 10.0,      //Resistencia de mebrana en MOhmios
	tau = 10,      //constante de tiempo de la membrana en ms (C=tau/R)
	Vrep = -65.0,  //Potencial de reposo de la membrana en mV
	Vth = -50,     //Potencial umbral de disparo de la membrana en mV
	Vreset = -70,  //Voltaje de reseteo tras disparo en mV
	Vspike = 30;   //Voltaje pico en mV

	//CONSTRUCTOR
	public Neurona(double r, double tau, double vrep, double vth, double vreset, double vspike) {
		super();
		R = r;
		this.tau = tau;
		Vrep = vrep;
		Vth = vth;
		Vreset = vreset;
		Vspike = vspike;
	}

	//GETTERS Y SETTERS
	public double getR() {
		return R;
	}

	public void setR(double r) {
		R = r;
	}

	public double getTau() {
		return tau;
	}

	public void setTau(double tau) {
		this.tau = tau;
	}

	public double getVrep() {
		return Vrep;
	}

	public void setVrep(double vrep) {
		Vrep = vrep;
	}

	public double getVth() {
		return Vth;
	}

	public void setVth(double vth) {
		Vth = vth;
	}

	public double getVreset() {
		return Vreset;
	}

	public void setVreset(double vreset) {
		Vreset = vreset;
	}

	public double getVspike() {
		return Vspike;
	}

	public void setVspike(double vspike) {
		Vspike = vspike;
	}
	
}
