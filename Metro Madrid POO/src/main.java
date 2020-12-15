
public class main {

	public static void main(String[] args) {
		
		//Linea 3
		Estacion villaverdeAlto = new Estacion("Villaverde Alto");
		Estacion moncloa = new Estacion("Moncloa");
		
		
		Vagon vagon1L3 = new Vagon("V1L3", true);
		Vagon vagon2L3 = new Vagon("V2L3", true);
		Vagon vagon3L3 = new Vagon("V3L3", true);
		Vagon vagon4L3 = new Vagon("V4L3", true);
		
		
		Metro metroL3 = new Metro("TrenL3", 0, "1L3", "2L3", vagon1L3);
		metroL3.anadirVagon(vagon2L3);
		metroL3.anadirVagon(vagon3L3);
		metroL3.anadirVagon(vagon4L3);
		
		
		
		Linea linea3 = new Linea("3", "Villaverde Alto/Moncloa", "Amarillo", 16.424, villaverdeAlto, metroL3);
		linea3.anadirEstacion(moncloa);
		
		
		//Linea 4
		Estacion arguelles = new Estacion("Arguelles");
		Estacion pinarChamartin = new Estacion("Pinar de Chamartin");
		
		
		Vagon vagon1L4 = new Vagon("Vagon1 L4", true);
		Vagon vagon2L4 = new Vagon("Vagon2 L4", true);
		Vagon vagon3L4 = new Vagon("Vagon3 L4", true);
		Vagon vagon4L4 = new Vagon("Vagon4 L4", true);
		
		
		Metro metroL4 = new Metro("Tren L4", 0, "via1 L4", "via2 L4", vagon1L4);
		metroL4.anadirVagon(vagon2L4);
		metroL4.anadirVagon(vagon3L4);
		metroL4.anadirVagon(vagon4L4);
		
		
		
		Linea linea4 = new Linea("4", "Arguelles/Pinar de Chamartin", "Marron", 16, arguelles, metroL4);
		linea4.anadirEstacion(pinarChamartin);
		

		//Linea 6
		Estacion pPio = new Estacion("Principe Pio");
		Estacion pzaEliptica = new Estacion("Plaza Eliptica");
		
		
		Vagon vagon1L6 = new Vagon("Vagon1L6", true);
		Vagon vagon2L6 = new Vagon("Vagon2L6", true);
		Vagon vagon3L6 = new Vagon("Vagon3L6", true);
		Vagon vagon4L6 = new Vagon("Vagon4L6", true);
		
		
		Metro metroL6 = new Metro("Tren L6", 0, "via1L6", "via2L6", vagon1L6);
		metroL6.anadirVagon(vagon2L6);
		metroL6.anadirVagon(vagon3L6);
		metroL6.anadirVagon(vagon4L6);
		
		
		
		Linea linea6 = new Linea("6", "Circular", "Gris", 23.5, pPio, metroL6);
		linea6.anadirEstacion(pzaEliptica);
		
		
		
		
		System.out.println("-----------------------------------------------------------"
				+ "\nLinea 3"
				+ "\n-----------------------------------------------------------"
				+ "\nEstacion 1: " + villaverdeAlto.getNombre()
				+ "\nEstacion 2: " + moncloa.getNombre()
				+ "\nTren: " + metroL3.getIdTren()
				+ "\n	Metro: " + metroL3.getId()
				+ "\n		Maquinas: 	" + metroL3.getNUM_MAQUINAS()
				+ "\n			Maquina 1:	" + metroL3.getMatriculaM1()
				+ "\n			Maquina 2:	" + metroL3.getMatriculaM2()
				+ "\n		Vagones:	" + metroL3.getNumVagones()
				+ "\n			Vagon 1"
				+ "\n				Matricula:	" + vagon1L3.getMatricula()
				+ "\n				Capacidad:	" + vagon1L3.getCapacidad()
				+ "\n				Puertas: 	" + vagon1L3.getPuertas()
				+ "\n			Vagon 2"
				+ "\n				Matricula:	" + vagon2L3.getMatricula()
				+ "\n				Capacidad:	" + vagon2L3.getCapacidad()
				+ "\n				Puertas: 	" + vagon2L3.getPuertas()
				+ "\n			Vagon 3"
				+ "\n				Matricula:	" + vagon3L3.getMatricula()
				+ "\n				Capacidad:	" + vagon3L3.getCapacidad()
				+ "\n				Puertas: 	" + vagon3L3.getPuertas()
				+ "\n-----------------------------------------------------------"
				+ "\n-----------------------------------------------------------"
				+ "\nLinea 4"
				+ "\n-----------------------------------------------------------"
				+ "\nEstacion 1: " + arguelles.getNombre()
				+ "\nEstacion 2: " + pinarChamartin.getNombre()
				+ "\nTren: " + metroL4.getIdTren()
				+ "\n	Metro: " + metroL4.getId()
				+ "\n		Maquinas: " + metroL4.getNUM_MAQUINAS()
				+ "\n			Maquina 1:	" + metroL4.getMatriculaM1()
				+ "\n			Maquina 2:	" + metroL4.getMatriculaM2()
				+ "\n		Vagones: " + metroL4.getNumVagones()
				+ "\n			Vagon 1"
				+ "\n				Matricula:	" + vagon1L4.getMatricula()
				+ "\n				Capacidad:	" + vagon1L4.getCapacidad()
				+ "\n				Puertas: 	" + vagon1L4.getPuertas()
				+ "\n			Vagon 2"
				+ "\n				Matricula:	" + vagon2L4.getMatricula()
				+ "\n				Capacidad:	" + vagon2L4.getCapacidad()
				+ "\n				Puertas: 	" + vagon2L4.getPuertas()
				+ "\n			Vagon 3"
				+ "\n				Matricula:	" + vagon3L4.getMatricula()
				+ "\n				Capacidad:	" + vagon3L4.getCapacidad()
				+ "\n				Puertas: 	" + vagon3L4.getPuertas()
				+ "\n			Vagon 4"
				+ "\n				Matricula:	" + vagon4L4.getMatricula()
				+ "\n				Capacidad:	" + vagon4L4.getCapacidad()
				+ "\n				Puertas: 	" + vagon4L4.getPuertas()
				+ "\n-----------------------------------------------------------"
				+ "\n-----------------------------------------------------------"
				+ "\nLinea 6"
				+ "\n-----------------------------------------------------------"
				+ "\nEstacion 1: " + pPio.getNombre()
				+ "\nEstacion 2: " + pzaEliptica.getNombre()
				+ "\nTren: " + metroL6.getIdTren()
				+ "\n	Metro: " + metroL6.getId()
				+ "\n		Maquinas: " + metroL6.getNUM_MAQUINAS()
				+ "\n			Maquina 1:	" + metroL6.getMatriculaM1()
				+ "\n			Maquina 2:	" + metroL6.getMatriculaM2()
				+ "\n		Vagones: " + metroL6.getNumVagones()
				+ "\n			Vagon 1"
				+ "\n				Matricula:	" + vagon1L6.getMatricula()
				+ "\n				Capacidad:	" + vagon1L6.getCapacidad()
				+ "\n				Puertas: 	" + vagon1L6.getPuertas()
				+ "\n			Vagon 2"
				+ "\n				Matricula:	" + vagon2L6.getMatricula()
				+ "\n				Capacidad:	" + vagon2L6.getCapacidad()
				+ "\n				Puertas: 	" + vagon2L6.getPuertas()
				+ "\n			Vagon 3"
				+ "\n				Matricula:	" + vagon3L6.getMatricula()
				+ "\n				Capacidad:	" + vagon3L6.getCapacidad()
				+ "\n				Puertas: 	" + vagon3L6.getPuertas()
				+ "\n			Vagon 4"
				+ "\n				Matricula:	" + vagon4L6.getMatricula()
				+ "\n				Capacidad:	" + vagon4L6.getCapacidad()
				+ "\n				Puertas: 	" + vagon4L6.getPuertas()
				+ "\n-----------------------------------------------------------");
		
		
		
		
	}

}
