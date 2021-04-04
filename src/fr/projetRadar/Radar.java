package fr.projetRadar;




public class Radar {
	private int id;
	private static int compteur=1;
	private boolean feuRouge = false;
	private int excesVitesse;
	private int montantAmande;
	private int pointsRetires;
	private boolean emailRecu;
	private int vitesseLimite;
	private int[] arrVitesses = {20,30,40,50};
	private int[] amandes = {68,135,1500,3750};
	private int[] classes = {3,4,5};
	private int[] points = {1,2,3,4,5,6};
	private String[] peines = {"Suspension de 3 ans du permis de conduire",
			"Suspension de 3 ans du permis de conduire et Confiscation du véhicule",
			"Suspension de 3 ans du permis de conduire (sans sursis ni « permis blanc »)",
			"Suspension de 3 ans du permis de conduire (sans sursis ni « permis blanc ») et Confiscation du véhicule",
			"Confiscation du véhicule en cas de récidive Suspension de 3 ans du permis de conduire (sans sursis ni « permis blanc »)"
			+ "et Immobilisation ou confiscation du véhicule","Peine de prison de 3 mois"};
	
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
		
		if(vehicule.getVitesse()< vitesseLimite + arrVitesses[1] && vitesseLimite>50) {
			envoiAmende(amandes[0],classes[1],points[1]);
		}
	 	System.out.println(vehicule.getPlaqueImmat());  
	}
	
	public String envoiAmende(int classe,int montant,int points) {
		// System.out.println(String.format(" %d \u20AC", 123)); //%d for integer
		String res, peine;
		res= peine ="";
		if(classe > 2 && !feuRouge) {
			
		}
		return res + peine;
	}
	
	public void envoiMail() {
		
	}
	
	/**
	 * methode pour génerer la vitesse en plus +20 ou -20
	 * **/
	
	private void demarrerRadar(Vehicule[] vehicules) {
		while(true) {
			for(Vehicule vehicule: vehicules) {
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
}
