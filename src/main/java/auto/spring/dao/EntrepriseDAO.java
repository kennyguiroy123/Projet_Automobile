package auto.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import auto.spring.modele.Entreprise;

@Repository
public class EntrepriseDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void sauver(Entreprise entreprise) {
		em.persist(entreprise);
	}

	public Entreprise getentrepriseById(Long idEntreprise) {
		return em.find(Entreprise.class, idEntreprise);
	}

	public List<Entreprise> getentreprises() {
		return em.createQuery("select * from entreprise", Entreprise.class).getResultList();
	}

}
