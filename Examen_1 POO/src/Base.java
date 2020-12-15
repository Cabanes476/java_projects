
public class Base {
	
	private String tipo;
	private boolean gluten;
	private double precio;
	private String tamaño;
	
	public Base (String tipo, boolean gluten, double precio, String tamaño) {
		
		this.tipo = tipo;
		this.gluten = gluten;
		this.precio = precio;
		this.tamaño = tamaño;
		
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean hasGluten() {
		return gluten;
	}
	public void setGluten(boolean gluten) {
		this.gluten = gluten;
	}
	public double setPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getTamaño() {
		return tamaño;
	}
	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}
}
