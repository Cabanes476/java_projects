package Principal;

import Objetos.Package1;
import Objetos.capitan;
import Objetos.Package2;
import Objetos.Passenger2;
import Objetos.Package3;
import Objetos.Passenger3;

public class Boat {
	
	public static float
	numberSeats,
	maximumLoadWeight,
	ticketPrice,
	cargoKilogramRatePrice;
	
	public static float getnumberSeats() {
		return numberSeats;
	}
	public static float getmaximumLoadWeight() {
		return maximumLoadWeight;
	}
	public static float getticketPrice() {
		return ticketPrice;
	}
	public static float cargoKilogramRatePrice() {
		return cargoKilogramRatePrice;
	}
	
	//Cáclculo del peso total
	public static float calculateTotalWeight() {
		
		float weight1;
		float weight2;
		float weight3;
		float weight4;
		float weight5;
		float weight6;
		
		weight1 = capitan.getweight();
		weight2 = Passenger2.getweight();
		weight3 = Passenger3.getweight();
		weight4 = Package1.getpackageweight();
		weight5 = Package2.getpackageweight();
		weight6 = Package3.getpackageweight();
		
		float totalweight;
		return totalweight = weight1 + weight2 + weight3 + weight4 + weight5 + weight6;
	}
	
	
	
	
	
	
	
}
