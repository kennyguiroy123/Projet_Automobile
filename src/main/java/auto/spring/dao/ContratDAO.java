package auto.spring.dao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import auto.spring.modele.Entreprise;
import auto.spring.modele.Contrat;

@Repository
public class ContratDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void sauver(Contrat pContrat) {
		em.persist(pContrat);
	}

	public Entreprise getEntrepriseById(Long pidEntreprise) {
		return em.find(Entreprise.class, pidEntreprise);
	}
	
	public List<Entreprise> getEntreprises() {
		return em.createQuery("select e from Entreprise e where e.id = nEntreprise", Entreprise.class)
				 .getResultList();
	}
	
	public List<Contrat> getContrat() {
		return em.createQuery("select * from Contrat cc", Contrat.class)
				 .getResultList();
	}
	
	public Contrat getContratCadreById(Long pidContratCadre) {
		return em.find(Contrat.class, pidContratCadre);
	}
}
