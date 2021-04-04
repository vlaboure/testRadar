package fr.projetRadar;

import java.util.Random;

public class Vehicule {
	private String plaqueImmat ;
	private String marque;
	private int vitesse;
	private int acceleration;
	private String emailConducteur;
	private int vitesseLimite;
	
	public Vehicule() {
		
	}
	
	public Vehicule(String plaqueImmat,int vitesse,int acceleration,String emailConducteur,int vitesseLimite){
		
	}
	
	public void genrationAleat() {
		
	}
	
	public void modifierVitesse() {
			int max = 20;
			int min = -20;
			Random r = new Random();
			return r.nextInt(max - min ) + min;
	}
	
	public void ralentir() {
		
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
