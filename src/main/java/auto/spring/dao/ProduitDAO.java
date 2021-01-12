package auto.spring.dao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import automobile.modele.*

@Repository
public class ProduitDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void sauver(Produit pProduit) {
		em.persist(pProduit);
	}
	
	public List<Commande> getCommandes() {
		return em.createQuery("select c from Commande c where c.id = nCommande", Commande.class)
				 .getResultList();
	}
	
	public List<Produit> getProduits() {
		return em.createQuery("select * from produit", Produit.class)
				 .getResultList();
	}
	
	public Produit getProduitById(Long pidProduit) {
		return em.find(Produit.class, pidProduit);
	}
}
