package andres_ayala_llopis;

public class Examen {
	
	    //Atributos
		public String asignatura;
		public String instrucciones;
		public String nombreAlumno;
		public String fecha;
		
		//Constructor
		public Examen(String asignatura, String instrucciones, String nombreAlumno, String fecha) {
			super();
			this.asignatura = asignatura;
			this.instrucciones = instrucciones;
			this.nombreAlumno = nombreAlumno;
			this.fecha = fecha;
		}

		
		//Getters y setters
		public String getAsignatura() {
			return asignatura;
		}

		public void setAsignatura(String asignatura) {
			this.asignatura = asignatura;
		}

		public String getInstrucciones() {
			return instrucciones;
		}

		public void setInstrucciones(String instrucciones) {
			this.instrucciones = instrucciones;
		}

		public String getNombreAlumno() {
			return nombreAlumno;
		}

		public void setNombreAlumno(String nombreAlumno) {
			this.nombreAlumno = nombreAlumno;
		}

		public String getFecha() {
			return fecha;
		}

		public void setFecha(String fecha) {
			this.fecha = fecha;
		}

		//Muestra la salida de texto
		@Override
		public String toString() {
			return "Asignatura=" + asignatura + ", Instrucciones=" + instrucciones + ", Nombre del Alumno=" + nombreAlumno + ", Fecha=" + fecha + "\n";
		}
		
		
		

}
