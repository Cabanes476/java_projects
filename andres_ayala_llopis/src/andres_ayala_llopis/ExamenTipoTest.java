package andres_ayala_llopis;

import java.util.Vector;

public class ExamenTipoTest {

	//Atributos
	public Vector<PreguntaTest> pregunta;
	public float calificacion;
	
	//Getters and Setters
	
	public Vector<PreguntaTest> getPreguntaTest() {
		return pregunta;
	}

	public void setPregunta(Vector<PreguntaTest> pregunta) {
		this.pregunta = pregunta;
	}
	
	public float getCalificar() {
		return calificacion;
	}

	public void setCalificar(float calificacion) {
		this.calificacion = calificacion;
	}
	
	
	public boolean añadirPregunta(PreguntaTest pregunta) {
		boolean added = false;
			this.pregunta.add(pregunta);
			added = true;
		
		return added;
		
	}
	
	public boolean eliminarUltimaPregunta() {
		boolean removed = false;
			this.pregunta.remove(this.pregunta.size()-1);
			removed = true;
		return removed;
	}
	
	public void eliminarTodasPreguntas() {
		this.pregunta.clear();
	}
	
	public float calificar() {
		
		//Por completar
		
		return 0;
		
	}
	
	@Override
	public String toString() {
		
		return ""; //Por completar
	} 

}
