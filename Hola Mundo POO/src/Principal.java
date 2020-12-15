  
public class Principal {

	public static void main(String[] args) {
		System.out.println("Soy la clase Principal");

		//Alumno.saludar();		
		
		
		Alumno alumno1 = new Alumno();
		alumno1.saludar();
		
		Profesor profesor = new Profesor();
		profesor.saludar();
	}
}


