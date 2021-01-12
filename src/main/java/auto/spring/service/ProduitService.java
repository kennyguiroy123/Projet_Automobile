package auto.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auto.spring.dao.ProduitDAO;
import auto.spring.exception.PasDeProduitException;
import auto.spring.modele.Produit;

@Service
public class ProduitService {

	@Autowired
	private ProduitDAO produit;

	public List<Produit> getListeProduit() throws PasDeProduitException {
		return produit.getProduits();
	}
}
