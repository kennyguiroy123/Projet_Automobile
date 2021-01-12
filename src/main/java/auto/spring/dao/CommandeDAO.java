package auto.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import auto.spring.exception.PasDeProduitException;
import auto.spring.modele.Commande;

@Repository
public class CommandeDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void sauver(Commande commande) {
		em.persist(commande);
	}

	public Commande getCommandeById(Long idCommande) {
		return em.find(Commande.class, idCommande);
	}

	public List<Commande> getCommandes() {
		return em.createQuery("select * from Commande", Commande.class).getResultList();
	}

}
