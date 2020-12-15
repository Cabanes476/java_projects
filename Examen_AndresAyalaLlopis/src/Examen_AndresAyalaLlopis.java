import java.util.Scanner;

public class Examen_AndresAyalaLlopis {

	
	//Main con menu de eleccion de ejecucion de ejercicios
	public static int elegir_opcion () {
		Scanner teclado = new Scanner(System.in);
		int opcion = 0;
		String mensaje = 
				"--- Exámen Final Programacion I ---\r\n" + 
		        ""+
				"Ejercicio que desee ejecutar: \r\n" + 
				"1. Ejercicio_1\r\n" +  
				"2. Ejercicio_2\r\n" + 
				"3. Salir\r\n";
		
		System.out.println(mensaje);
		if (teclado.hasNextInt()) {
			opcion = teclado.nextInt();
		}
		
		return opcion;
	} 
	
	//Estructura de funcion del menu
	public static void main(String[] args) {
		
		int opcion = 0;
		Scanner teclado = new Scanner(System.in);
		while (opcion != 3) { 
			
			opcion = elegir_opcion ();
			switch(opcion) {
				case 1: 
					calcular_caracteristicas_matriz();
					break;
				case 2: 
					solicitar_y_validar_usuario();
					break;
				case 3: 
					System.out.println("Ha elegido Salir");
					break;
				default:
					System.out.println("Opcion Incorrecta");
					break;
	      }
		}
	  }
	
	/*public static void solicitar_y_validar_usuario() {
		
		System.out.println("Introduzca su nombre de usuario: ");
		Scanner teclado = new Scanner(System.in);
		String user = teclado.nextLine();
		
		
		System.out.println("Usuario Incorrecto (4 intentos restantes)");
		
	}*/
	
	//ejercicio 1 que no me ha dado tiempo a completar pero se implementa igualmente para un main completo
    public static void calcular_caracteristicas_matriz() {
    	
    }
	
	//Ejercicio 2
	public static void solicitar_y_validar_usuario() {
		
		System.out.println("Introduzca su nombre de usuario: ");
		
		Scanner teclado = new Scanner(System.in);
		String user = teclado.nextLine();
		//Podria haberse hecho por bucles pero no me ha dado tiempo a completarlo
		//El modelo if consiste en una ramificacion de las acciones
		if (user !="admin") {
			
			System.out.println("Usuario Incorrecto (4 intentos restantes)");
			String user2 = teclado.nextLine();
			
			if(user !="admin") {
				System.out.println("Usuario Incorrecto (3 intentos restantes)");
				String user3 = teclado.nextLine();
				
				if(user !="admin") {
					System.out.println("Usuario Incorrecto (2 intentos restantes)");
					String user4 = teclado.nextLine();
					
					if(user !="admin") {
						System.out.println("Usuario Incorrecto (1 intentos restantes)");
						String user5 = teclado.nextLine();
						
						if(user !="admin") {
							System.out.println("Usuario Incorrecto (0 intentos restantes)");
							System.out.println("Ha sido Bloqueado");
							
						}else {
							
							String pass = teclado.nextLine();
							if(pass !="1234") {
								System.out.println("Contraseña Incorrecta (4 intentos restantes)");
								String pass2 = teclado.nextLine();
								if(pass !="1234") {
									System.out.println("Contraseña Incorrecta (3 intentos restantes)");
									String pass3 = teclado.nextLine();
									
									if(pass !="1234") {
										System.out.println("Contraseña Incorrecta (2 intentos restantes)");
										String pass4 = teclado.nextLine();
										
										if(pass !="1234") {
											System.out.println("Contraseña Incorrecta (1 intentos restantes)");
											String pass5 = teclado.nextLine();
											
											if(pass !="1234") {
												System.out.println("Contraseña Incorrecta (0 intentos restantes)");
												System.out.println("Ha sido Bloqueado");
							}
							
							else {
								System.out.println("Bienvenido Admin");
							}
											
							
						}
					} else {
						
					}
				}	else {
					
				}
			}	else {
				
			}
		}
					}
						else {
							
						}
			
		}
	} 	
}
	}
}
