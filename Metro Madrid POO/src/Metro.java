import java.util.Vector;

public class Metro extends Tren {
	
	//Atributos
	
	private final int NUM_MAQUINAS = 2;
	

	private int id;
	private Vector<Vagon> vagones;
	private Maquina[] maquina;
	private String matriculaM1;	//Matricula de la maquina 1
	private String matriculaM2;	//Matricula de la maquina 2
	
	//Getters y setters
	
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Vector<Vagon> getVagones() {
			return vagones;
		}

		public void setVagones(Vector<Vagon> vagones) {
			this.vagones = vagones;
		}

		public String getMatriculaM1() {
			return matriculaM1;
		}

		public void setMatriculaM1(String matriculaM1) {
			this.matriculaM1 = matriculaM1;
		}

		public String getMatriculaM2() {
			return matriculaM2;
		}

		public void setMatriculaM2(String matriculaM2) {
			this.matriculaM2 = matriculaM2;
		}
		
		public void anadirVagon(Vagon vagon) {
			this.vagones.add(vagon);
		}

		public int getNUM_MAQUINAS() {
			return NUM_MAQUINAS;
		}
		
		public int getNumVagones() {
			return this.vagones.size();
		}
	
	//Constructor
		
	public Metro(String idTren, int id, String matriculaM1, String matriculaM2, Vagon vagon) {
		super(idTren);
		
		maquina = new Maquina[NUM_MAQUINAS];	//Creacion de arrays de maquinas
		this.setMatriculaM1(matriculaM1);			//Dar matricula a cada maquina
		this.setMatriculaM2(matriculaM2);
		this.maquina[0] = new Maquina(matriculaM1);	//Crear maquinas
		this.maquina[1] = new Maquina(matriculaM2);
		this.vagones = new Vector<Vagon>();
		this.vagones.add(vagon);					//Añadir vagon
		this.id = id;
	}
}
