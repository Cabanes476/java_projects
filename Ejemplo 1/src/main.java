
public class main {
	
	class Punto {
		
		int coordenadaX;
		int coordenadaY;
		
		void setX(int x) {coordenada = x; }
		void setY(int y) {coordenada = y; }
		
		int getX() {return coordenadaX;}
		int getY() {return coordenadaY;}
		
		}
	
	class Ejemplo2{
		public static void main ( String[] args) {
			Punto p;
			p = new Punto();
			p.setX(1);
			p.setY(2);
			System.out.println("p1: (" + p.getX() + ","+ p.getY() + ")");
		}
	}

}
