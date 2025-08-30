package com.JAVA.Bean;

public class offre {
	private int id;
	private int id_recruteur;
    private String titre;
    private String poste;
    private String mode;
    private String date;
    
    
    
    
	public offre() {
		super();
	}

	public offre(int id,int id_recruteur, String titre, String poste, String mode, String date) {
		super();
		this.id = id;
		this.id_recruteur = id_recruteur;
		this.titre = titre;
		this.poste = poste;
		this.mode = mode;
		this.date = date;
	}
	
	public offre(int id_recruteur,String titre, String poste, String mode, String date) {
		super();
		this.id_recruteur=id_recruteur;
		this.titre = titre;
		this.poste = poste;
		this.mode = mode;
		this.date = date;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getId_recruteur() {
		return id_recruteur;
	}

	public void setId_recruteur(int id_recruteur) {
		this.id_recruteur = id_recruteur;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}
	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
	/**
	 * @return the poste
	 */
	public String getPoste() {
		return poste;
	}
	/**
	 * @param poste the poste to set
	 */
	public void setPoste(String poste) {
		this.poste = poste;
	}
	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
    
    
}