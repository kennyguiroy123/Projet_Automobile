package auto.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auto.spring.dao.PizzaDao;
import auto.spring.dao.ProduitDAO;
import auto.spring.modele.Pizza;

@Service
public class ProduitService {

	@Autowired
	private ProduitDAO produitDAO;

	public List<Produit> getListeProduit() {
		return produitDAO.getProduits();
	}
}
