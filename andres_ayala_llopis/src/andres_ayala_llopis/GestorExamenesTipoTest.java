package andres_ayala_llopis;
import java.util.Vector;

public class GestorExamenesTipoTest {
	//Atributos
	public Vector<Examen> examenes;
	//Metodos
	public boolean añadirExamen(Examen examen) {
		boolean added = false;
		
			this.examenes.add(examen);
			added = true;
		
		
		return added;
	}
	
	public boolean eliminarUltimoExamen() {
		boolean removed = false;
			this.examenes.remove(this.examenes.size()-1);
			removed = true;
		
			return removed;
}
	
	public void eliminarTodosExamenes() {
		this.examenes.clear();
	}

	/*public void listarExamenes() {
			System.out.println("-----------------------------\nLista de Exámenes\n-----------------------------");
			for (int i = 0; i < examenes.length; i++) {
				
				}
			}*/
	
	public float calculaMediaCalificacionExamenes() {
		
		float calificacion = 0;
		//Falta completar 
		
		return calificacion;
		
		
		
	}
	
	/*public float buscarMaximaCalificacionExamenes() {
		
			float calificacion = -1;
			if(this.examenes.size() > 0) {
				for (int i = 0; i < this.examenes.size(); i++) {
					if(calificacion < this.examenes.get(i).getCalificacion()) {
						calificacion = this.examenes.get(i).getCalificacion();
					}
				}
			}
			return calificacion;
		
	}*/
	
	/*public int buscarMinimaCalificacionExamenes() {
		
			int calificacion = Integer.MAX_VALUE;
			if(this.examenes.size() > 0) {
				for (int i = 0; i < this.examenes.size(); i++) {
					if(calificacion > this.examenes.get(i).getCalificacion()) {
						calificacion = this.examenes.get(i).getCalificacion();
					}
				}
			}
			return calificacion;
	}*/
	
	//Getters y Setters
	/*public Calificacion getCalificacion() {
		return Calificacion();
	}*/
}
