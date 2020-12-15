
public class Empleado {
	
	//Atributos
	
	String nombre;
	String categoria;
	
	//Constructor
	
	public Empleado(String nombre, String categoria) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
	}

	//Getters y setters
	
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getCategoria() {
			return categoria;
		}
		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

	//Metodos
	
	public boolean transferir(Cliente cEmisor, Cliente cReceptor, float cantidad) {
		if(cEmisor.getSaldo() - cantidad < -cEmisor.getLimiteDescubierto()) {
			System.out.println("No puede realizar la transferencia");
			return false;
		}
		
		else {
			cEmisor.setSaldo(cEmisor.getSaldo()-cantidad);
			cReceptor.setSaldo(cReceptor.getSaldo()+cantidad);
			System.out.println("Transferencia realizada");
			return true;
		}
		
	}
	
		
}

