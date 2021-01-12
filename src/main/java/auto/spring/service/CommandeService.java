package auto.spring.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auto.spring.dao.CommandeDAO;
import auto.spring.dao.ProduitDAO;
import auto.spring.exception.PasDeProduitException;
import auto.spring.modele.Commande;

@Service
public class CommandeService {
	
	private ProduitDAO produitDao;
	private CommandeDAO commandeDao;
	
	@Autowired
	public CommandeService(ProduitDAO produitDao, CommandeDAO commandeDao) {
		this.produitDao = produitDao;
		this.commandeDao = commandeDao;
	}

	@Transactional
	public CommandeProduit commander(CommandeDto commandeDto) {
		Commande commande = new Commande();
		commande.setNom(commandeDto.getNom());
		commande.setTelephone(commandeDto.getTelephone());
		commande.setEnAttente(true);
		commande.setDateEmission(new Date());
		for(int id : commandeDto.getProduitId()) {
			commande.ajouter(produitDao.getRecapById(id));
		}
		commandeDao.sauver(commande);
		return commande;
	}

	public Commande getRecap(int idCommande) {
		return commandeDao.getRecapById(idCommande);
	}

	public Commande getCommandeSuivante() throws PasDeProduitException {
		return commandeDao.getCommandeSuivante();
	}

	public List<Commande> getCommandesEnAttente() {
		return commandeDao.getCommandesEnAttente();
	}

	@Transactional
	public void signalerCommandePrete(int id) {
		commandeDao.signalerCommandePrete(id);
	}

}
