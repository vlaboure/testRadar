package fr.projetRadar;

import java.util.Scanner;
import java.util.Timer;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class MainRadar {

	public static void main(String[] args) throws AddressException, MessagingException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Vehicule[] vehicules;
		System.out.print(" quelle est la vitesse limite de la route ?"); 
		int vitesseLimite = sc.nextInt();
		Timer timer = new Timer();
		vehicules = new Vehicule[3];
		// cr�ation des voitures
		vehicules = creerVehicules(vitesseLimite);
		Radar radar = new Radar(vehicules, vitesseLimite);
	}
	
	public static Vehicule[] creerVehicules(int vitesseLimite) { 
		Vehicule[] vehicules = new Vehicule[3];
		//vitesse limite en statique dans vehicule
		Vehicule.vitesseLimite = vitesseLimite;
		Vehicule v1 = new Vehicule();
		v1.setPlaqueImmat("460 AXG 59");
		v1.setEmailConducteur("vlaboure059@gmail.com");
		v1.setMarque("ford");
		vehicules[0] = v1;
		Vehicule v2 = new Vehicule();
		v2.setPlaqueImmat("EZ-885-WV");
		v2.setEmailConducteur("vlaboure@hotmail.com");
		//v2.setVitesseLimite(vitesseLimite);
		v2.setMarque("Toyota");
		vehicules[1] = v2;
		Vehicule v3 = new Vehicule();
		v3.setPlaqueImmat("AA-59-GG");
		v3.setEmailConducteur("v.laboure@gmail.com");
		//v3.setVitesseLimite(vitesseLimite);
		v3.setMarque("BMW");
		vehicules[2] = v3;
		return vehicules;		
	}

}
