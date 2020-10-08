import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Integrantes del Grupo 8:
 * Andrés Ayala Llopis Nº21821611
 * Eddy Lucandy Alexandre Nº21417106
 * Carlos de Martin Juan Nº21748574
 */

public class main {

	public static void main(String[] args) {
		
		String[][] datos_elemento = {{"AtomicNumber","Element","Symbol","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","Group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence"}};
		
		int opcion = 0;
		Scanner teclado = new Scanner (System.in);
		
		//Carga automática del .csv
		datos_elemento = lectura_datos_matriz("matriz.csv");
		System.out.println("El archivo de ha cargado con éxito");
		System.out.println("");
		
		//carga csv / mostrar lista completa / filtrar por / buscar elemento / creditos / salir (numero atomico, simbolo, metal no metal, radioactivo no radioactivo, putno de ebullicion)
		
		while (opcion !=10) {
			opcion = elegir_opcion();
			switch(opcion) {
			case 1:
				listar_datos(datos_elemento);
				break;
			case 2:
				System.out.print("Filtro número atómico activado: \n");
					for (int i=1; i<datos_elemento.length; i++) {
						String matriz =
								datos_elemento[0][1] + ": " + datos_elemento[i][1] + "\n" + 
								datos_elemento[0][0] + ": " + datos_elemento[i][0] + "\n" + 
								"-----------------------------------------------------------";
						System.out.println(matriz);
					}
				break;
			case 3:
				System.out.print("Filtro por símbolo activado: \n");
				for (int i=1; i<datos_elemento.length; i++) {
					String matriz =
							datos_elemento[0][1] + ": " + datos_elemento[i][1] + "\n" + 
							datos_elemento[0][2] + ": " + datos_elemento[i][2] + "\n" + 
							"-----------------------------------------------------------";
					System.out.println(matriz);
				}
				break;
			case 4:
				System.out.print("Filtro por origen activado: ");
				for (int i=1; i<datos_elemento.length; i++) {
					String matriz =
							datos_elemento[0][1] + ": " + datos_elemento[i][1] + "\n" + 
							datos_elemento[0][11] + ": " + datos_elemento[i][11] + "\n" + 
							"-----------------------------------------------------------";
					System.out.println(matriz);
				}
				break;
			case 5:
				System.out.print("Filtro de metales activado: ");
				for (int i=1; i<datos_elemento.length; i++) {
					String matriz =
							datos_elemento[0][1] + ": " + datos_elemento[i][1] + "\n" + 
							datos_elemento[0][12] + ": " + datos_elemento[i][12] + "\n" + 
							"-----------------------------------------------------------";
					System.out.println(matriz);
				}
				break;
			case 6:
				System.out.print("Filtro de radioactividad activado: ");
				for (int i=1; i<datos_elemento.length; i++) {
					String matriz =
							datos_elemento[0][1] + ": " + datos_elemento[i][1] + "\n" + 
							datos_elemento[0][10] + ": " + datos_elemento[i][10] + "\n" + 
							"-----------------------------------------------------------";
					System.out.println(matriz);
				}
				break;
			case 7:
				System.out.print("Filtro de masa atómica activado: ");
				for (int i=1; i<datos_elemento.length; i++) {
					String matriz =
							datos_elemento[0][1] + ": " + datos_elemento[i][1] + "\n" + 
							datos_elemento[0][3] + ": " + datos_elemento[i][3] + "\n" + 
							"-----------------------------------------------------------";
					System.out.println(matriz);
				}
				break;
			case 8:
				System.out.print("Introduzca nombre del elemento que quiera buscar:  \n");
				System.out.print("[En inglés y la primera con mayúscula :)]  \n");
				String nombre = teclado.nextLine();
				if (existe_elemento(nombre, extraer_columna(datos_elemento, 1)) ) {
					
					for (int i=1; i<datos_elemento.length; i++) {
						
						//Queda pendiente el cambio por buble while para optimizar el código
						
						if (datos_elemento[i][1].equals(nombre)) {
							String matriz =
									datos_elemento[0][1] + ": " + datos_elemento[i][1] + "\n" + 
									datos_elemento[0][0] + ": " + datos_elemento[i][0] + "\n" + 
									datos_elemento[0][2] + ": " + datos_elemento[i][2] + "\n" + 
									datos_elemento[0][3] + ": " + datos_elemento[i][3] + "\n" +
									datos_elemento[0][4] + ": " + datos_elemento[i][4] + "\n" +
									datos_elemento[0][5] + ": " + datos_elemento[i][5] + "\n" +
									datos_elemento[0][6] + ": " + datos_elemento[i][6] + "\n" + 
									datos_elemento[0][7] + ": " + datos_elemento[i][7] + "\n" + 
									datos_elemento[0][8] + ": " + datos_elemento[i][8] + "\n" + 
									datos_elemento[0][9] + ": " + datos_elemento[i][9] + "\n" + 
									datos_elemento[0][10] + ": " + datos_elemento[i][10] + "\n" + 
									datos_elemento[0][11] + ": " + datos_elemento[i][11] + "\n" + 
									datos_elemento[0][12] + ": " + datos_elemento[i][12] + "\n" + 
									datos_elemento[0][13] + ": " + datos_elemento[i][13] + "\n" + 
									datos_elemento[0][14] + ": " + datos_elemento[i][14] + "\n" + 
									datos_elemento[0][15] + ": " + datos_elemento[i][15] + "\n" + 
									datos_elemento[0][16] + ": " + datos_elemento[i][16] + "\n" + 
									datos_elemento[0][17] + ": " + datos_elemento[i][17] + "\n" + 
									datos_elemento[0][18] + ": " + datos_elemento[i][18] + "\n" + 
									datos_elemento[0][19] + ": " + datos_elemento[i][19] + "\n" + 
									datos_elemento[0][20] + ": " + datos_elemento[i][20] + "\n" + 
									datos_elemento[0][21] + ": " + datos_elemento[i][21] + "\n" + 
									datos_elemento[0][22] + ": " + datos_elemento[i][22] + "\n" + 
									datos_elemento[0][23] + ": " + datos_elemento[i][23] + "\n" + 
									datos_elemento[0][24] + ": " + datos_elemento[i][24] + "\n" + 
									datos_elemento[0][25] + ": " + datos_elemento[i][25] + "\n" + 
									datos_elemento[0][26] + ": " + datos_elemento[i][26] + "\n" +
									"-----------------------------------------------------------";
							System.out.println(matriz);
						} 
					} 
				}
				else {
					System.out.println("El nombre " + nombre + " no ha sido encontrado...");
				}
				break;
			case 9:
				System.out.println("Universidad Europea Copyright®");
				System.out.println("-----------------------");
				System.out.println("");
				System.out.println("Información de los Alumnos:");
				System.out.println("");
				System.out.println("Andrés Ayala Llopis Exp 21821611 // Carlos de Martin Juan Exp 21748574 // Eddy Lucandy Alexandre Exp 21417106");
				System.out.println("Fecha de entrega del proyecto 23/01/2020");
				System.out.println("Proyecto III Programación I");
				System.out.println("Universidad Europea de Madrid");
				System.out.println("1º Curso Ingeniería Informática");
				System.out.println("");
				break;
			case 10:
				System.out.println("¡¡Hasta Luego!!");
				break;
			default:
				System.out.println("Opción no válida!!");
				break;
			} //switch final
		} //while final
	} //main final
		

	
	//-------------Funciones Auxiliares-----------------//
	
	public static int elegir_opcion() {
		Scanner teclado = new Scanner(System.in);
		int opcion = 0;
		String mensaje =
				"----------Tabla Periódica v1.0---------\r\n"+
				"\r\n"+
				"Indique la acción que desea realizar:\n\r"+
				"1. Mostrar lista completa\r\n"+
				"2. Filtro (nº Atómico)\r\n"+
				"3. Filtro (simbolo del elemento)\r\n"+
				"4. Filtro (origen)\r\n"+
				"5. Filtro (metales)\r\n"+
				"6. Filtro (radioactividad)\r\n"+
				"7. Filtro (masa atómica)\r\n"+
				"8. Buscar Elemento\r\n"+
				"9. Información del proyecto\r\n"+
				"10. Salir";
		
		System.out.println(mensaje);
		if(teclado.hasNextInt()) {
			opcion = teclado.nextInt();
		} return opcion;
	} //fin elegir opcion
	
	public static String[] extraer_fila (String[][] datos, int indice_fila) {
		String[] fila = new String[datos[1].length-1];
		
		for (int i = 0; i< fila.length; i++) {
			fila[i] = datos[i+1][indice_fila];
		} return fila;
		}
	
	//Codigo que no funcionaba por alguna razon (esta aqui como algo simbolico)
	
	/*public static int contar_lineas(String ruta) {
		int lineas = 0;
		try {
			Scanner fichero = new Scanner(new File(ruta));
			while(fichero.hasNextLine()) {
				lineas++;
				fichero.hasNextLine();
			} fichero.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha habido un error contando las lineas de: " + ruta);
		} return lineas;
	} //Fin contar lineas
	
	public static int contar_columnas(String ruta) {
		int columnas =0;
		String primeraLinea="";
		try {
			Scanner fichero = new Scanner(new File(ruta));
			if(fichero.hasNextLine()) {
				primeraLinea = fichero.nextLine();
			} fichero.close();
		} catch(FileNotFoundException e) {
			System.out.println("Ha habido un error contando las columnas de: " + ruta);
		} columnas = primeraLinea.split(",").length; return columnas;
	} //Final contar columnas
	
	public static String[] extraer_columna(String[][] datos_elemento, int indice_columna) {
		String[] columna = new String[datos_elemento.length-1];
		for(int i=0; i<columna.length;i++) {
			columna[i] = datos_elemento[i+1][indice_columna];
		} return columna;
	} //Fin extraer columna
	
	public static String[][] lectura_datos_matriz(String ruta){
		String[][] datos_elemento;
		String linea;
		int fila = 0;
		int filas = contar_lineas(ruta);
		int columnas = contar_columnas(ruta);
		datos_elemento = new String[filas][columnas];
		try {
			Scanner fichero = new Scanner(new File(ruta));
			while(fichero.hasNextLine()) {
				linea=fichero.nextLine();
				datos_elemento[fila]=linea.split(",");
				fila++;
			} fichero.close();
		} catch(FileNotFoundException e) {
			System.out.println("Ha habido un error leyendo los datos de: "+ ruta);
		} return datos_elemento;
	} //Final lectura datos matriz*/
	
public static int contar_lineas(String ruta) {
		
		int lineas = 0;
		try {
				Scanner fichero = new Scanner(new File(ruta));
				while (fichero.hasNextLine()) {
					lineas++;
					fichero.nextLine();
				} fichero.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha habido una error encontrando las lineas de " + ruta);
		} return lineas;
	}
	
	public static int contar_columnas(String ruta) {
		int columnas = 0;
		String primeraLinea="";
		
		try {
				Scanner fichero = new Scanner(new File(ruta));
				if (fichero.hasNextLine()) {
					primeraLinea = fichero.nextLine();
				} fichero.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha habido un error contando las columnas de " + ruta);
		} columnas = primeraLinea.split(",").length; return columnas;
	} //contar columnas FINAL
	
	public static String[] extraer_columna (String[][] datos_usuarios, int indice_columna) {
		
		String[] columna = new String[datos_usuarios.length-1];
		
		for (int i = 0; i< columna.length; i++) {
			columna[i] = datos_usuarios[i+1][indice_columna];
		} return columna;
	} // Extraer columna FINAL
	

	
	public static String[][] lectura_datos_matriz(String ruta) {
		
		String[][] datos_elemento;
		String linea;
		int fila = 0;
		
		int filas = contar_lineas(ruta);
		int columnas = contar_columnas(ruta);
		
		datos_elemento = new String[filas][columnas];
		
		try {
			Scanner fichero = new Scanner(new File(ruta));
			while (fichero.hasNextLine()) {
				linea = fichero.nextLine();
				datos_elemento[fila] = linea.split(",");
				fila++;
			} fichero.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha habido un error leyendo los datos de " + ruta);
		} return datos_elemento;
	} // Lectura datos matriz FINAL
	

	

	
	//----------Funciones Específicas---------//
	
	public static boolean existe_elemento(String element, String[] elements) {
		boolean encontrado = false;
				int i =0;
		while(!encontrado&&i<elements.length) {
			System.out.println(elements[i] + "," + element);
			if(elements[i].contentEquals(element)) {
				encontrado = true;
			} i++;
		} return encontrado;
	} //Final Existe elemento
	
	public static void listar_datos(String[][] datos_elemento) {
		//28 columnas de datos totales
		for (int i=1; i<datos_elemento.length; i++) {
			String matriz =
					datos_elemento[0][1] + ": " + datos_elemento[i][1] + "\n" + 
					datos_elemento[0][0] + ": " + datos_elemento[i][0] + "\n" + 
					datos_elemento[0][2] + ": " + datos_elemento[i][2] + "\n" + 
					datos_elemento[0][3] + ": " + datos_elemento[i][3] + "\n" +
					datos_elemento[0][4] + ": " + datos_elemento[i][4] + "\n" +
					datos_elemento[0][5] + ": " + datos_elemento[i][5] + "\n" +
					datos_elemento[0][6] + ": " + datos_elemento[i][6] + "\n" + 
					datos_elemento[0][7] + ": " + datos_elemento[i][7] + "\n" + 
					datos_elemento[0][8] + ": " + datos_elemento[i][8] + "\n" + 
					datos_elemento[0][9] + ": " + datos_elemento[i][9] + "\n" + 
					datos_elemento[0][10] + ": " + datos_elemento[i][10] + "\n" + 
					datos_elemento[0][11] + ": " + datos_elemento[i][11] + "\n" + 
					datos_elemento[0][12] + ": " + datos_elemento[i][12] + "\n" + 
					datos_elemento[0][13] + ": " + datos_elemento[i][13] + "\n" + 
					datos_elemento[0][14] + ": " + datos_elemento[i][14] + "\n" + 
					datos_elemento[0][15] + ": " + datos_elemento[i][15] + "\n" + 
					datos_elemento[0][16] + ": " + datos_elemento[i][16] + "\n" + 
					datos_elemento[0][17] + ": " + datos_elemento[i][17] + "\n" + 
					datos_elemento[0][18] + ": " + datos_elemento[i][18] + "\n" + 
					datos_elemento[0][19] + ": " + datos_elemento[i][19] + "\n" + 
					datos_elemento[0][20] + ": " + datos_elemento[i][20] + "\n" + 
					datos_elemento[0][21] + ": " + datos_elemento[i][21] + "\n" + 
					datos_elemento[0][22] + ": " + datos_elemento[i][22] + "\n" + 
					datos_elemento[0][23] + ": " + datos_elemento[i][23] + "\n" + 
					datos_elemento[0][24] + ": " + datos_elemento[i][24] + "\n" + 
					datos_elemento[0][25] + ": " + datos_elemento[i][25] + "\n" + 
					datos_elemento[0][26] + ": " + datos_elemento[i][26] + "\n" +
					"-----------------------------------------------------------";
			System.out.println(matriz);
		}
	} //Final listar datos
	
	
}


