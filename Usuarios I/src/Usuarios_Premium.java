

import java.util.Date;

public class Usuarios_Premium extends Usuarios {
	
	// Atributos
	
	String instagram;
	String cuenta;
	String estudios;
	
	//int telefono; // telefono EspaÒol
	
	char estado;
	
	
	// contructores
	
	public Usuarios_Premium(String nombre, String apellido1, String apellido2, String dni, String email, Date fechaNacimiento,
		String cuenta, int telefono) {
		super(nombre, apellido1, apellido2, dni, email, fechaNacimiento);
		this.cuenta = cuenta;
		this.telefono = telefono;
	}
	
	public Usuarios_Premium(String nombre, String apellido1, String apellido2, int telefono, String dni, String email, String direccion, Date fechaNacimiento, char sexo,
			String instagram, String cuenta, String estudios, char estado) {
		super(nombre, apellido1, apellido2, telefono, dni, email,
				direccion, fechaNacimiento, sexo);
		this.instagram = instagram;
		this.cuenta = cuenta;
		this.estudios = estudios;
		this.estado = estado;
	}
	
	//Getters y Setters
	
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getEstudios() {
		return estudios;
	}
	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}	
	
}
