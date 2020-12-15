package Controlador;

import java.awt.Color;
import java.text.DecimalFormat;

import javax.swing.SwingUtilities;

import Objetos.Intensidad;
import Objetos.Neurona;
import Objetos.Tiempo;
import es.uem.proyecto.plotting.ContinuousFunctionPlotter;
import es.uem.proyecto.plotting.Graph;
import es.uem.proyecto.plotting.PlotSettings;
import es.uem.proyecto.plotting.ScatterPlotter;
import es.uem.proyecto.swing.GraphApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControladorOpciones {

    @FXML
    private TextField tResistencia;

    @FXML
    private TextField tDuracion;

    @FXML
    private TextField tFinalEstimulo;

    @FXML
    private TextField tPotencialReposo;

    @FXML
    private TextField tVoltPico;

    @FXML
    private TextField tResolucionTemp;

    @FXML
    private TextField tVoltReset;

    @FXML
    private TextField tConstTiempo;

    @FXML
    private TextField tPotencialUmbral;

    @FXML
    private TextField tComienzoEstimulo;

    @FXML
    private TextField tIntensidad;
    
    @FXML
    private Button bGenerar;
    
    @FXML
    private Button bLimpiar;

    @FXML
    private Button bPredet;
   
    
    //Metodos
    public Neurona crearNeurona() {
   	
    	double res = Double.parseDouble(tResistencia.getText());
    	double tau = Double.parseDouble(tConstTiempo.getText());
    	double potencialRep = Double.parseDouble(tPotencialReposo.getText());
    	double vReset = Double.parseDouble(tVoltReset.getText());
    	double vPico = Double.parseDouble(tVoltPico.getText());
    	double potencialUmbral = Double.parseDouble(tPotencialUmbral.getText());
    	
    	Neurona neurona = new Neurona(res, tau, potencialRep, potencialUmbral, vReset, vPico);
		return neurona;
    	
    	
    }
    
    public Tiempo crearTiempo() {
    	double duracion = Double.parseDouble(tDuracion.getText());
    	double inicio = Double.parseDouble(tComienzoEstimulo.getText());
    	double fin = Double.parseDouble(tFinalEstimulo.getText());
    	double resTemp = Double.parseDouble(tResolucionTemp.getText());
    	
    	Tiempo tiempo = new Tiempo(duracion, inicio, fin, resTemp);
    	return tiempo;
    }
    
    
    public Intensidad crearIntensidad() {
    	double intPulso = Double.parseDouble(tIntensidad.getText());
    	
    	Intensidad intensidad = new Intensidad(intPulso);
    	return intensidad;
    }
    
    public void crearGraf() {
    	Neurona neurona = crearNeurona();
    	Tiempo tiempo = crearTiempo();
    	Intensidad intensidad = crearIntensidad();
    	
    	
    			
    }
    
    public double[] estimulo(Tiempo tiempo, Intensidad intensidad){
    	int dim = (int) (Double.parseDouble(tDuracion.getText()) / Double.parseDouble(tResolucionTemp.getText()));
		double[] intensidadEstimulo = new double [dim];
		double tiempoEstimulo = 0;
		
		for (int i = 0; i < intensidadEstimulo.length; i++) {
			if(tiempoEstimulo < tiempo.gettIniEstim() || tiempoEstimulo > tiempo.gettFinEstim()) {
				intensidadEstimulo[i] = 0;
			} else {
				intensidadEstimulo[i] = intensidad.getIntPulso();
			}
			tiempoEstimulo = tiempoEstimulo + tiempo.getDt();
		}
		return intensidadEstimulo;
	}
    
    public static double[] intFire(double[] intensidad, Neurona neu, Tiempo tiempo){
		double [] potencial= new double [intensidad.length];
		double V = neu.getVrep();
 
		for(int i=0; i<potencial.length; i++) {
			V = neu.getVrep() + neu.getR() * intensidad[i] + (V - neu.getVrep() - neu.getR() * intensidad[i]) * Math.exp(-tiempo.getDt() / neu.getTau());
			if (V < neu.getVth()) {
				potencial[i] = V;
			} else {
				potencial[i] = neu.getVspike();
				V = neu.getVreset();
			}
		}
		return potencial;
	}
    
    public Graph getExampleGraph1() {

    	Tiempo tiempo = crearTiempo();
    	Intensidad intensidad = crearIntensidad();
		// Ajustes generales del grafico
		PlotSettings p = new PlotSettings(0, tiempo.gettFinSimul(), -intensidad.getIntPulso() * 0.1, intensidad.getIntPulso() * 1.1);
		p.setAxisColor(Color.RED);
		p.setTitle("Intensidad del estimulo de corriente (nA) inyectada en la neurona frente al tiempo (ms)");
		p.setGridSpacingX(50);
		p.setGridSpacingY(0.2);
		p.setNumberFormatterX(new DecimalFormat("0"));
		p.setNumberFormatterY(new DecimalFormat("0.0"));
		Graph graph = new Graph(p);
		
		double[] tiempoEstimulo = generaTiempo(tiempo);
		double[] intensidadEstimulo = estimulo(tiempo, intensidad);

		// puntos (x, y) para el ScatterPlotter 
		graph.functions.add(new ScatterPlotter(tiempoEstimulo, intensidadEstimulo) {
			public String getName() {
				return "Potencial de membrana";
			}
		});

		return graph;
	}
    
    public Graph getExampleGraph2() {

    	Neurona neu = crearNeurona();
    	Tiempo tiempo = crearTiempo();
    	Intensidad intensidad = crearIntensidad();
    	
    	
		PlotSettings p = new PlotSettings(0, tiempo.gettFinSimul(), neu.getVreset() * 1.1, neu.getVspike() * 1.1);
		p.setAxisColor(Color.RED);
		p.setTitle("Potencial de menbrana (mV) de la neurona frente al tiempo (ms)");
		p.setGridSpacingX(50.0);
		p.setGridSpacingY(10);
		p.setNumberFormatterX(new DecimalFormat("0"));
		p.setNumberFormatterY(new DecimalFormat("0"));
		Graph graph = new Graph(p);
		

		double xreposo[] = {50, 100, 150, 200, 250, 300, 350, 400, 450};
		double yreposo[] = {-70, -70, -70, -70, -70, -70, -70, -70, -70};
		
		graph.functions.add(new ScatterPlotter(xreposo, yreposo) {
    		public String getName() {
    			return "Línea Reposo";
    		}
    	});
		
		double xreset[] = {50, 100, 150, 200, 250, 300, 350, 400, 450};
		double yreset[] = {-75, -75, -75, -75, -75, -75, -75, -75, -75};
		
		graph.functions.add(new ScatterPlotter(xreset, yreset) {
    		public String getName() {
    			return "Línea Reset";
    		}
    	});

		double[] tiempoEstimulo = generaTiempo(tiempo);
		double[] intensidadEstimulo = estimulo(tiempo, intensidad);
		double[] potencial = intFire(intensidadEstimulo, neu, tiempo);
		
		// puntos (x, y) para el ScatterPlotter 

		graph.functions.add(new ScatterPlotter(tiempoEstimulo, potencial) {
			public String getName() {
				return "Potencial de membrana";
			}
		});
		
		graph.functions.add(new ContinuousFunctionPlotter(){
            public double getY(double x) {
            	return neu.getVth();
            }
            public String getName() {
                return "Funcion sigmoidea";
            }
        });
		
		graph.functions.add(new ContinuousFunctionPlotter(){
            public double getY(double x) {
            	return -70;
            }
            public String getName() {
                return "Línea reposo";
            }
        });
		
		graph.functions.add(new ContinuousFunctionPlotter(){
            public double getY(double x) {
            	return -75;
            }
            public String getName() {
                return "Línea reset";
            }
        });


		return graph;
	} 
    
    public double[] generaTiempo(Tiempo tiempo){
    	int dim = (int) (Double.parseDouble(tDuracion.getText()) / Double.parseDouble(tResolucionTemp.getText()));
		double[] tiempoEstimulo= new double [dim];
		tiempoEstimulo[0] = 0;
		
		for (int i=1; i<tiempoEstimulo.length;i++ ) {
			tiempoEstimulo[i] = tiempoEstimulo[i-1] + tiempo.getDt();
		}
		return tiempoEstimulo;
	}
    
    public void generarGraficas() {
    	SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new GraphApplication(getExampleGraph1());
				new GraphApplication(getExampleGraph2());
			}
		});
    }
    
    public void limpiar() {
    	
    	tComienzoEstimulo.setText("");
    	tConstTiempo.setText("");
    	tDuracion.setText("");
    	tFinalEstimulo.setText("");
    	tIntensidad.setText("");
    	tPotencialReposo.setText("");
    	tPotencialUmbral.setText("");
    	tResistencia.setText("");
    	tResolucionTemp.setText("");
    	tVoltPico.setText("");
    	tVoltReset.setText("");
    	
    }
    
    public void def() {
    	
    	tComienzoEstimulo.setText("100");
    	tConstTiempo.setText("2");
    	tDuracion.setText("500");
    	tFinalEstimulo.setText("400");
    	tIntensidad.setText("1.55");
    	tPotencialReposo.setText("-70");
    	tPotencialUmbral.setText("-55");
    	tResistencia.setText("5");
    	tResolucionTemp.setText("0.1");
    	tVoltPico.setText("30");
    	tVoltReset.setText("-75");
    	
    }
    
}
