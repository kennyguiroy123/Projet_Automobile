package auto.spring.modele;

import java.sql.Date;

public class Contrat {
	
	private int n_contrat;
	private byte taux_marge;
	private String categorie;
	private Date date_debut;
	private Date date_fin;
	
	public int getN_contrat() {
		return n_contrat;
	}
	public void setN_contrat(int n_contrat) {
		this.n_contrat = n_contrat;
	}
	public byte getTaux_marge() {
		return taux_marge;
	}
	public void setTaux_marge(byte taux_marge) {
		this.taux_marge = taux_marge;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	

}
