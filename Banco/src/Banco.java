public class Banco {
	
	//Atributos
	
	private Cliente[] clientes;
	private Empleado empleado;
	
	//Constructor
	
	public Banco(Cliente[] clientes, Empleado empleado) {
		super();
		this.clientes = clientes;
		this.empleado = empleado;
	}


	//Metodo
	
	public void listarDescubiertos() {
		System.out.println("-----------------------------\nLista de descubiertos\n-----------------------------");
		for (int i = 0; i < clientes.length; i++) {
			if(clientes[i].descubierto()) {
				System.out.println(clientes[i].getNombre() + "\nLimite: " + -clientes[i].getLimiteDescubierto()
						+ "\nSaldo: " + clientes[i].getSaldo() + "\n-----------------------------");
			}
		}
	}
	
	
	//Getters y setters
	
	public Cliente[] getClientes() {
		return clientes;
	}
	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
}
