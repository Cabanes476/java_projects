import java.io.File;
import java.io.FileNotFoundException;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * Autor: Javier S�nchez Soriano
 * Fecha creaci�n:		18/12/2018
 * Fecha modificaci�n: 	21/12/2018
 * 
 * PROGRAMA
 * 1. M�todo main que con el programa principal
 * 2. Debe contener funciones
 * 		2.1 Para realizar las actividades necesarias
 * 		2.2 Se pueden crear funciones auxiliares de apoyo si lo cree necesario
 * 3. Debe ofrecer un men� que oriente al usuario y permita realizar todas las 
 * 		opciones que ofrecen las funciones codificadas (interacci�n consola) as�
 * 		como salir del programa.
 */

public class GestionAlumnos {

	public static void main(String[] args) {
		String[][] datos = {{"Apellidos","Nombre","Expediente","�ltimo Acceso"}}; // De primeras no hay datos, solo las cabecera
		int opcion = 0;
		Scanner teclado = new Scanner(System.in);
		
		// Bucle principal
		while (opcion != 8) { // 8 - Opci�n salir
			// Informar al usuario de las opciones y recogerlas
			opcion = elegir_opcion ();
			switch(opcion) {
				case 1: // Cargar alumnos
					datos = lectura_datos_matriz("alumnos.csv");
					break;
				case 2: // Listar alumnos
					listar_datos(datos);
					break;
				case 3: // Buscar nombre
					System.out.print("Introduzca nombre para buscar: ");
					String nombre = teclado.nextLine();
					if (existe_nombre(nombre, extraer_columna(datos, 1)) ) {
						System.out.println(nombre + " Encontrado! :D");
					}
					else {
						System.out.println(nombre + " NO Encontrado! :(");
					}
					break;
				case 4: // Buscar usuario
					break;
				case 5: // Matricular usuario
					datos = solicitar_matricular_usuario(datos);
					break;
				case 6: // Alumno en riesgo de abandono
					System.out.print("Introduzca el periodo de b�squeda (dias): ");
					int dias = teclado.nextInt(); teclado.nextLine();
					alumno_riesgo_abandono(dias, datos);
					break;
				case 7: // Guardar alumnos
						break;
				case 8: //Salir 
					System.out.println("Muchas gracias, �hasta pronto!");
					break;
				default:
					System.out.println("�Opci�n Incorrecta!");
					break;
			} // fin del switch
		} // fin del while
	} // fin del main
	
	// La usamos para que el men� quede m�s limpio resutilizando matricular_usuario
	public static String[][] solicitar_matricular_usuario(String[][] datos) {
		String nombre;
		String apellidos;
		String expediente;
		String fecha;
		
		Date ahora = new Date();	// 03/12/2018 18:10
		StringBuffer stringBuffer = new StringBuffer();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		simpleDateFormat.format(ahora, stringBuffer, new FieldPosition(0));
		fecha = stringBuffer.toString();
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduzca nombre:");
		nombre = teclado.nextLine();
		System.out.print("Introduzca apellidos:");
		apellidos = teclado.nextLine();
		System.out.print("Introduzca expediente:");
		expediente = teclado.nextLine();
		
		datos = matricular_usuario(nombre, apellidos, expediente, fecha, datos);
		return datos;
	}

	/*
	 * FUNCI�N: lectura_datos_csv
	 * Par�metros: ruta fichero
	 * Resultado: Matriz (MxN) con los datos del csv
	 * 		M: N�mero de filas del fichero
	 * 		N: N�mero de columnas del fichero
	 * Sugerencia: manejar todo como String (matriz de Strings)
	 * AYUDA: Usar funci�n split de la clase String (sig. Diapositiva)
	 */
	public static String[][] lectura_datos_matriz(String ruta) {
		String[][] datos = null;
		String linea;
		int fila = 0;
		
		// Tenemos que averiguar el n�mero de lineas del fichero : FILAS
		// Tenemos que averiguar el n�mero de columnas de una fila del fichero : COLUMNAS
		int filas	= contar_lineas_fichero(ruta);
		int columnas= contar_columnas_fichero(ruta);
		
		// Reservamos espacio a la matriz
		datos = new String[filas][columnas];
		
		// Vamos a abrir el fichero para leerlo
		try {
			Scanner fichero = new Scanner(new File(ruta));
			while (fichero.hasNextLine()) {
				linea = fichero.nextLine();
				//fila tiene los elementos en tipo String
				datos[fila] = linea.split(";");
				fila++;
			}
			fichero.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha habido un error leyendo los datos de " + ruta);
		}
		
		
		return datos;
	} // fin lectura_datos_matriz
	
	/*
	 * FUNCI�N: listar_datos
	 * Par�metros: Matriz (MxN) con los datos
	 * Resultado: NO devuelve nada. Toda la informaci�n la muestra por consola
	 * 	bien �formateada�
	 */
	public static void listar_datos(String[][] datos) {
		for (int i=1; i<datos.length; i++) {
			String alumno =
					datos[0][1] + ": " + datos[i][1] + "\n" + // nombre
					datos[0][0] + ": " + datos[i][0] + "\n" + // apellidos
					datos[0][2] + ": " + datos[i][2] + "\n" + // expediente
					datos[0][3] + ": " + datos[i][3] + "\n" + // �ltimo acceso
					"-----------------------------------";
			System.out.println(alumno);
		}
		
	} // fin listar_datos
	
	/*
	 * FUNCI�N: existe_nombre
	 * Par�metros: nombre, array de nombres
	 * Resultado: booleano
	 * 		true: existe nombre dentro de array de nombres
	 * 		false: no existe
	 */
	public static boolean existe_nombre(String nombre, String[] nombres) {
		boolean encontrado = false;
		int i = 0;
		
		while(!encontrado && i<nombres.length) {
			//System.out.println(nombres[i] + ", " + nombre);
			if (nombres[i].equals(nombre)) {
				encontrado = true;
			}
			i++;
		}
		
		return encontrado;
	} // fin existe_nombre

	/*
	 * FUNCI�N: buscar_nombre
	 * Par�metros: nombre, Matriz (MxN) con los datos
	 * Resultado: NO devuelve nada. Toda la informaci�n de aquellas coincidencias
	 * 	con nombre las muestra por consola
	 */
	public static void buscar_nombre(String nombre,String[][] datos) {
	} // fin buscar_nombre
	
	/*
	 * FUNCI�N: buscar_usuario
	 * Par�metros: usuario (c�digo), Matriz (MxN) con los datos
	 * Resultado: NO devuelve nada. Toda la informaci�n de aquellas coincidencias 
	 * con usuario las muestra por consola
	 */
	public static void buscar_usuario(String usuario, String[][] datos) {
	} // fin buscar_usuario

	/*
	 * FUNCI�N: matricular_usuario
	 * Par�metros: datos de usuario nuevo, Matriz (MxN) con los datos
	 * Resultado: Matriz (M+1 x N) con el nuevo usuario dentro (al final)
	 * Mejora: Introduce al usuario por orden alfab�tico de apellido en la Matriz
	 */
	public static String[][] matricular_usuario(
			/*datos nuevo usuario*/
			String nombre,
			String apellidos,
			String expediente,
			String fecha,
			String[][] datos) {
		// Reservamos espacio para un usuario m�s
		String[][] resultado = new String[datos.length+1][4];
		
		// Copiamos los datos originales en la nueva matriz
		for (int i=0; i<datos.length; i++) {
			resultado[i] = datos[i];
		}
		
		// a�adir el nuevo usuario
		resultado[resultado.length-1][0] = apellidos;
		resultado[resultado.length-1][1] = nombre;
		resultado[resultado.length-1][2] = expediente;
		resultado[resultado.length-1][3] = fecha;
		
		System.out.println("resultado.length " + resultado.length);
		
		return resultado;
	} // fin matricular_usuario

	/*
	 * FUNCI�N: escritura_datos_csv
	 * Par�metros: nombre fichero, Matriz (MxN) con los datos 
	 * Resultado: Escribe la informaci�n de la matriz en un fichero con el nombre indicado
	*/
	public static void escritura_datos_csv(String ruta, String[][] datos) {

	} // fin escritura_datos_csv
	
	/*
	 * FUNCI�N: alumno_riesgo_abandono
	 * Par�metros: periodo(dias), Matriz (MxN) con los datos 
	 * Resultado: Escribe la informaci�n de aquellos alumos cuyo �ltimo acceso
	 * 	sea anterior al especificado en periodo. Se debe pensar como manejar
	 * 	fechas y c�mo definir periodo.
	*/
	public static void alumno_riesgo_abandono(int dias, String[][] datos) {		
		Date ahora = new Date();
		//System.out.println("ahora: " + ahora);
		//System.out.println("ahora (milis): " + ahora.getTime());
		
		for (int i=1; i<datos.length; i++) {
			try {
				Date acceso =new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(datos[i][3]);
				long dias_acceso = (ahora.getTime() - acceso.getTime())/1000/60/60/24;
				// convertimos los milisegundos a dias
				
				// Si el �ltimo acceso del usuario est� dentro del periodo (dias)
				if (dias_acceso > dias) {				
					String alumno =
							"D�as desde el �ltimo acceso: " + dias_acceso + "\n" +
							datos[0][1] + ": " + datos[i][1] + "\n" + // nombre
							datos[0][0] + ": " + datos[i][0] + "\n" + // apellidos
							datos[0][2] + ": " + datos[i][2] + "\n" + // expediente
							datos[0][3] + ": " + datos[i][3] + "\n" + // �ltimo acceso
							"-----------------------------------";
					System.out.println(alumno);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}	
		}
	} // fin alumno_riesgo_abandono
	
	/* --------------------------------------------------------
	 * ----------------- FUNCIONES AUXILIARES -----------------
	 * -------------------------------------------------------- */
	
	// Ofrecer opciones al usuario y devolver la elegida
	public static int elegir_opcion () {
		Scanner teclado = new Scanner(System.in);
		int opcion = 0;
		String mensaje = 
				"--- Bienvenido a Gesti�n de Alumnos ---\r\n" + 
				"Indique la operaci�n que desea realizar:\r\n" + 
				"1. Cargar alumnos\r\n" +  
				"2. Listar alumnos\r\n" + 
				"3. Buscar nombre\r\n" + 
				"4. Buscar usuario\r\n" + 
				"5. Matricular usuario\r\n" + 
				"6. Alumno en riesgo de abandono\r\n" + 
				"7. Guardar alumnos\r\n" + 
				"8. Salir";
		
		System.out.println(mensaje);
		if (teclado.hasNextInt()) {
			opcion = teclado.nextInt();
		}
		
		return opcion;
	} // Fin del elegir_opcion	
	
	public static int contar_lineas_fichero(String ruta) {
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
	} // fin contar_lineas_fichero
	
	public static int contar_columnas_fichero(String ruta) {
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
	} // fin contar_columnas_fichero
	
	// Saca una columna de la matriz SIN INCLUIR EL NOMBRE DE LA COLUMNA (Primera fila)
	public static String[] extraer_columna (String[][] datos, int indice_columna) {
		String[] columna = new String[datos.length-1];
		
		for (int i = 0; i< columna.length; i++) {
			columna[i] = datos[i+1][indice_columna];
		}
		
		return columna;
	} // fin extraer_columna
	

	
	
}