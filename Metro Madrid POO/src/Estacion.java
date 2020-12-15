
public class Estacion {
	
	//Atributos
	
	private String nombre;
	private Tren[] tren = new Tren[1];	//No lo a�ado al constructor ya que es posible que no haya ningun tren en la estacion
	
	//Getters y setters
		
	public String getNombre() {
			return nombre;
		}

		
	public void setNombre(String nombre) {
			this.nombre = nombre;
		}
	
	
	//Constructor
	
	public Estacion(String nombre) {
		this.nombre = nombre;
	}
	

	//Trenes
	
	public void anadirTren(Tren tren, int via) {
		if (via != 1 | via != 2) {
			System.out.println("Solo puede ser via 1 o 2");
		}
		else {
			this.tren[via-1] = tren;	//se resta 1 porque la via 1 corresponderia a la posicion 0 y la via 2 a la posicion 1
		}
		
	}
	
	public void eliminarTren(int via) {
		if (via != 1 | via != 2) {
			System.out.println("Solo puede ser via 1 o 2");
		}
		else {
			this.tren[via-1] = null;	//se resta 1 porque la via 1 corresponderia a la posicion 0 y la via 2 a la posicion 1
		}
	}
	
	
}
