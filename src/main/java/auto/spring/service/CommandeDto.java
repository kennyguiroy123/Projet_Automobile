package auto.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


public class CommandeDto {
	
	@Size(min = 1, message = "Vous devez choisir au moins un produit")
	private List<Long> produitId = new ArrayList<>();
	@NotBlank
	private String nom_destinataire;

	
	public List<Long> getProduitId() {
		return produitId;
	}

	public void setProduitId(List<Long> produitId) {
		this.produitId = produitId;
	}

	public String getNom() {
		return nom_destinataire;
	}

	public void setNom(String nom_destinataire) {
		this.nom_destinataire = nom_destinataire;
	}

}
