package auto.spring.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int n_client;
	private String nom_utilisateur;
	private String motdepasse;
	private String token;
	
	public Client(String pnom, String pmdp, String ptoken) {
		this.nom_utilisateur = pnom;
		this.motdepasse = pmdp;
		this.token = ptoken;
	}
	public int getN_client() {
		return n_client;
	}
	
	public String getNom_utilisateur() {
		return nom_utilisateur;
	}
	public void setNom_utilisateur(String nom_utilisateur) {
		this.nom_utilisateur = nom_utilisateur;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
