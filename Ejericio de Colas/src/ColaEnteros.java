

public class ColaEnteros {
	
	// Atributos de la clase
	
	private int[] cola = new int[100];
	private int indiceUltimoCola= -1;
	
	// Metodos de la clase
	
	public void insertar (int elemento) {
		this.indiceUltimoCola++;
		this.cola[this.indiceUltimoCola] = elemento;
	}
	
	public int sacar() {
		int elemento = this.cola[0];
		
		// Mover hacia delante
		
		for (int i=1; i<=this.indiceUltimoCola; i++) {
			this.cola[i-1] = this.cola[i];
		}
		
		this.indiceUltimoCola--;
		
		return elemento;
	}
	
	public boolean colaVacia() {
		return this.indiceUltimoCola < 0;
	}
	
	public int primero() {
		return this.cola[0];
	}
	
	public void decapitar() {
		sacar();
	}
	
	// Borra los elementos de la cola
	
	public void vaciar () {		
		this.indiceUltimoCola = -1;
		
	}
	
	public static void main(String[] args) {
		
		//Area de ejecucion de codigo
	}

}