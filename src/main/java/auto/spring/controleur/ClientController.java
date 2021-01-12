package auto.spring.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import auto.spring.exception.PasDeProduitException;
import auto.spring.service.CommandeDto;
import auto.spring.service.CommandeService;
import auto.spring.service.ProduitService;

@Controller
public class ClientController {
	
	/*
	 * Page auth
	 * Page des produits
	 * Page de la commande
	 */
	
	@Autowired
	private ProduitService produitService;
	
	@Autowired
	private CommandeService commandeService;

	@GetMapping("/auth")
	public String afficherFormulaireAuth(Model model, CommandeDto commandeDto) throws PasDeProduitException {
		model.addAttribute("produits", produitService.getListeProduit());
		return "commande";
	}

	@GetMapping("/produits")
	public String afficherRecapitulatif(Model model, @RequestParam long id) {
		model.addAttribute("commande", commandeService.getRecap(id));
		return "recap-commande";
	}
}
