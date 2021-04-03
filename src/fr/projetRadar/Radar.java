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
	private Vehicule[] vehicules;
	
	
	
	public Radar(Vehicule[] vehicules) {
		this.vehicules = vehicules;
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

	public void flasher() {
		
	}
	
	public void envoiAmende() {
		
	}
	
	public void envoiMail() {
		
	}
}
