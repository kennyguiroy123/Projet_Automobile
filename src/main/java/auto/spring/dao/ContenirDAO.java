package auto.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;

import auto.spring.modele.Contenir;

public class ContenirDAO {
	
	private EntityManager em;

	public void sauver(Contenir Contenir) {
		em.persist(Contenir);
	}
	
	public List<Contenir> getContenirs(){
		List<Contenir> Contenirs =  em.createQuery("select * from Contenir", Contenir.class).getResultList();
		return Contenirs;
	}
}
