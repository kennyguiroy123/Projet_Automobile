package automobile.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import auto.spring.exception.PasDeCommandeSuivanteException;
import automobile.modele.Commande;

@Repository
public class CommandeDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void sauver(CommandePizza commande) {
		em.persist(commande);
	}

	public CommandePizza getRecapById(Long idCommande) {
		return em.find(CommandePizza.class, idCommande);
	}

	public CommandePizza getCommandeSuivante() throws PasDeCommandeSuivanteException {
		List<CommandePizza> commandes =  em.createQuery("select c from Commande c where c.enAttente = true order by c.dateEmission", CommandePizza.class)
									  .setMaxResults(1)
									  .getResultList();
		if (commandes.isEmpty()) {
			throw new PasDeCommandeSuivanteException();
		}
		return commandes.get(0);
	}

	public List<CommandePizza> getCommandesEnAttente() {
		return em.createQuery("select c from Commande c where c.enAttente = true order by c.dateEmission", CommandePizza.class)
				 .getResultList();
	}

	public void signalerCommandePrete(Long id) {
		em.createQuery("update Commande c set c.enAttente = false where c.id = :id")
		  .setParameter("id", id)
		  .executeUpdate();
	}

}
