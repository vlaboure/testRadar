package fr.projetRadar;

import java.util.Random;

import fr.utils.Utils;

public class Vehicule {
	private String plaqueImmat ;
	private int id;	
	private String marque;
	private int vitesse;
	private int acceleration;
	private String emailConducteur;
	private static int compt = 0;
	//utilisé pour le retour à la vitesse limite après flash
	protected static int vitesseLimite;
	protected static int[] nbProces; 
	//private int nbrProces;
	
	
	
	
	public Vehicule() {
		id = compt++;
		this.vitesse = vitesseLimite;
		nbProces = new int[3];
	}
	
	
	
	public int getId() {
		return id;
	}



	public Vehicule(String plaqueImmat, String marque, int vitesse, int acceleration, String emailConducteur,
			int vitesseLimite, int nbrProces) {
		this.plaqueImmat = plaqueImmat;
		this.marque = marque;
		this.vitesse = vitesseLimite;
		this.acceleration = acceleration;
		this.emailConducteur = emailConducteur;
		//this.vitesseLimite = vitesseLimite;
		//this.nbrProces = nbrProces;
	}



	public void generationAleat() {
		setVitesse(getVitesse()+Utils.randVitesse(-20, 40));//modifierVitesse());
	}
	/*
	public int modifierVitesse() {
		int max = 80;
        int min = 0;
        Random r = new Random();
        return r.nextInt(max - min ) + min;

	}*/
	
	public void ralentir() {
		setVitesse(vitesseLimite);
		//Utils.randVitesse(-20, 40);
	}
	/*
	public int getNbrProces() {
		return nbrProces;
	}
	public void setNbrProces(int nbrProces) {
		this.nbrProces = nbrProces;
	}*/
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}
	/*
	public int getVitesseLimite() {
		return vitesseLimite;
	}	
	public void setVitesseLimite(int vitesseLimite) {
		this.vitesseLimite = vitesseLimite;
	}
	*/
	public String getPlaqueImmat() {
		return plaqueImmat;
	}
	
	public void setPlaqueImmat(String plaqueImmat) {
		this.plaqueImmat = plaqueImmat;
	}
	
	public int getVitesse() {
		return vitesse;
	}
	
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	
	public int getAcceleration() {
		return acceleration;
	}
	
	public void setAcceleration(int acceleration) {
		this.acceleration = acceleration;
	}
	
	public String getEmailConducteur() {
		return emailConducteur;
	}
	
	public void setEmailConducteur(String emailConducteur) {
		this.emailConducteur = emailConducteur;
	}
}
