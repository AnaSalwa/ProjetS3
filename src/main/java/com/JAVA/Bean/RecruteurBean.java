package com.JAVA.Bean;

public class RecruteurBean {
	
	private int       id;
    private String    nom;
    private String    prenom;
    private String    email;
    private String    password;
    private String    entreprise;
    
    
	public RecruteurBean(int id, String nom, String prenom, String email, String password, String entreprise) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.entreprise = entreprise;
	}
	
	


	public RecruteurBean() {
		super();
	}




	@Override
	public String toString() {
		return "RecruteurBean [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password="
				+ password + ", entreprise=" + entreprise + ", getId()=" + getId() + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
				+ ", getEntreprise()=" + getEntreprise() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEntreprise() {
		return entreprise;
	}


	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}
	
	
    
    
	
	

}
