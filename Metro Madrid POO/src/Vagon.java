
public class Vagon {
	
	//Atributos
	
	private String matricula;
	private int puertas;
	private int capacidad;
	private boolean modelo2000;
	private boolean camaras;
	private boolean sisVerifTickets;
	
	//Getters y setters
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getPuertas() {
		return puertas;
	}
	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public boolean isModelo2000() {
		return modelo2000;
	}
	public void setModelo2000(boolean modelo2000) {
		this.modelo2000 = modelo2000;
	}
	public boolean isCamaras() {
		return camaras;
	}
	public void setCamaras(boolean camaras) {
		this.camaras = camaras;
	}
	public boolean isSisVerifTickets() {
		return sisVerifTickets;
	}
	public void setSisVerifTickets(boolean sisVerifTickets) {
		this.sisVerifTickets = sisVerifTickets;
	}
	
	//Constructor
	
	public Vagon(String matricula, boolean modelo2000) {

		this.matricula = matricula;
		this.modelo2000 = modelo2000;
		if (modelo2000 == true) {
			this.camaras = true;
			this.sisVerifTickets = true;
			this.capacidad = 20;
			this.puertas = 4;
		}
		else {
			this.camaras = false;
			this.sisVerifTickets = false;
			this.capacidad = 28;
			this.puertas = 6;
		}
	}
}
