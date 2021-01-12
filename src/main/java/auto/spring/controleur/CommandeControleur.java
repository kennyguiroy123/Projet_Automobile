package auto.spring.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import auto.spring.modele.CommandePizza;
import auto.spring.service.CommandeDto;
import auto.spring.service.CommandeService;
import auto.spring.service.PizzaService;

@Controller
public class CommandeControleur {
	
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private CommandeService commandeService;

	@GetMapping("/commande")
	public String afficherFormulaireCommande(Model model, CommandeDto commandeDto) {
		model.addAttribute("pizzas", pizzaService.getListePizza());
		return "commande";
	}

	@PostMapping("/commande")
	public String commander(Model model, @Validated @ModelAttribute CommandeDto commandeDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return afficherFormulaireCommande(model, commandeDto);
		}
		CommandePizza commande = commandeService.commander(commandeDto);
		return "redirect:/recap-commande?id=" + commande.getId();
	}

	@GetMapping("/recap-commande")
	public String afficherRecapitulatif(Model model, @RequestParam long id) {
		model.addAttribute("commande", commandeService.getRecap(id));
		return "recap-commande";
	}
}
