
public class Programa_Principal {

	public static void main(String[] args) {
		
		Cliente[] clientes = new Cliente[50];
		
		for (int i = 0; i < clientes.length; i++) {
			clientes[i] = new Cliente("cliente"+i, (float)Math.random()*10000, 50 * (int)(Math.random()*10));
		}
		
		Banco banco = new Banco(clientes, new Empleado("Juan Jose", "Basico"));
	
		banco.getClientes()[0].setSaldo(100);
		banco.getClientes()[0].setLimiteDescubierto(50);
		
		banco.getClientes()[1].setSaldo(200);
		
		banco.getEmpleado().transferir(banco.getClientes()[0], banco.getClientes()[1], 150);
		
		System.out.println(banco.getClientes()[0].getSaldo());
		System.out.println("");
		banco.getClientes()[2].setSaldo(-900);
		banco.listarDescubiertos();
		

	}

}
