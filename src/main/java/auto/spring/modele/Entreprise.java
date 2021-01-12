package auto.spring.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Entreprise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int n_entreprise;
	private String nom;
	private String adresse;
	private int telephone;
	private String email;
	
	public int getN_entreprise() {
		return n_entreprise;
	}
	public void setN_entreprise(int n_entreprise) {
		this.n_entreprise = n_entreprise;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
