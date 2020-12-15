package andres_ayala_llopis;

import java.util.Vector;

public class PreguntaTest {
	
	//Atributos
	public String pregunta;
	public Vector<ExamenTipoTest> opciones;
	public int opcionRespuesta;
	public int opcionCorrecta;
	
	//Metodos
	public boolean añadirOpcion(ExamenTipoTest opcion) {
		boolean added = false;
		
			this.opciones.add(opcion);
			added = true;
		
		
		return added;
	}
	
	public boolean eliminarUltimaOpcion() {
		boolean removed = false;
			this.opciones.remove(this.opciones.size()-1);
			removed = true;
		
			return removed;
}
	
	//Falta completar Getters y Setters además de el resto de métodos
	

}
