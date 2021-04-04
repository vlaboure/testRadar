package fr.projetRadar;

import java.awt.image.RescaleOp;
import java.util.Arrays;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class Radar {
	private int id;
	private static int compteur=1;
	private boolean feuRouge = false;
	private int excesVitesse;
	private int montantAmande;
	private int pointsRetires;
	private boolean emailRecu;
	private int vitesseLimite;
	private boolean recidive = false; // recidive 6 points
	private int[] arrVitesses = {20,30,40,50};
	private int[] amandes = {68,135,1500,3750};
	private int[] classes = {3,4,5};
	private int[] points = {1,2,3,4,6};
	private String[] peines = {"Suspension de 3 ans du permis de conduire et Interdiction de conduire certains vehicules a moteur pour 3 ans au plus\n"
			+ "et Accomplissement d'un stage de sensibilisation a la securite routiere",
			"Suspension de 3 ans du permis de conduire (sans sursis ni permis blanc ) et Interdiction de conduire certains vehicules a moteur pour 3 ans au plus\n"
			+ "et Confiscation possible du vehicule si le conducteur en est le proprietaire et Accomplissement d'un stage de sensibilisation a la securite routiere",
			"Peine de prison de 3 mois et Immobilisation ou confiscation du vehicule",
			"Peine de prison de 3 mois et Suspension de 3 ans du permis de conduire (sans sursis ni permis blanc) et Confiscation obligatoire du vehicule si le conducteur en est le propri�taire\n"
			+ "et Interdiction de conduire certains vehicules a moteur pour 5 ans au plus et accomplissement d'un stage de sensibilisation a la securite routiere."};
	
	public Radar() {
	
	}
	
	public Radar(Vehicule[] vehicules, int vitesseLimit) {
		demarrerRadar(vehicules);
		vitesseLimite = vitesseLimit;
	}

	public boolean isFeuRouge() {
		return feuRouge;
	}

	public void setFeuRouge(boolean feuRouge) {
		this.feuRouge = feuRouge;
	}

	public int getExcesVitesse() {
		return excesVitesse;
	}

	public void setExcesVitesse(int excesVitesse) {
		this.excesVitesse = excesVitesse;
	}

	public int getMontantAmande() {
		return montantAmande;
	}

	public void setMontantAmande(int montantAmande) {
		this.montantAmande = montantAmande;
	}

	public int getPointsRetires() {
		return pointsRetires;
	}

	public void setPointsRetires(int pointsRetires) {
		this.pointsRetires = pointsRetires;
	}

//	public String getPeines() {
//		return peines;
//	}

//	public void setPeines(String peines) {
//	this.peines = peines;
//	}

	public boolean isEmailRecu() {
		return emailRecu;
	}

	public void setEmailRecu(boolean emailRecu) {
		this.emailRecu = emailRecu;
	}

	public int getId() {
		return id;
	}

	public void flasher(Vehicule vehicule) {
		if(vehicule.getVitesse()< vehicule.getVitesseLimite() + arrVitesses[0] && vehicule.getVitesse()>=vehicule.getVitesseLimite() && vehicule.getVitesseLimite()>50) {
			System.out.println(envoiAmende(amandes[0],classes[0],points[0],vehicule));
		}else if(vehicule.getVitesse()< vehicule.getVitesseLimite() + arrVitesses[0] && vehicule.getVitesse()>=vehicule.getVitesseLimite() && vehicule.getVitesseLimite()<=50) {
			System.out.println(envoiAmende(amandes[1],classes[1],points[0],vehicule));
		}else if(vehicule.getVitesse()< vehicule.getVitesseLimite() + arrVitesses[0] && vehicule.getVitesse()>=vehicule.getVitesseLimite()) {
			System.out.println(envoiAmende(amandes[1],classes[1],points[1],vehicule));
		}else if(vehicule.getVitesse()< vehicule.getVitesseLimite() + arrVitesses[1] && vehicule.getVitesse()>=vehicule.getVitesseLimite()) {
			System.out.println(envoiAmende(amandes[1],classes[1],points[2],vehicule));	
		}else if(vehicule.getVitesse()< vehicule.getVitesseLimite() + arrVitesses[2] && vehicule.getVitesse()>=vehicule.getVitesseLimite()) {
			System.out.println(envoiAmende(amandes[1],classes[2],points[3],vehicule));
		}else if(vehicule.getVitesse()< vehicule.getVitesseLimite() + arrVitesses[3] && vehicule.getVitesse()>=vehicule.getVitesseLimite() && vehicule.getNbrProces()<1) {
			System.out.println(envoiAmende(amandes[2],classes[2],points[4],vehicule));
			vehicule.setNbrProces(+1);
		}else if(vehicule.getVitesse()< vehicule.getVitesseLimite() + arrVitesses[3] && vehicule.getVitesse()>=vehicule.getVitesseLimite() && vehicule.getNbrProces()>0) {
			System.out.println(envoiAmende(amandes[2],classes[2],points[4],vehicule));
		}else{
			System.out.println("pas d'amende");
		}
	 	System.out.println(vehicule.getVitesse());
	 	System.out.println(vehicule.getVitesseLimite());
	 	vehicule.ralentir();
	}
	
	public String envoiAmende(int classe,int montant,int points, Vehicule vehicule) {
		// System.out.println(String.format(" %d \u20AC", 123)); //%d for integer
		String res, peine;
		res= peine ="";
		if(!feuRouge) {
			//3 points ou 4
			if(points > this.points[2] && points < this.points[4]) {				
				peine = peines[0];
			// 6 points	
			}else if(points == this.points[4]) {
				if(!recidive) {
					peine = peines[1];
				}else {
					peine = peines[2];
				}
			}
		}
		res+= res.format(" le vehicule "+ vehicule.getPlaqueImmat() +" de marque " + vehicule.getMarque() + " a ete flashe\n"+
		"il roulait a une vitesse de "+ vehicule.getVitesse() + " sur une route limitee a " + vehicule.getVitesseLimite() + " "); 
		return res + peine;
	}
	
	/*
	 * private int[] arrVitesses = {20,30,40,50};
	private int[] amandes = {68,135,1500,3750};
	private int[] classes = {3,4,5};
	private int[] points = {1,2,3,4,6};
	
{"Suspension de 3 ans du permis de conduire et Interdiction de conduire certains v�hicules � moteur pour 3 ans au plus\n"
			+ "et Accomplissement d'un stage de sensibilisation � la s�curit� routi�re",
			"Suspension de 3 ans du permis de conduire (sans sursis ni permis blanc ) et Interdiction de conduire certains v�hicules � moteur pour 3 ans au plus\n"
			+ "et Confiscation possible du v�hicule si le conducteur en est le propri�taire et Accomplissement d'un stage de sensibilisation � la s�curit� routi�re",
			"Peine de prison de 3 mois et Immobilisation ou confiscation du vehicule",
			"Peine de prison de 3 mois etSuspension de 3 ans du permis de conduire (sans sursis ni permis blanc) et Confiscation obligatoire du v�hicule si le conducteur en est le propri�taire\n"
			+ "et Interdiction de conduire certains v�hicules � moteur pour 5 ans au plus et accomplissement d'un stage de sensibilisation � la s�curit� routi�re."};
	
	
	 * */
	
	public void envoiMail() {
		
	}
	/**
	 * methode pour g�nerer la vitesse en plus +20 ou -20
	 * **/
	
	public String [] demarrerRadar(Vehicule[] vehicules) {
		while(true) {
			
			for(Vehicule vehicule: vehicules) {
				vehicule.generationAleat();
	    		flasher(vehicule);
	    		try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}	
	}

	@Override
	public String toString() {
		return "Radar []";
	}
}
