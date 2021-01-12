package auto.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import auto.spring.modele.Commande;
import auto.spring.modele.Produit;

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
