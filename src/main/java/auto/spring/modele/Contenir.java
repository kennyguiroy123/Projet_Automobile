package auto.spring.modele;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Contenir {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCommande, idProduit;

	/**
	 * @return the idCommande
	 */
	public int getIdCommande() {
		return idCommande;
	}

	/**
	 * @param idCommande the idCommande to set
	 */
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	/**
	 * @return the idProduit
	 */
	public int getIdProduit() {
		return idProduit;
	}

	/**
	 * @param idProduit the idProduit to set
	 */
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
}
