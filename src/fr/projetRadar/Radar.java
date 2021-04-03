package fr.projetRadar;




public class Radar {
	private int id;
	private static int compteur;
	private boolean feuRouge = false;
	private int excesVitesse;
	private int montantAmande;
	private int pointsRetires;
	private String peines;
	private boolean emailRecu;
	
	
	public Radar() {
	
	}
	
	public Radar(Vehicule[] vehicules) {
		demarrerRadar(vehicules);
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

	public String getPeines() {
		return peines;
	}

	public void setPeines(String peines) {
		this.peines = peines;
	}

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
	 	System.out.println(vehicule.getPlaqueImmat());  
	}
	
	public void envoiAmende() {
		
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
