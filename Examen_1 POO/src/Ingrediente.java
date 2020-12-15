
public class Ingrediente {
	
	private String nombre;
	private boolean gluten;
	private double precio;
	
	public Ingrediente(String nombre, boolean gluten, double precio) {
		
		this.nombre = nombre;
		this.gluten = gluten;
		this.precio = precio;
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean hadgluten() {
		return gluten;
	}
	public void setGluten(boolean gluten) {
		this.gluten = gluten;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
