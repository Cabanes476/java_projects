package es.uem.proyecto;

import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.SwingUtilities;
import es.uem.proyecto.plotting.ContinuousFunctionPlotter;
import es.uem.proyecto.plotting.Graph;
import es.uem.proyecto.plotting.PlotSettings;
import es.uem.proyecto.plotting.ScatterPlotter;
import es.uem.proyecto.swing.GraphApplication;

/**
 * Aplicacion de ejemplo para mostrar graficos de dispersion y de funciones continuas.
 *
 * <p>
 * Adaptado desde la biblioteca <b>JavaPlot</b> de Olly Oeschsle, University of Essex,
 * conforme a los terminos de la licencia GNU 2.
 * </p>
 * <p>
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version,
 * provided that any use properly credits the author.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details at http://www.gnu.org
 * </p>
 * 
 * @author JM.Lopez, Universidad Europea de Madrid
 * @version Enero 2019
 * @Edition authors Pedro Castillo Torio, Andres Ayala Llopis, 
 */
public class Demo {

	public static final double  
	R = 10.0,      //Resistencia de mebrana en MOhmios
	tau = 10,      //constante de tiempo de la membrana en ms (C=tau/R)
	Vrep = -65.0,  //Potencial de reposo de la membrana en mV
	Vth = -50,     //Potencial umbral de disparo de la membrana en mV
	Vreset = -70,  //Voltaje de reseteo tras disparo en mV
	Vspike = 30,   //Voltaje pico en mV

	tFinSimul = 500,//Duraci�n en ms de la ventana temporal de la representaci�n gr�fica
	tIniEstim = 100,//Tiempo en ms en que comienza el est�mulo dentro de la ventana temporal 
	tFinEstim = 400,//Tiempo en ms en que acaba el est�mulo dentro de la ventana temporal 
	Dt = 0.1,       //Resoluci�n temporal en ms
	Ie = 2;         //Intensidad en nA del pulso de corriente inyectada a la neurona

	public static final int dim = (int) (tFinSimul / Dt);

	/**
	 * Lanza la aplicacion.
	 * @param args Sin uso.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new GraphApplication(getExampleGraph1());
				new GraphApplication(getExampleGraph2());
			}
		});
}

	public  static double[] generaTiempo(){
		double[] tiempo= new double [dim];
		tiempo[0] = 0;
		
		for (int i=1; i<tiempo.length;i++ ) {
			tiempo[i] = tiempo[i-1] + Dt;
		}
		return tiempo;
	}

	/**
	 * Genera la intensidad del estimulo
	 * @return intensidad
	 */
	public static double[] estimulo(){
		double[] intensidad = new double [dim];
		double tiempo = 0;
		
		for (int i = 0; i < intensidad.length; i++) {
			if(tiempo < tIniEstim || tiempo > tFinEstim) {
				intensidad[i] = 0;
			} else {
				intensidad[i] = Ie;
			}
			tiempo = tiempo + Dt;
		}
		return intensidad;
	}

	/**
	 * Genera el Potencial de membrana de la neurona
	 * @param intensidad
	 * @return potencial
	 */
	public static double[] intFire(double[] intensidad){
		double [] potencial= new double [intensidad.length];
		double V = Vrep;
 
		for(int i=0; i<potencial.length; i++) {
			V = Vrep + R * intensidad[i] + (V - Vrep - R * intensidad[i]) * Math.exp(-Dt / tau);
			if (V < Vth) {
				potencial[i] = V;
			} else {
				potencial[i] = Vspike;
				V = Vreset;
			}
		}
		return potencial;
	}

	/**
	 * Genera la grafica compuesta por la funcion discreta de dispersion.
	 * @return El grafico.
	 * @see es.uem.proyecto.plotting.ScatterPlotter
	 */
	public static Graph getExampleGraph1() {

		// Ajustes generales del grafico
		PlotSettings p = new PlotSettings(0, tFinSimul, -Ie * 0.1, Ie * 1.1);
		p.setAxisColor(Color.RED);
		p.setTitle("Intensidad del estimulo de corriente (nA) inyectada en la neurona frente al tiempo (ms)");
		p.setGridSpacingX(50);
		p.setGridSpacingY(0.2);
		p.setNumberFormatterX(new DecimalFormat("0"));
		p.setNumberFormatterY(new DecimalFormat("0.0"));
		Graph graph = new Graph(p);
		
		double []tiempo = generaTiempo();
		double[] intensidad = estimulo();

		// puntos (x, y) para el ScatterPlotter 
		graph.functions.add(new ScatterPlotter(tiempo, intensidad) {
			public String getName() {
				return "Potencial de membrana";
			}
		});

		return graph;
	}

	/**
	 * Genera la grafica compuesta por una funcion discreta de dispersion y un grafico de una funcion continua.
	 * @return El grafico.
	 * @see es.uem.proyecto.plotting.ContinuousFunctionPlotter
	 * @see es.uem.proyecto.plotting.ScatterPlotter
	 */
	public static Graph getExampleGraph2() {

		// Ajustes generales del gráfico
		PlotSettings p = new PlotSettings(0, tFinSimul, Vreset * 1.1, Vspike * 1.1);
		p.setAxisColor(Color.RED);
		p.setTitle("Potencial de menbrana (mV) de la neurona frente al tiempo (ms)");
		p.setGridSpacingX(50.0);
		p.setGridSpacingY(10);
		p.setNumberFormatterX(new DecimalFormat("0"));
		p.setNumberFormatterY(new DecimalFormat("0"));
		Graph graph = new Graph(p);

		double []tiempo = generaTiempo();
		double[] intensidad = estimulo();
		double[] potencial = intFire(intensidad);
		
		// puntos (x, y) para el ScatterPlotter 

		graph.functions.add(new ScatterPlotter(tiempo, potencial) {
			public String getName() {
				return "Potencial de membrana";
			}
		});
		
		graph.functions.add(new ContinuousFunctionPlotter(){
            public double getY(double x) {
            	return Vth;
            }
            public String getName() {
                return "Funcion sigmoidea";
            }
        });

		return graph;
	} 
}