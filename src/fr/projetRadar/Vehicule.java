package fr.projetRadar;

import java.util.Random;

public class Vehicule {
	private String plaqueImmat ;
	private String marque;
	private int vitesse;
	private int acceleration;
	private String emailConducteur;
	private int vitesseLimite;
	private int nbrProces;
	public Vehicule() {
		
	}
	public Vehicule(String plaqueImmat, String marque, int vitesse, int acceleration, String emailConducteur,
			int vitesseLimite, int nbrProces) {
		this.plaqueImmat = plaqueImmat;
		this.marque = marque;
		this.vitesse = vitesse;
		this.acceleration = acceleration;
		this.emailConducteur = emailConducteur;
		this.vitesseLimite = vitesseLimite;
		this.nbrProces = nbrProces;
	}



	public void generationAleat() {
		setVitesse(getVitesse()+modifierVitesse());
	}
	
	public int modifierVitesse() {
			int max = 20;
			int min = -20;
			Random r = new Random();
			return r.nextInt(max - min ) + min;
	}
	
	public void ralentir() {
		setVitesse(vitesseLimite);
		modifierVitesse();
	}
	
	public int getNbrProces() {
		return nbrProces;
	}
	public void setNbrProces(int nbrProces) {
		this.nbrProces = nbrProces;
	}
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}
	public int getVitesseLimite() {
		return vitesseLimite;
	}
	
	public void setVitesseLimite(int vitesseLimite) {
		this.vitesseLimite = vitesseLimite;
	}
	
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
