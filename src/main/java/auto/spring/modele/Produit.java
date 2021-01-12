package auto.spring.modele;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int n_produit;
	private String nom;
	private Double cout_fabrication;
	private Double prix_unitaire_HT;
	private Double TVA;
	private int quantite_stock;
	private String description;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Contenir", joinColumns = @JoinColumn(name = "nCommande"), inverseJoinColumns = @JoinColumn(name = "nProduit"))
	private List<Commande> commandes; 
	
	
	public int getN_produit() {
		return n_produit;
	}
	public void setN_produit(int n_produit) {
		this.n_produit = n_produit;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Double getCout_fabrication() {
		return cout_fabrication;
	}
	public void setCout_fabrication(Double cout_fabrication) {
		this.cout_fabrication = cout_fabrication;
	}
	public Double getPrix_unitaire_HT() {
		return prix_unitaire_HT;
	}
	public void setPrix_unitaire_HT(Double prix_unitaire_HT) {
		this.prix_unitaire_HT = prix_unitaire_HT;
	}
	public Double getTVA() {
		return TVA;
	}
	public void setTVA(Double tVA) {
		TVA = tVA;
	}
	public int getQuantite_stock() {
		return quantite_stock;
	}
	public void setQuantite_stock(int quantite_stock) {
		this.quantite_stock = quantite_stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}