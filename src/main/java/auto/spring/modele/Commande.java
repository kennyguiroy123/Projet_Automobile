package auto.spring.modele;

import java.sql.Date;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

public class Commande {
	
	private int n_commande;
	private Date date_commande;
	private Date date_livraison;
	private Double frais_port;
	private String destinataire;
	private Double prix_htc;
	private Double prix_ttc;
	
	@ManyToMany(mappedBy = "Produit", fetch = FetchType.LAZY)
    private List<Produit> produits;
	
	
	public int getN_commande() {
		return n_commande;
	}
	public void setN_commande(int n_commande) {
		this.n_commande = n_commande;
	}
	public Date getDate_commande() {
		return date_commande;
	}
	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}
	public Date getDate_livraison() {
		return date_livraison;
	}
	public void setDate_livraison(Date date_livraison) {
		this.date_livraison = date_livraison;
	}
	public Double getFrais_port() {
		return frais_port;
	}
	public void setFrais_port(Double frais_port) {
		this.frais_port = frais_port;
	}
	public String getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}
	public Double getPrix_htc() {
		return prix_htc;
	}
	public void setPrix_htc(Double prix_htc) {
		this.prix_htc = prix_htc;
	}
	public Double getPrix_ttc() {
		return prix_ttc;
	}
	public void setPrix_ttc(Double prix_ttc) {
		this.prix_ttc = prix_ttc;
	}
	
	
	
	
	

}
