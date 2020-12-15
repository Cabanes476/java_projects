import java.util.Vector;

public class Linea {
	
	//Atributos
	
	private String id;
	private String estacionCabecera;
	private String color;
	private double longitud;
	
	private Vector<Estacion> estacion;
	private Vector<Metro> metro;
	private Vector<metroLigero> metroLigero;
	
	//Getters y Setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEstacionCabecera() {
		return estacionCabecera;
	}
	public void setEstacionCabecera(String estacionCabecera) {
		this.estacionCabecera = estacionCabecera;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	public void anadirEstacion(Estacion estacion) {
		this.estacion.add(estacion);
	}
	
	//Constructor
	
	public Linea(String id, String estacionCabecera, String color, double longitud, Estacion estacion,
			Metro metro) {
		this.id = id;
		this.estacionCabecera = estacionCabecera;
		this.color = color;
		this.longitud = longitud;
		this.estacion = new Vector<Estacion>();
		this.estacion.add(estacion);	//Suponiendo una estacion y un tren minimos
		this.metro = new Vector<Metro>();
		this.metro.add(metro);
	}
	
	public Linea(String id, String estacionCabecera, String color, double longitud, Estacion estacion,
		metroLigero metroLigero) {
		this.id = id;
		this.estacionCabecera = estacionCabecera;
		this.color = color;
		this.longitud = longitud;
		this.estacion.add(estacion);	//Suponiendo una estacion y un tren minimos
		this.metroLigero.add(metroLigero);

	}
	
	
}
