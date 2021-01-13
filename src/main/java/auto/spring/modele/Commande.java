package auto.spring.modele;


import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int n_commande;
	@Temporal(TemporalType.DATE)
	private Date date_commande;
	private Date date_livraison;
	private Double frais_port;
	private String destinataire;
	private Double prix_htc;
	private Double prix_ttc;
	private boolean enAttente;
	
	//@ManyToMany(mappedBy = "Produit", fetch = FetchType.LAZY)
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "commande", fetch=FetchType.EAGER)
    private List<DetailCommande> details = new ArrayList<>();
	
	@ManyToOne
	private Entreprise entreprise;
	
	public Commande() {
		
	}
	
	/*public Commande(int n_commande2, Date date_commande2, Date date_livraison2, Double frais_port2,
			String destinataire2, Double prix_htc2, Double prix_ttc2, boolean enAttente2) {
		n_commande = n_commande2;
		date_commande = date_commande2;
		date_livraison = date_livraison2;
		frais_port = frais_port2;
		destinataire = destinataire2;
		prix_htc = prix_htc2;
		prix_ttc = prix_ttc2;
		enAttente = enAttente2;
	}*/
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
	
	public void ajouter(Produit produit) {
		DetailCommande detailCommande = new DetailCommande();
		detailCommande.setProduit(produit);
		detailCommande.setCommande(this);
		this.details.add(detailCommande);
	}
	
	public boolean isEnAttente() {
		return enAttente;
	}
	public void setEnAttente(boolean enAttente) {
		this.enAttente = enAttente;
	}
	
	
	

}
