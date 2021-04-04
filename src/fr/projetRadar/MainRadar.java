package fr.projetRadar;

import java.util.Scanner;
import java.util.Timer;

public class MainRadar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Vehicule[] vehicules;
		System.out.print(" quelle est la vitesse limite de la route ?");
		int vitesseLimite = sc.nextInt();
		Timer timer = new Timer();
		vehicules = new Vehicule[3];
		// création des voitures
		vehicules = creerVehicules(vitesseLimite);
		Radar radar = new Radar(vehicules, vitesseLimite);
	}
	
	private static Vehicule[] creerVehicules(int vitesseLimite) { 
		Vehicule[] vehicules = new Vehicule[3];
		Vehicule v1 = new Vehicule();
		v1.setPlaqueImmat("sdfsgerhg");
		v1.setVitesseLimite(vitesseLimite);
		v1.setMarque("ford");
		vehicules[0] = v1;
		Vehicule v2 = new Vehicule();
		v2.setPlaqueImmat("ilpmberhg");
		v2.setVitesseLimite(vitesseLimite);
		v2.setMarque("Toyota");
		vehicules[1] = v2;
		Vehicule v3 = new Vehicule();
		v3.setPlaqueImmat("254sf54sdf");
		v3.setVitesseLimite(vitesseLimite);
		v3.setMarque("BMW");
		vehicules[2] = v3;
		return vehicules;		
	}

}
