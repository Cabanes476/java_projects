public class Pilas {
	
	// Atributos
	
	private int[] pila = new int[100];
	private int elementosApilados = -1;
	
	// Métodos
	
	public void apilar (int elemento) {
		this.elementosApilados++;
		this.pila[this.elementosApilados] = elemento;
	}
	
	public int desapilar() {
		
		int elemento = this.pila[this.elementosApilados];
		this.elementosApilados--;
		return elemento;
	}
	
	public boolean pilaVacia() {
		
		return this.elementosApilados < 0;
	}
	
	public int cima() {
		return this.pila[this.elementosApilados];
	}
	
	public void decapitar() {
		this.elementosApilados--;
	}
	
	// Borra los elementos de la pila
	
	public void vaciar () {
		
		this.elementosApilados = -1;
		
	}
	
	public static void main(String[] args) {
		// la crea
		Pilas p = new Pilas();
		
		//le da valores del -15 al 19
		for (int i= -15; i<20; i++) {
			p.apilar(i);
		}
		// crea segunda pila
		Pilas p2 = new Pilas();
		
		while (! p.pilaVacia()) {
			p2.apilar(p.desapilar());
		}
		
	}

}