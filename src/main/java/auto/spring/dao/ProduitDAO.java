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

	public List<Produit> getProduits() throws PasDeProduitException {
		List<Produit> Produits =  em.createQuery("select * from Produit", Produit.class).getResultList();
		if (Produits.isEmpty()) {throw new PasDeProduitException();}
		return Produits;
	}
}
