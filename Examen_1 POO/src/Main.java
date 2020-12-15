import java.util.Date;
import java.util.Vector;
public class Main {
	
	public static void main(String[] args) {
		
		Ingrediente tomate = new Ingrediente("tomate", false, 1);
		Ingrediente queso = new Ingrediente("queso", true, 1.50);
		Ingrediente jamon = new Ingrediente("jamon", false, 1.50);
		Ingrediente cebolla = new Ingrediente("cebolla", false, 0.50);
		Ingrediente carne = new Ingrediente("carne", false, 2);
		
		Base basica = new Base("basica", true, 2, "mediana");
		Base SinGluten = new Base("sin gluten", false, 2.5, "mediana");
		Base basequeso = new Base("queso", true, 3.50, "mediana");
		
		Vector<Ingrediente> iMargarita = new Vector<>();
		iMargarita.add(tomate);
		iMargarita.add(queso);
		
		Vector<Ingrediente> iJamonqueso = new Vector<>();
		iJamonqueso.add(tomate);
		iJamonqueso.add(queso);
		iJamonqueso.add(jamon);
		
		Vector<Ingrediente> iEspecial = new Vector<>();
		iEspecial.add(tomate);
		iEspecial.add(queso);
		iEspecial.add(jamon);
		iEspecial.add(cebolla);
		iEspecial.add(carne);
		
		Date date = new Date();
		
		Pizza margarita = new Pizza("margarita, basica, iMargarita");
		Pizza Jamonquesosingluten = new Pizza("jamon y queso", SinGluten, iJamonqueso);
		Pizza especial = new Pizza("especial", basequeso, iEspecial);
		
		Vector<Pizza> pOrden1 = new Vector<>();
		pOrden1.add(margarita);
		pOrden1.add(Jamonquesosingluten);
		pOrden1.add(especial);
		
		Orden orden1 = new Orden("0001", "Calle Tajo S/N", 626881755, date, pOrden1, false);
		
		orden1.confirmarRecepcion();
	}

}
