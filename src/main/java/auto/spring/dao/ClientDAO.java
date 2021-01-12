package auto.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import auto.spring.modele.Client;

@Repository
public class ClientDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void sauver(Client client) {
		em.persist(client);
	}

	public Client getclientById(Long idclient) {
		return em.find(Client.class, idclient);
	}

	public List<Client> getclients() {
		return em.createQuery("select * from client", Client.class).getResultList();
	}

}
