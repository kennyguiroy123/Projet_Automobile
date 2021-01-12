package auto.spring.dao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import automobile.modele.*;

@Repository
public class ClientDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void sauver(Client pClient) {
		em.persist(pClient);
	}
	
	public List<Commande> getCommandes() {
		return em.createQuery("select c from Commande c where c.id = nCommande", Commande.class)
				 .getResultList();
	}
	
	public List<Client> getClient() {
		return em.createQuery("select * from Client", Client.class)
				 .getResultList();
	}
	
	public Client getClientById(Long pidClient) {
		return em.find(Client.class, pidClient);
	}
}
