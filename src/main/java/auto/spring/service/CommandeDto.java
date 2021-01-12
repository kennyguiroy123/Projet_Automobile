package auto.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import auto.spring.modele.Produit;

public class CommandeDto {
	
	@Size(min = 1, message = "Vous devez choisir au moins un produit")
	private List<Produit> produitId = new ArrayList<>();
	@NotBlank
	private String nom_destinataire;

	
	public List<Produit> getProduitId() {
		return produitId;
	}

	public void setProduitId(List<Produit> produitId) {
		this.produitId = produitId;
	}

	public String getNom() {
		return nom_destinataire;
	}

	public void setNom(String nom_destinataire) {
		this.nom_destinataire = nom_destinataire;
	}

}
