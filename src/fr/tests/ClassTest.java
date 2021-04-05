package fr.tests;

import java.io.IOException;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import fr.projetRadar.MainRadar;
import fr.projetRadar.Radar;
import fr.projetRadar.Vehicule;
import fr.utils.Utils;

public class ClassTest {

	public static void main(String[] args) throws AddressException, MessagingException {
		// TODO Auto-generated method stub
		Vehicule[] vehicules = null;
		Radar radar;
		Scanner sc = new Scanner(System.in);
		int vitesseLimite = 0; 
		clearScreen();
		String option ="";
		menu();
		label1:while (true){			
			
			option = sc.nextLine();
			option = option.toUpperCase();				
			switch(option) {
				case "A":										
					clearScreen();
					System.out.print("Vitesse limite ?");
					vitesseLimite = sc.nextInt();
					vehicules = creerVoitures(vitesseLimite);					
					break;				
				case "B":
					clearScreen();
					System.out.print("Vitesse limite ?");
					vitesseLimite = sc.nextInt();
					accelerer(vitesseLimite);										
					break;				
				case "C":
					System.out.print("Vitesse limite ?");
					vitesseLimite = sc.nextInt();
					clearScreen();
					ralentir(vitesseLimite);
					break;		/*		
				case "D":
					clearScreen();
					testAffich(vitesseLimite);
					break;/*			
				case "E":
					clearScreen();
					derniereChambreVide(arr);
					break;				
				case "F":
					if(testmPasse(login,mPasse)){
						clearScreen();
						reserveChambre(arr);	
					}else{
						System.out.println(" vous n'avez pas les droits pour cette action...");
					}					
					break;				
				case "G":
					if(testmPasse(login,mPasse)){
						clearScreen();
						libererChambre(arr);
					}else{
						System.out.println(" vous n'avez pas les droits pour cette action...");
					}	
					break;*/
				case "Q": 					
					break label1;
				default:
					clearScreen();
					menu();					
			}		
		}
			
		sc.close();
	}
	
	public static void clearScreen() {  
	    //Clears Screen in java

			try {

				if (System.getProperty("os.name").contains("Windows"))

					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

				else

					Runtime.getRuntime().exec("clear");

			} catch (IOException | InterruptedException ex) {}
	} 
		
	private static void menu(){
		// menu pour choisir l'option
		System.out.println(Utils.tab(5) + "MENU DE TESTS\n");		
		System.out.println(Utils.tab(4) + "A-Creer voitures radar et tests de boucle infinie");
		System.out.println(Utils.tab(4) +"B- Accelerer");
		System.out.println(Utils.tab(4) +"C- Ralentir");/*
		System.out.println(Utils.tab(4) +"D- Affichage peines et amendes");/*
		System.out.println(tab(4) +"E- Afficher le numéro de la dernière chambre vide");// dernière liberée
		System.out.println(tab(4) +"F- Réserver une chambre");// admin
		System.out.println(tab(4) +"G- Liberer une chambre\n");// admin
		System.out.println(tab(4) +"Q- Quitter");// admin
					*/
	}
	
	private static Vehicule[] creerVoitures(int vitessLimite) throws AddressException, MessagingException{
		Vehicule[] vehicules = new Vehicule[3];
		String res = "";
		System.out.println("Creation vehicules...");
		vehicules = MainRadar.creerVehicules(vitessLimite);

		// affichage des véhicules
		System.out.println("Affichage des 3 voitures crées");
		for(Vehicule v : vehicules) {
			res+=v.getMarque() + " / "+ v.getPlaqueImmat() + " / " + v.getEmailConducteur()+"\n";	
		}
		System.out.println(" voitures creees \n");
		System.out.println(res);
		System.out.println("Creation radar...");
		Radar radar = new Radar(vehicules, vitessLimite);
				
		return vehicules;
	}
	

	
	private static Vehicule creerVoiture(int vitessLimit){
		Vehicule.vitesseLimite = vitessLimit;
		Scanner sc = new Scanner(System.in);
		Vehicule v = new Vehicule();
		v.setVitesse(vitessLimit);
		v.setPlaqueImmat("460 AXG 59");
		v.setEmailConducteur("vlaboure059@gmail.com");
		v.setMarque("ford");
		return v; 
	}

	private static void accelerer(int vitLimite) {
		Vehicule v = creerVoiture(vitLimite);
		System.out.println(" La vitesse est de : " + v.getVitesse());		
		System.out.println("acceleration de -/+20 km/h.");	
		v.acceleration();
		System.out.println("Nouvelle vitesse : " + v.getVitesse());
	}
	
	private static void ralentir(int vitLimite) {
		Vehicule v = creerVoiture(vitLimite);
		System.out.println("La vitesse est de : " + v.getVitesse());		
		System.out.println("acceleration... ");
		v.acceleration();
		System.out.println("Nouvelle vitesse :  " + v.getVitesse());
		System.out.println("revenir à la limite de vitesse de : " + vitLimite + " kmh");	
		v.ralentir();
		System.out.println("Nouvelle vitesse : " + v.getVitesse());
	}
	
}
