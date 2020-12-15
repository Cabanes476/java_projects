
public class Tren {
	
	//Atributos
	private String idTren;
	private boolean enMarcha;
	private int estadoPuertas; 
	
	//0-> cerradas
	//1-> abiertas
    //2-> cerrando
	//3-> abriendo
	
	private String siguienteEstacion;
	
	//Getters y Setters
	
		public String getIdTren() {
			return idTren;
		}
		public void setIdTren(String id) {
			this.idTren = id;
		}
		public boolean isEnMarcha() {
			return enMarcha;
		}
		public void setEnMarcha(boolean enMarcha) {
			this.enMarcha = enMarcha;
		}
		public int getEstadoPuertas() {
			return estadoPuertas;
		}
		public void setEstadoPuertas(int estadoPuertas) {
			this.estadoPuertas = estadoPuertas;
		}
		public String getSiguienteEstacion() {
			return siguienteEstacion;
		}
		public void setSiguienteEstacion(String siguienteEstacion) {
			this.siguienteEstacion = siguienteEstacion;
		}
		
		//Constructor
	public Tren(String idTren) {
		this.idTren = idTren;
		this.enMarcha = false;	//Cuando esta parado
		this.estadoPuertas = 0;	//Puertas cerradas
	}
	
	
	
	
}
