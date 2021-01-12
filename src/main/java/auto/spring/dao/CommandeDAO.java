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

	public Commande getRecapById(Long idCommande) {
		return em.find(Commande.class, idCommande);
	}

	public Commande getCommandeSuivante() {
		List<Commande> commandes =  em.createQuery("select c from Commande c where c.enAttente = true order by c.dateEmission", Commande.class)
									  .setMaxResults(1)
									  .getResultList();
		return commandes.get(0);
	}

	public List<Commande> getCommandesEnAttente() {
		return em.createQuery("select c from Commande c where c.enAttente = true order by c.dateEmission", Commande.class)
				 .getResultList();
	}

	public void signalerCommandePrete(Long id) {
		em.createQuery("update Commande c set c.enAttente = false where c.id = :id")
		  .setParameter("id", id)
		  .executeUpdate();
	}

}
