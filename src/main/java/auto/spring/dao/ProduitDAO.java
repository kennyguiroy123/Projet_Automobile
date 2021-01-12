package auto.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import auto.spring.exception.PasDeProduitException;
import auto.spring.modele.Produit;

@Repository
public class ProduitDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void sauver(Produit Produit) {
		em.persist(Produit);
	}

	public Produit getRecapById(Long idProduit) {
		return em.find(Produit.class, idProduit);
	}

	public Produit getProduits() throws PasDeProduitException {
		List<Produit> Produits =  em.createQuery("select * from Produit", Produit.class).getResultList();
		if (Produits.isEmpty()) {throw new PasDeProduitException();}
		return Produits.get(0);
	}

	public List<Produit> getProduitsEnAttente() {
		return em.createQuery("select c from Produit c where c.enAttente = true order by c.dateEmission", Produit.class)
				 .getResultList();
	}

	public void signalerProduitPrete(Long id) {
		em.createQuery("update Produit c set c.enAttente = false where c.id = :id")
		  .setParameter("id", id)
		  .executeUpdate();
	}

}
