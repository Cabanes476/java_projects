import java.util.Date;

public class Usuarios {
	
	//Atributos
	
	String nombre;
	String apellido1;
	String apellido2;
	int telefono; 
	String dni;
	String email;
	String Direccion;
	Date fechaNacimiento;
	char sexo;
	
	
	// Constructores
	
	public Usuarios(String nombre, String apellido1, String apellido2, String dni, String email, Date fechaNacimiento) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}


	public Usuarios(String nombre, String apellido1, String apellido2, int telefono, String dni, String email,
			String direccion, Date fechaNacimiento, char sexo) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telefono = telefono;
		this.dni = dni;
		this.email = email;
		Direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	// Getters y Setters
	
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
		
	
}








