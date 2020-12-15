import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Autor: Javier Sánchez Soriano
 * Fecha creación:		20/11/2018
 * Fecha modificación: 	14/12/2018 (gestión de ficheros)
 * 
 * INFO: Calculadora de matrices. Enunciado disponible Campus Virtual.
 */

public class GestionMatrices {

	public static void main(String[] args) {
		// Pruebas para las funciones de manejo de ficheros
		/*
		double[][] m = {{1,3,4},{2,6,8}};
		escrituraFichero(m, "salida.csv");
		System.out.println("lineas: " + contarLineasFichero("salida.csv"));
		System.out.println("columnas: " + contarColumnasFichero("salida.csv"));
		
		double[][] e = lecturaFichero("salida.csv");
		listarMatriz(e);
		System.out.println("¿Son iguales? " + compararMatrices(m, e));
		*/
		
		// Variables del programa
		double[][] matriz1 = {};
		double[][] matriz2 = {};
		Scanner teclado = new Scanner(System.in);
		int opcion = 0;
		int idMatriz = 0;
	
		// Bucle principal
		while (opcion != 10) {
			// Informar al usuario de las opciones y recogerlas
			opcion = elegirOpcion (teclado);
			switch(opcion) {
			
			case 0: // Cargar de fichero
				// Carga de datos
				char  cargar;
				System.out.println("¿Desea cargar los datos (s/n)?");
				cargar = teclado.next().charAt(0);
				if (cargar == 's' || cargar =='S' || cargar == 'y' || cargar =='Y') {
					matriz1 = lecturaFichero("matriz1.csv");
					matriz2 = lecturaFichero("matriz2.csv");
					System.out.println("Datos cargados correctamente!");
				}
				
				break;
			case 1: //Introducir Matriz
				System.out.print("Introducción de datos. ");
				idMatriz = elegirMatriz(teclado);
				
				if (idMatriz == 1) {
					matriz1 = lecturaMatriz (teclado);
				}
				else {	// Forzamos que fuera 1 o 2
					matriz2 = lecturaMatriz (teclado);
				}
				break;
			case 2: //Listar Matriz
				System.out.print("Listar datos. ");
				idMatriz = elegirMatriz(teclado);
				
				if (idMatriz == 1) {
					listarMatriz (matriz1);
				}
				else {	// Forzamos que fuera 1 o 2
					listarMatriz (matriz2);
				}
				
				break;
			case 3: //Comparar Matrices
				if (compararMatrices(matriz1, matriz2)) {
					System.out.println("Son iguales :D ");
				}
				else {
					System.out.println("Son distintas :( ");
				}
				break;
			case 4: //Sumar Matrices
				double[][] suma = sumarMatrices(matriz1, matriz2);
				System.out.println("La suma de las matrices es:");
				listarMatriz(suma);
				break;
			case 5: //Restar Matrices
				/* 
				//opcion restar a la primera la segunda
				double[][] resta = restarMatrices(matriz1, matriz2);
				System.out.println("La resta de las matrices es:");
				listarMatriz(resta);
				*/
				
				System.out.print("¿A cual desea restar? ");
				idMatriz = elegirMatriz(teclado);
				double[][] resta;
				
				if (idMatriz == 1) {
					resta = restarMatrices(matriz1, matriz2);
				}
				else {	// Forzamos que fuera 1 o 2
					resta = restarMatrices(matriz2, matriz1);
				}
				listarMatriz(resta);
				
				break;
			case 6: //Multiplicar por un escalar
				break;
			case 7: //Transponer
				break;
			case 8: //Multiplicar matrices 
				break;
			case 9: //Guardar matrices en fichero
				guardarDatos(matriz1, matriz2, teclado);
				break;
			case 10: //Salir 
				guardarDatos(matriz1, matriz2, teclado);
				System.out.println("Muchas gracias, ¡hasta pronto!");
				break;
			default: //Introducir Matriz
				System.out.println("¡Opción Incorrecta!");
				break;
			} // fin del switch
		} // fin del while
	} // Fin del main

	public static void guardarDatos(double[][] matriz1, double[][] matriz2, Scanner teclado) {
		char opcion;
		System.out.println("¿Desea guardar los datos (s/n)?");
		opcion = teclado.next().charAt(0);
		
		if (opcion=='s' || opcion=='S' || opcion=='y' || opcion=='Y') {
			System.out.println("Se va a guardar el contenido de las matrices.");
			escrituraFichero(matriz1, "matriz1.csv");
			escrituraFichero(matriz2, "matriz2.csv");
			System.out.println("Datos guardados correctamente.");
		}
		else {
			System.out.println("¡¡NO se han guardado los datos!!");
		}
	}

	// Transponer matriz
	public static double[][] transponerMatriz (double[][] matriz) {
		double[][] transpuesta;	// Las dimesiones se intercambian
		transpuesta = new double [matriz[0].length][matriz.length];
		
		for (int i=0; i< matriz.length; i++) {
			for (int j=0; j< matriz[0].length; j++) {
				transpuesta[j][i] = matriz[i][j]; // se transponen los elementos
			}
		}
		
		
		return transpuesta;
	}
	
	// Sumar dos matrices
	public static double[][] restarMatrices(double[][] matriz1, double[][] matriz2) {
		double[][] resultado = {};
		
		if (mismaDimension(matriz1, matriz2)) {
			// reservamos espacio para el resultado
			resultado = new double[matriz1.length][matriz1[0].length];
			
			for (int i=0; i< matriz1.length; i++) {
				for (int j=0; j< matriz1[0].length; j++) {
					resultado[i][j] =  matriz1[i][j] - matriz2[i][j];
				}
			}
			
		}
		else {
			System.out.println("No se pueden restar por tener diferentes dimensiones.");
		}
		
		return resultado;
	}
	
	// Sumar dos matrices
	public static double[][] sumarMatrices(double[][] matriz1, double[][] matriz2) {
		2
		
		if (mismaDimension(matriz1, matriz2)) {
			// reservamos espacio para el resultado
			resultado = new double[matriz1.length][matriz1[0].length];
			
			for (int i=0; i< matriz1.length; i++) {
				for (int j=0; j< matriz1[0].length; j++) {
					resultado[i][j] =  matriz1[i][j] + matriz2[i][j];
				}
			}
			
		}
		else {
			System.out.println("No se pueden sumar por tener diferentes dimensiones.");
		}
		
		return resultado;
	}
	
	
	// Comparar dimensiones de matrices
	public static boolean mismaDimension (double[][] matriz1, double[][] matriz2) {
		// vamos a mirar si tienen el mismo número de filas
		return ((matriz1.length == matriz2.length) && 		
				(matriz1[0].length == matriz2[0].length));
	}
	
	// Pinta matrices en base a sus dimensiones
	public static void listarMatriz (double[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			// dentro de cada fila, recorremos las columnas
			for(int j=0; j< matriz[0].length; j++)  {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println();
		}		
	}
	
	// Ofrecer opciones al usuario y devolver la elegida
	public static int elegirMatriz (Scanner teclado) {
		int opcion = 0;

		while ( opcion != 1 && opcion != 2 ) {
			System.out.print("Elija matriz (1 / 2):");
			
			if (teclado.hasNextInt()) {
				opcion = teclado.nextInt();
			}
			else {
				teclado.next();
			}	
		} // Fin del while

		return opcion;
	} // Fin del elegirMatriz
	
	// Ofrecer opciones al usuario y devolver la elegida
	public static int elegirOpcion (Scanner teclado) {
		int opcion = 0;
		String mensaje = 
				"--- Bienvenido a gestión de matrices ---\r\n" + 
				"Indique la operación que desea realizar:\r\n" + 
				"0. Cargar matrices\r\n" + 
				"1. Introducir Matriz\r\n" + 
				"2. Listar Matriz\r\n" + 
				"3. Comparar Matrices\r\n" + 
				"4. Sumar Matrices\r\n" + 
				"5. Restar Matrices\r\n" + 
				"6. Multiplicar por un escalar\r\n" + 
				"7. Transponer\r\n" + 
				"8. Multiplicar matrices\r\n" + 
				"9. Guardar matrices\r\n" + 
				"10. Salir";
		
		System.out.println(mensaje);
		if (teclado.hasNextInt()) {
			opcion = teclado.nextInt();
		}
		else { // si el usuario puso algo distinto de un entero hay que consumirlo
			teclado.next();
		}
		
		return opcion;
	} // Fin del elegirOpcion
	
	// Leer de teclado una matriz
	public static double[][] lecturaMatriz (Scanner teclado) {
		double[][] matriz = null;
		int filas = 0;
		int columnas = 0;
		//Scanner teclado = new Scanner(System.in);

		// solicitamos dimensiones
		System.out.print("Introduzca el número de filas:   ");
		filas = teclado.nextInt();
		System.out.print("Introduzca el número de columnas:");
		columnas = teclado.nextInt();
		
		// reservamos el espacio
		matriz = new double[filas][columnas];
		
		// solicitamos los datos al usuario
		for (int i=0; i<matriz.length; i++) {
			for (int j=0; j<matriz[0].length; j++) {
				System.out.print("valor("+(i+1)+","+(j+1)+"): ");
				matriz[i][j] = teclado.nextDouble();
			}
		}
		
		return matriz;
	} // Fin del lecturaMatriz
	
	// Comprar dos matrices (tiene en cuenta las dimensiones)
	public static boolean compararMatrices(double[][] matriz1, double[][] matriz2) {

		boolean iguales = true;
		int comparaciones = 0; // guardar el numero de comparaciones

		// --- Vamos a comprobar las dimensiones ---//
		if ( mismaDimension(matriz1,matriz2) ) {	
			//System.out.println("tienen las mismas dimensiones"); 
			// vamos a comprar elemento a elemento
			int i=0;
			while (i<matriz1.length && iguales) {// vamos recorriendo filas
				int j=0;
				while (j<matriz1[0].length && iguales) {// vamos recorriendo columnas
					if (matriz1[i][j] != matriz2[i][j]) {
						iguales = false;
					}
					j++;
					comparaciones++;
				}
				i++;
			}
		}
		else {	// Las matrices no tienen las mismas dimensiones
			iguales = false; 
		}		
		return iguales;
	} // Fin del compararMatrices
	
	
	///------- Manejo de ficheros: 11/12/2018 ---------///
	public static void escrituraFichero (double[][] matriz, String ruta) {
		FileWriter fichero;
		try {
			fichero = new FileWriter(ruta);
			for(int i=0; i< matriz.length; i++) {
				for (int j=0; j<matriz[0].length; j++) {
					fichero.write("" + matriz[i][j]); // convertimos el double a un String
					// Hay que poner ; entre cada valor, excepto en el último
					if (j != (matriz[0].length-1)) {
						fichero.write(";");
					}
				}
				fichero.write("\n"); // Fin de la fila 
			}
		fichero.close();
			
		} catch (IOException e) {
			System.out.println("ERRO ESCRITURA FICHERO: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static double[][] lecturaFichero(String ruta) {
		double[][] matriz = null;
		String linea;
		int fila = 0;
		
		// Tenemos que averiguar el número de lineas del fichero : FILAS
		// Tenemos que averiguar el número de columnas de una fila del fichero : COLUMNAS
		int filas	= contarLineasFichero(ruta);
		int columnas= contarColumnasFichero(ruta);
		
		// Reservamos espacio a la matriz
		matriz = new double[filas][columnas];
		
		// Vamos a abrir el fichero para leerlo
		try {
			Scanner fichero = new Scanner(new File(ruta));
			while (fichero.hasNextLine()) {
				linea = fichero.nextLine();
				//fila tiene los elementos en tipo String
				matriz[fila] = convertir_array_str_double(linea.split(";"));
				fila++;
			}
			fichero.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha habido un error leyendo la matriz de " + ruta);
		}
		
		
		return matriz;
	}
	
	public static double[] convertir_array_str_double (String[] valores_str) {
		double[] valores = new double[valores_str.length];
		for (int i=0; i<valores_str.length; i++) {
			valores[i] = Double.parseDouble(valores_str[i]); // "234.0", "-3.0", ...
		}	
		return valores;
	}
	
	public static int contarLineasFichero(String ruta) {
		int lineas = 0;
		//Usamos Scanner para contar las lineas
		try {
			Scanner fichero = new Scanner(new File(ruta));
			while (fichero.hasNextLine()) {
				lineas++;
				fichero.nextLine();
			}
			fichero.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha habido un error contando las lineas de " + ruta);
		}
		return lineas;
	}
	
	public static int contarColumnasFichero(String ruta) {
		int columnas = 0;
		String primeraLinea="";
		
		//Usamos Scanner para contar las lineas
		try {
			Scanner fichero = new Scanner(new File(ruta));
			if (fichero.hasNextLine()) {
				primeraLinea = fichero.nextLine();
			}
			fichero.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha habido un error contando las columnas de " + ruta);
		}
		//primeraLinea algo de este estilo: "3.5;-4.0;88.0"
		columnas = primeraLinea.split(";").length;
		
		return columnas;
	}
	
	
	
	
	
	
	
	

}	// Fin del class GestionMatrices