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
public class ContenirDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void sauver(Contenir pContenir) {
		em.persist(pContenir);
	}
	
	public List<Contenir> getContenir() {
		return em.createQuery("select * from Contenir", Contenir.class)
				 .getResultList();
	}
	
	public Contenir getContenirById(Long pidContenir) {
		return em.find(Contenir.class, pidContenir);
	}
}
