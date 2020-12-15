
public class metroLigero extends Tren {
	//Atributo
	private int id;
	private static int NUM_MAQUINAS = 2;
	private static int NUM_VAGONES = 3;
	private Vagon[] vagon;
	private Maquina[] maquina;
	
	//Getter y setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getNUM_MAQUINAS() {
		return NUM_MAQUINAS;
	}

	public static void setNUM_MAQUINAS(int nUM_MAQUINAS) {
		NUM_MAQUINAS = nUM_MAQUINAS;
	}

	public static int getNUM_VAGONES() {
		return NUM_VAGONES;
	}

	public static void setNUM_VAGONES(int nUM_VAGONES) {
		NUM_VAGONES = nUM_VAGONES;
	}

	public Vagon[] getVagon() {
		return vagon;
	}

	public void setVagon(Vagon[] vagone) {
		this.vagon = vagone;
	}

	public Maquina[] getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina[] maquina) {
		this.maquina = maquina;
	}
	
	
	//Constructor
	
	public metroLigero(String idTren, int id, String matriculaM1, String matriculaM2, String matriculaV1, String matriculaV2, String matriculaV3, boolean modelo2000) {
		super(idTren);
		
		maquina = new Maquina[NUM_MAQUINAS - 1];	//Array de dos maquinas
		this.maquina[0] = new Maquina(matriculaM1);	//Crear maquinas con matriculas asignadas
		this.maquina[1] = new Maquina(matriculaM2);
		
		vagon = new Vagon[NUM_VAGONES - 1];			//Array con 3 vagones
		this.vagon[0] = new Vagon(matriculaV1, modelo2000); //Creacion de los vagones
		this.vagon[1] = new Vagon(matriculaV2, modelo2000);
		this.vagon[2] = new Vagon(matriculaV3, modelo2000);
		
		this.id = id;
	}	
}
