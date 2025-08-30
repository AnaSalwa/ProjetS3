package com.JAVA.Bean;

public class CandidatureBean {
	private int id;
	private int id_candidat;
	private int id_offre;
    private String motivation;
    
    
    
    
    
    
	public CandidatureBean(int id, int id_candidat, int id_offre, String motivation) {
		super();
		this.id = id;
		this.id_candidat = id_candidat;
		this.id_offre = id_offre;
		this.motivation = motivation;
	}

	public CandidatureBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "CandidatureBean [id=" + id + ", id_offre=" + id_offre + ", id_candidat=" + id_candidat + ", motivation="
				+ motivation + ", getId()=" + getId() + ", getId_offre()=" + getId_offre() + ", getId_candidat()="
				+ getId_candidat() + ", getMotivation()=" + getMotivation() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getId_offre() {
		return id_offre;
	}
	
	
	public void setId_offre(int id_offre) {
		this.id_offre = id_offre;
	}
	
	
	public int getId_candidat() {
		return id_candidat;
	}
	
	
	public void setId_candidat(int id_candidat) {
		this.id_candidat = id_candidat;
	}
	
	
	public String getMotivation() {
		return motivation;
	}
	
	
	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}
 
    
    

}
