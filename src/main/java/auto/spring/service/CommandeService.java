package auto.spring.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auto.spring.dao.CommandeDao;
import auto.spring.dao.PizzaDao;
import auto.spring.exception.PasDeCommandeSuivanteException;
import auto.spring.modele.CommandePizza;

@Service
public class CommandeService {
	
	private PizzaDao pizzaDao;
	private CommandeDao commandeDao;
	
	@Autowired
	public CommandeService(PizzaDao pizzaDao, CommandeDao commandeDao) {
		this.pizzaDao = pizzaDao;
		this.commandeDao = commandeDao;
	}

	@Transactional
	public CommandePizza commander(CommandeDto commandeDto) {
		CommandePizza commande = new CommandePizza();
		commande.setNom(commandeDto.getNom());
		commande.setTelephone(commandeDto.getTelephone());
		commande.setEnAttente(true);
		commande.setDateEmission(new Date());
		for(Long id : commandeDto.getPizzaId()) {
			commande.ajouter(pizzaDao.getById(id));
		}
		commandeDao.sauver(commande);
		return commande;
	}

	public CommandePizza getRecap(Long idCommande) {
		return commandeDao.getRecapById(idCommande);
	}

	public CommandePizza getCommandeSuivante() throws PasDeCommandeSuivanteException {
		return commandeDao.getCommandeSuivante();
	}

	public List<CommandePizza> getCommandesEnAttente() {
		return commandeDao.getCommandesEnAttente();
	}

	@Transactional
	public void signalerCommandePrete(Long id) {
		commandeDao.signalerCommandePrete(id);
	}

}
