package fr.projetRadar;

import java.util.Timer;
import fr.utils.Utils;

public class MainRadar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicule[] vehicules;
		Timer timer = new Timer();
		vehicules = new Vehicule[3];
		// création des voitures
		vehicules = creerVehicules();
		Radar radar = new Radar(vehicules);
	}
	
	private static Vehicule[] creerVehicules() { 
		Vehicule[] vehicules = new Vehicule[3];
		Vehicule v1 = new Vehicule();
		v1.setPlaqueImmat("sdfsgerhg");
		vehicules[0] = v1;
		Vehicule v2 = new Vehicule();
		v2.setPlaqueImmat("ilpmberhg");
		vehicules[1] = v2;
		Vehicule v3 = new Vehicule();
		v3.setPlaqueImmat("254sf54sdf");
		vehicules[2] = v3;	
		return vehicules;		
	}

}
