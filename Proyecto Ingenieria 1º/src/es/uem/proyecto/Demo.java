package es.uem.proyecto;

import java.awt.Color;
import java.text.DecimalFormat;

import javax.swing.SwingUtilities;

import es.uem.proyecto.plotting.ContinuousFunctionPlotter;
import es.uem.proyecto.plotting.Graph;
import es.uem.proyecto.plotting.PlotSettings;
import es.uem.proyecto.plotting.ScatterPlotter;
import es.uem.proyecto.swing.GraphApplication;


public class Demo {

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new GraphApplication(getExampleGraph());
			}
		});

	}

    public static Graph getExampleGraph() {
    	
    	PlotSettings p = new PlotSettings(0, 100, -2.0, 10.0);
    	p.setAxisColor(Color.RED);
    	p.setTitle("Potencial de membrana (mV) frente al tiempo (ms)");
    	p.setGridSpacingX(5.0);
    	p.setGridSpacingY(1.00);
    	p.setNumberFormatterX(new DecimalFormat("0"));
    	p.setNumberFormatterY(new DecimalFormat("0.0"));
    	Graph graph = new Graph(p);
    	
    	double x[] = {  1.0,  13.0,  22.0,  28.0,  43.0,  50.8,  62.0,  71.0,  84.0,  91.0, 99.0};
    	double y[] = {-1.5,  -0.45,  9.1, 8.1,  6.3,  5.2,  4.5,  4.0,  3.8,  3.6,  3.5};
    	graph.functions.add(new ScatterPlotter(x, y) {
    		public String getName() {
    			return "Potencial de membrana";
    		}
    	});
    	
        graph.functions.add(new ContinuousFunctionPlotter(){
            public double getY(double x) {
                return 20 - 17 / (1 + Math.exp(-0.035*x));
            }
            public String getName() {
                return "Función sigmoidea";
            }
        });
        
    	return graph;
    }
    
}
