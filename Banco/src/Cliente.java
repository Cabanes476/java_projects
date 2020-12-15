
public class Cliente {
	
	//Atributos
	
	String nombre;	
	float saldo;
	float limiteDescubierto;
	
	//Constructor
	
	public Cliente(String nombre, float saldo, float limiteDescubierto) {
		this.nombre = nombre;
		this.saldo = saldo;
		this.limiteDescubierto = limiteDescubierto;
	}

	//Getters y setters
		
	public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public float getSaldo() {
			return saldo;
		}
		public void setSaldo(float saldo) {
			this.saldo = saldo;
		}
		public float getLimiteDescubierto() {
			return limiteDescubierto;
		}
		public void setLimiteDescubierto(float limiteDescubierto) {
			this.limiteDescubierto = limiteDescubierto;
		}
		

	//Metodos
	
		public boolean descubierto() {
		boolean descubierto = false;
		
		if (saldo<(-limiteDescubierto)) {
			descubierto = true;
		}
		
		return descubierto;
	}
	
	
	public void ingresar(float dineroIngresado) {
		this.saldo += dineroIngresado;
	}
	
	
	public void retirar(float dineroRetirado){
		if(dineroRetirado > (-limiteDescubierto)) {
			System.out.println("No es posible retirar " + dineroRetirado + ". Tu saldo es: " + this.saldo);
		}
		else {
			this.saldo -= dineroRetirado;
			System.out.println("Tu saldo es: " + this.saldo);
		}
	}
	
}
