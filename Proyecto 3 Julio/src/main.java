import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*La actividad se debe realizar por parejas: Notificar en el hilo del foro creado a tal fin los miembros del equipo.

Cada equipo debe diseñar e implementar en Java, utilizando las técnicas aprendidas en clase, un sistema que:

Debe permintir manejar un stock de productos, con sus precios, caraterísticas, etc. Un atributo importante de producto es 
el código de producto, que como si del DNI de las personas se tratara permitirá identificar los productos de manera única.

El almacenamiento debe ser persistente (ficheros). Con las operaciones típicas de ficheros.

Debe haber log (fichero) con las operaciones realizadas.

Debe poderse dar de alta productos, actualizar stock, precios, disponibilidad, ver logs, ver listados, etc. Pensar que 
operaciones se necesitan para gestionar una tienda, diseñarlas e implementarlas. 

Debe ser tolerante a fallos y validar las peticiones para "no romperse".

Se debe crear una documentación explicativa con las decisiones de diseño, la validación, etc.
 */

//Andrés Ayala Llopis 

public class main {

	public static void main(String[] args) {
		
		String[][] datos_producto = {{"nombre_producto", "caracteristicas", "id_producto", "precio", "stock"}};
		String[][] datos_usuario = {{"nombre_persona", "dni", "numero_acceso"}};
		
		int opcion = 0;
		Scanner teclado = new Scanner(System.in);
		
		while (opcion !=11) {
			opcion = elegir_opcion();
			switch(opcion) {
			case 1: //Añadir Usuario
				//datos = añadir_usuario(datos);
				datos_usuario = lectura_datos_matriz_usuario("usuarios.csv");
				System.out.println("El archivo de ha cargado con éxito");
				System.out.println("");
				break;
			
			case 2: //Cargar Usuarios
				//datos = lectura_datos_matriz("usuarios.csv");
				datos_producto = lectura_datos_matriz_producto("productos.csv");
				System.out.println("El archivo de ha cargado con éxito");
				System.out.println("");
				break;
			
			case 3: //Buscar Usuario
				/*System.out.println("Introduzca el nombre del usuario: ");
				String nombre_persona = teclado.nextLine();
				if (existe_nombre_usuario(nombre_persona, extraer_columna(datos, 1))) {
					System.out.println(nombre_persona + " ¡¡Encontrado!!");
				}
				else { 
					System.out.println(nombre_persona + " ¡¡No encontrado!!");
				}*/
				csv_data_writter_usuarios("usuarios.csv", datos_usuario);
				System.out.println("El archivo de ha guardado con éxito");
				System.out.println("");
				break;
			
			case 4: //Añadir Producto
				//datos = añadir_producto(datos);
				csv_data_writter_productos("productos.csv", datos_producto);
				System.out.println("El archivo de ha guardado con éxito");
				System.out.println("");
				break;
			
			case 5: //Listar Productos
				//listar_datos_producto(datos);
				datos_usuario = añadir_usuario(datos_usuario);
				break;
			
			case 6: //Buscar Productos
				/*System.out.println("Introduzca el nombre del producto: ");
				String nombre_producto = teclado.nextLine();
				if (existe_nombre_producto(nombre_producto, extraer_columna(datos, 1))) {
					System.out.println(nombre_producto + " ¡¡Encontrado!!");
				}
				else {
					System.out.println(nombre_producto + " ¡¡No Encontrado!!");
				}*/
				datos_producto = añadir_producto(datos_producto);
				break;
			
			case 7: //Guardar CSV productos
				//Pendiente 
				listar_datos_usuario(datos_usuario);
				break;
			
			case 8: //Cargar CSV productos
				//datos = lectura_datos_matriz("productos.csv");
				listar_datos_producto(datos_producto);
				break;
			case 9:
				System.out.println("Introduzca el nombre de la persona: ");
				Scanner nombre = new Scanner(System.in);
				String nombre_persona = nombre.nextLine();
				if (existe_nombre_usuario(nombre_persona, extraer_columna_usuarios(datos_usuario, 0))) {
					System.out.println(nombre_persona + " ¡¡Encontrado!!");
					System.out.println("");
				}
				else {
					System.out.println(" ¡¡No Encontrado!!");
					System.out.println("");
				}
				break;
			case 10:
				System.out.println("Introduzca el nombre del producto: ");
				Scanner producto = new Scanner(System.in);
				String nombre_producto = producto.nextLine();
				if (existe_nombre_producto(nombre_producto, extraer_columna_productos(datos_producto, 0))) {
					System.out.println(nombre_producto + " ¡¡Encontrado!!");
					System.out.println("");
				}
				else {
					System.out.println(" ¡¡No Encontrado!!");
					System.out.println("");
				}
				break;
			case 11:
				System.out.println("Andrés Ayala Copyright®");
				System.out.println("-----------------------");
				System.out.println("");
				System.out.println("Información del Alumno:");
				System.out.println("");
				System.out.println("Nº Expediente 21821611");
				System.out.println("Fecha de finalización del proyecto 23/06/2019");
				System.out.println("Recuperación Proyecto III Programación I");
				System.out.println("Universidad Europea de Madrid");
				System.out.println("1º Curso Ingeniería Informática");
				System.out.println("");
				break;
				
			
			default:
				System.out.println("¡¡Opción Inválida!!");
				break;
			} // switch final
		} //while final
	} //main final
	
	public static String[][] añadir_usuario(String[][] datos_usuario) {
		
		String nombre_persona;
		String dni;
		String numero_acceso;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca su nombre: ");
		nombre_persona = teclado.nextLine();
		System.out.println("Introduzca su DNI: ");
		dni = teclado.nextLine();
		System.out.println("Introduzca su número de acceso: ");
		numero_acceso = teclado.nextLine();
		
		datos_usuario = matriz_datos_usuarios(nombre_persona, dni, numero_acceso, datos_usuario);
		return datos_usuario;
		
		} //Añadir usuario FINAL
	
	public static String[][] añadir_producto(String[][] datos_producto) {
		
		String nombre_producto;
		String caracteristicas;
		String id_producto;
		String precio;
		String stock;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca el nombre del producto: ");
		nombre_producto = teclado.nextLine();
		System.out.println("Introduzca las características del producto: ");
		caracteristicas = teclado.nextLine();
		System.out.println("Introduzca el código de identificación del producto: ");
		id_producto = teclado.nextLine();
		System.out.println("Introduzca el precio del producto: ");
		precio = teclado.nextLine();
		System.out.println("Introduzca el número de stock del producto: ");
		stock = teclado.nextLine();
		
		datos_producto = matriz_datos_productos(nombre_producto, caracteristicas, id_producto, precio, stock, datos_producto);
		return datos_producto;
	} //Añadir producto FINAL
	
	public static String[][] matriz_datos_usuarios(
		
		String nombre_persona,
		String dni,
		String numero_acceso,
		String[][] datos_usuario) {
		
		String[][] resultado_usuarios = new String[datos_usuario.length+1][3];
		
		for(int i=0; i<datos_usuario.length; i++) {
			resultado_usuarios[i] = datos_usuario[i];
		}
		
		resultado_usuarios[resultado_usuarios.length-1][0] = nombre_persona;
		resultado_usuarios[resultado_usuarios.length-1][1] = dni;
		resultado_usuarios[resultado_usuarios.length-1][2] = numero_acceso;
		
		System.out.println("resultado.length " + resultado_usuarios.length);
		return resultado_usuarios;
	}
	
	public static String[][] matriz_datos_productos(
			
		String nombre_producto,
		String caracteristicas,
		String id_producto,
		String precio,
		String stock,
		String[][] datos_producto) {
		
		String[][] resultado_productos = new String[datos_producto.length+1][5];
		
		for (int i=0; i<datos_producto.length; i++) {
			resultado_productos[i] = datos_producto[i];
		}
		
		resultado_productos[resultado_productos.length-1][0] = nombre_producto;
	    resultado_productos[resultado_productos.length-1][1] = caracteristicas;
		resultado_productos[resultado_productos.length-1][2] = id_producto;
		resultado_productos[resultado_productos.length-1][3] = precio;
		resultado_productos[resultado_productos.length-1][4] = stock;
		
		System.out.println("resultado.length " + resultado_productos.length);
		return resultado_productos;
	}
	
	public static void listar_datos_usuario(String[][] datos_usuario) {
		for (int i=1; i<datos_usuario.length; i++) {
			String usuario = 
					
					datos_usuario[0][0] +  ": " + datos_usuario[i][0] + "\n" + //nombre_persona
					datos_usuario[0][1] +  ": " + datos_usuario[i][1] + "\n" + //dni
					datos_usuario[0][2] +  ": " + datos_usuario[i][2] + "\n" + //numero_acceso
					"---------------------------------------------------------";
			System.out.println(usuario);
			
			}
	} //Listar datos usuario FINAL
	
	public static void  listar_datos_producto(String[][] datos_producto) {
		for (int i=1; i<datos_producto.length; i++) {
			
			String producto = 
					
					datos_producto[0][0] +  ": " + datos_producto[i][0] + "\n" + //nombre_producto
					datos_producto[0][1] +  ": " + datos_producto[i][1] + "\n" + //caracteristicas
					datos_producto[0][2] +  ": " + datos_producto[i][2] + "\n" + //id_producto
					datos_producto[0][3] +  ": " + datos_producto[i][3] + "\n" + //precio
					datos_producto[0][4] +  ": " + datos_producto[i][4] + "\n" + //stock
					"-----------------------------------------------------------";
			System.out.println(producto);
			}
	}
		
	public static boolean existe_nombre_usuario(String nombre_persona, String[] nombres_personas) {
		
		boolean encontrado = false;
		int i = 0;
		
		while(!encontrado && i<nombres_personas.length) {
			System.out.println(nombres_personas[i] + ", " + nombre_persona);
			if(nombres_personas[i].equals(nombre_persona)) {
				encontrado = true;
			} i++;
		} return encontrado;
	} //existe_nombre_usuario FINAL
	
public static boolean existe_nombre_producto(String nombre_producto, String[] nombres_productos) {
		
		boolean encontrado = false;
		int i = 0;
		
		while(!encontrado && i<nombres_productos.length) {
			System.out.println(nombres_productos[i] + ", " + nombre_producto);
			if(nombres_productos[i].equals(nombre_producto)) {
				encontrado = true;
			} i++;
		} return encontrado;
	} //existe_nombre_usuario FINAL
	
	public static void buscar_persona(String persona, String[][] datos) {
        //Completar
	}
	
	public static int elegir_opcion() {
		Scanner teclado = new Scanner(System.in);
		int opcion = 0;
		String mensaje = 
				"---Bienvenido al sistema de Stock 2.0---\r\n" +
				"Indique la operación que desee realizar:\r\n" +
				"1. Cargar 'usuarios.csv'\r\n" +
				"2. Cargar 'productos.csv'\r\n" +
				"3. Guardar 'usuarios.csv'\r\n" +
				"4. Guardar 'productos.csv'\r\n" +
				"5. Añadir Usuarios\r\n" +
				"6. Añadir Productos\r\n" +
				"7. Listar Usuarios\r\n" +
				"8. Listar Productos\r\n" +
				"9. Buscar Usuarios\r\n" +
				"10. Buscar Productos\r\n" +
				"11. Información del Proyecto\r\n";
		
		System.out.println(mensaje);
		if (teclado.hasNextInt()) {
			opcion = teclado.nextInt();
			} return opcion;
		}
	
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
		} columnas = primeraLinea.split(";").length; return columnas;
	} //contar columnas FINAL
	
	public static String[] extraer_columna_usuarios (String[][] datos_usuarios, int indice_columna) {
		
		String[] columna = new String[datos_usuarios.length-1];
		
		for (int i = 0; i< columna.length; i++) {
			columna[i] = datos_usuarios[i+1][indice_columna];
		} return columna;
	} // Extraer columna FINAL
	
public static String[] extraer_columna_productos (String[][] datos_productos, int indice_columna) {
		
		String[] columna = new String[datos_productos.length-1];
		
		for (int i = 0; i< columna.length; i++) {
			columna[i] = datos_productos[i+1][indice_columna];
		} return columna;
	} // Extraer columna FINAL
	
	public static String[][] lectura_datos_matriz_usuario(String ruta) {
		
		String[][] datos_usuario;
		String linea;
		int fila = 0;
		
		int filas = contar_lineas(ruta);
		int columnas = contar_columnas(ruta);
		
		datos_usuario = new String[filas][columnas];
		
		try {
			Scanner fichero = new Scanner(new File(ruta));
			while (fichero.hasNextLine()) {
				linea = fichero.nextLine();
				datos_usuario[fila] = linea.split(";");
				fila++;
			} fichero.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha habido un error leyendo los datos de " + ruta);
		} return datos_usuario;
	} // Lectura datos matriz FINAL
	
public static String[][] lectura_datos_matriz_producto(String ruta) {
		
		String[][] datos_producto;
		String linea;
		int fila = 0;
		
		int filas = contar_lineas(ruta);
		int columnas = contar_columnas(ruta);
		
		datos_producto = new String[filas][columnas];
		
		try {
			Scanner fichero = new Scanner(new File(ruta));
			while (fichero.hasNextLine()) {
				linea = fichero.nextLine();
				datos_producto[fila] = linea.split(";");
				fila++;
			} fichero.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha habido un error leyendo los datos de " + ruta);
		} return datos_producto;
	} // Lectura datos matriz FINAL
	
	public static void csv_data_writter_usuarios(String ruta, String[][] datos_usuario) {
        FileWriter fichero;
        try {
                        fichero = new FileWriter(ruta);
                        for(int i=0; i<datos_usuario.length; i++){
                                        for(int j=0; j<datos_usuario[0].length; j++) {
                                                        fichero.write("" + datos_usuario[i][j]);
                                                        if(j !=(datos_usuario[0].length-1)) {
                                                                       fichero.write(";");
                                                        }
                                                       
                                                      
                                        }fichero .write("\n");
                        }fichero.close();
        }catch(IOException e) {
                        System.out.println("Error de escritura en el fichero: " + e.getMessage());
                        e.printStackTrace();
        }
	
	}
	
	public static void csv_data_writter_productos(String ruta, String[][] datos_producto) {
        FileWriter fichero;
        try {
                        fichero = new FileWriter(ruta);
                        for(int i=0; i<datos_producto.length; i++){
                                        for(int j=0; j<datos_producto[0].length; j++) {
                                                        fichero.write("" + datos_producto[i][j]);
                                                        if(j !=(datos_producto[0].length-1)) {
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

//Logs


	
	
		
	


	
	
	


