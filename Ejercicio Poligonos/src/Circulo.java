
public class Circulo extends Figuras{
	
	float radio;

	@Override
	public double perimetro() {
		double perimetro = 2*Math.PI*radio;
		return perimetro;
	}
	
	@Override
	public double area() {
		double area = Math.PI*radio*radio;
		return area;
	}
}
