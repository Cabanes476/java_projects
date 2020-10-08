import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GestionAlumnosAndresAyalaLlopis {

	public static void main(String[] args) {
		String[][] datos = {{"Apellidos","Nombre","Expediente","último acceso"}};
		int opcion =0;
		Scanner teclado = new Scanner(System.in);
		
		while(opcion !=9) {
			
			opcion = elegir_opcion();
			
			switch(opcion) {
			
			case 1: //cargar csv
				datos = lectura_datos_matriz("alumnosM12.csv");
				break;
			
			case 2: //guardar csv
				escritura_datos_csv("alumnosM12.csv", datos);
				System.out.println("El archivo de ha guardado con éxito");
				System.out.println("");
				break;
				
			case 3: //mastricular usuario
				datos = solicitar_matricular_usuario(datos);
				break;
				
			case 4: //listar alumnos
				listar_datos(datos);
				break;
				
			case 5: //Buscar nombre
				System.out.print("Introduzca nombre para buscar: ");
				String nombre = teclado.nextLine();
				if (existe_nombre(nombre, extraer_columna(datos, 1)) ) {
					System.out.println("El nombre " + nombre + " ha sido encontrado!!");
				}
				else {
					System.out.println("El nombre " + nombre + " no ha sido encontrado...");
				}
				break;
				
			case 6: //Buscar expediente
				System.out.print("Introduzca numero de expediente para buscar: ");
				String expediente = teclado.nextLine();
				if (existe_nombre(expediente, extraer_columna(datos, 2)) ) {
					System.out.println("El nombre " + expediente + " ha sido encontrado!!");
				}
				else {
					System.out.println("El nombre " + expediente + " no ha sido encontrado...");
				}
				break;
				
			case 7: //Riesgo de abandono
				System.out.print("Introduzca el periodo de búsqueda en dias: ");
				int dias = teclado.nextInt(); teclado.nextLine();
				alumno_riesgo_abandono(dias, datos);
				break;
				
			case 8: //creditos
				System.out.println("Andrés Ayala Copyright®");
				System.out.println("-----------------------");
				System.out.println("");
				System.out.println("Información del Alumno:");
				System.out.println("");
				System.out.println("Nº Expediente 21821611");
				System.out.println("Fecha de finalización del proyecto 14/01/2020");
				System.out.println("Proyecto II Programación I");
				System.out.println("Universidad Europea de Madrid");
				System.out.println("1º Curso Ingeniería Informática");
				System.out.println("");
				break;
				
			case 9: //salir
				System.out.println("¡¡Adiós!!");
				break;
				
			default:
				System.out.println("¡¡Opción Inválida!!");
				break;
				
			} //termina switch
			
		} //termina while

	} //termina main
	
	public static String[][] lectura_datos_matriz(String ruta) {
		String[][] datos = null;
		String linea;
		int fila = 0;
		
		int filas	= contar_lineas_fichero(ruta);
		int columnas= contar_columnas_fichero(ruta);
		
		datos = new String[filas][columnas];
		
		try {
			Scanner fichero = new Scanner(new File(ruta));
			while (fichero.hasNextLine()) {
				linea = fichero.nextLine();
				datos[fila] = linea.split(";");
				fila++;
			}fichero.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha habido un error accediendo a: " + ruta);
		} return datos;
	}
	
	public static int contar_lineas_fichero(String ruta) {
		int lineas = 0;
		
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
	
	public static int contar_columnas_fichero(String ruta) {
		int columnas = 0;
		String primeraLinea="";
		
		try {
			Scanner fichero = new Scanner(new File(ruta));
			if (fichero.hasNextLine()) {
				primeraLinea = fichero.nextLine();
			}
			fichero.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha habido un error contando las columnas de " + ruta);
		}
		
		columnas = primeraLinea.split(";").length;
		
		return columnas;
	} 
	

	public static String[] extraer_columna (String[][] datos, int indice_columna) {
		String[] columna = new String[datos.length-1];
		
		for (int i = 0; i< columna.length; i++) {
			columna[i] = datos[i+1][indice_columna];
		}
		
		return columna;
	} 
	
	public static int elegir_opcion () {
		Scanner teclado = new Scanner(System.in);
		int opcion = 0;
		String mensaje = 
				"--- Gestor de Alumnos 1.0 ---\r\n" + 
				"¿Que opcion desea realizar?\r\n" + 
				"1. Cargar CSV\r\n" +  
				"2. Guardar CSV\r\n" + 
				"3. Matricular Usuario\r\n" + 
				"4. Listar Alumnos\r\n" + 
				"5. Buscar Nombre\r\n" + 
				"6. Buscar Expediente\r\n" + 
				"7. Riesgo de Abandono\r\n" + 
				"8. Créditos\r\n"+
				"9. Salir del programa";
		
		System.out.println(mensaje);
		if (teclado.hasNextInt()) {
			opcion = teclado.nextInt();
		}
		
		return opcion;
	} 
	
	public static void listar_datos(String[][] datos) {
		for (int i=1; i<datos.length; i++) {
			String alumno =
					datos[0][1] + ": " + datos[i][1] + "\n" + 
					datos[0][0] + ": " + datos[i][0] + "\n" + 
					datos[0][2] + ": " + datos[i][2] + "\n" + 
					datos[0][3] + ": " + datos[i][3] + "\n" + 
					"-----------------------------------";
			System.out.println(alumno);
		}
		
	}
	
	public static String[][] solicitar_matricular_usuario(String[][] datos) {
		String nombre;
		String apellidos;
		String expediente;
		String fecha;
		
		Date ahora = new Date();	
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

	public static boolean existe_nombre(String nombre, String[] nombres) {
		boolean encontrado = false;
		int i = 0;
		
		while(!encontrado && i<nombres.length) {
			if (nombres[i].equals(nombre)) {
				encontrado = true;
			}
			i++;
		}
		return encontrado;
	}
	
	public static String[][] matricular_usuario(
			
			String nombre,
			String apellidos,
			String expediente,
			String fecha,
			String[][] datos) {
		
		String[][] resultado = new String[datos.length+1][4];
		
		for (int i=0; i<datos.length; i++) {
			resultado[i] = datos[i];
		}
		
		resultado[resultado.length-1][0] = apellidos;
		resultado[resultado.length-1][1] = nombre;
		resultado[resultado.length-1][2] = expediente;
		resultado[resultado.length-1][3] = fecha;
		
		System.out.println("resultado.length " + resultado.length);
		
		return resultado;
	}
	
	public static void alumno_riesgo_abandono(int dias, String[][] datos) {		
		Date ahora = new Date();
		for (int i=1; i<datos.length; i++) {
			try {
				Date acceso =new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(datos[i][3]);
				long dias_acceso = (ahora.getTime() - acceso.getTime())/1000/60/60/24;
				
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
	}
	
	public static void escritura_datos_csv(String ruta, String[][] datos) {
		
		FileWriter fichero;
        try {
                        fichero = new FileWriter(ruta);
                        for(int i=0; i<datos.length; i++){
                                        for(int j=0; j<datos[0].length; j++) {
                                                        fichero.write("" + datos[i][j]);
                                                        if(j !=(datos[0].length-1)) {
                                                                       fichero.write(";");
                                                        }
                                                       
                                                      
                                        }fichero .write("\n");
                        }fichero.close();
        }catch(IOException e) {
                        System.out.println("Error de escritura en el fichero: " + e.getMessage());
                        e.printStackTrace();
        }

	}

}
