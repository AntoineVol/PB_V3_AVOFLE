package presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domaine.Client;
import domaine.Compte;
import service.ClientService;
import service.CompteCourantService;
import service.CompteEpargneService;
import service.CompteService;
import service.ConseilleService;

@Controller
public class IndexController {

	@Autowired
	ClientService clientService;

	@Autowired
	ConseilleService conseilleService;
	
	@Autowired
	CompteCourantService compteCourantService;

	@Autowired
	CompteEpargneService compteEpargneService;
	
	@Autowired
	CompteService compteService;

	
	
	@GetMapping("/listeClients")
	public ModelAndView index(){
		final ModelAndView mav = new ModelAndView("listeClients");
		mav.getModel().put("listClient", this.clientService.getAll());
		mav.getModel().put("modelClient", new Client());
		return mav;
	}
	
	@PostMapping("/listeClients")
	public String createClient(@ModelAttribute Client client){
		this.clientService.create(client);
		return "redirect:/listeClients.html";
	}
	

	@GetMapping("/deleteClient")
	public String deleteClient(@RequestParam Integer idDeleted){
		Client client = this.clientService.getById(idDeleted);
		this.compteService.deleteAllByClient(client);
		this.clientService.deleteById(idDeleted);
		return "redirect:/listeClients.html";
	}

	@GetMapping("/clientEdition")
	public ModelAndView editClient (@RequestParam Integer idClient) {
		ModelAndView mav = new ModelAndView("clientEdition");
		mav.addObject("modelClient", this.clientService.getById(idClient));
		return mav;
	}
	
	@PostMapping("/clientEdition")
	public String validateClient(@ModelAttribute Client modelClient) {
		this.clientService.update(modelClient);
		return "redirect:/listeClients.html";
	}
	
	@GetMapping("/virements")
	public ModelAndView virement(@RequestParam Integer idClient) {
		ModelAndView mav = new ModelAndView("virements");
		Client client = this.clientService.getById(idClient);
		mav.addObject("client", client);
		mav.addObject("listCompteCourant", this.compteCourantService.getAllByClient(client));
		mav.addObject("listCompteEpargne", this.compteEpargneService.getAllByClient(client));
		mav.addObject("listCompte", this.compteService.getAllByClient(client));
		return mav;
	}
	@PostMapping("/virements")
	public String validerVirement(@RequestParam String compteDebiter, @RequestParam String compteCrediter, @RequestParam Double montant, @RequestParam Integer idClient) {
		String[] debit = compteDebiter.split("##");
		String[] credit = compteCrediter.split("##");
		Compte compteDebite = this.compteService.getById(Integer.parseInt(debit[0]));
		Compte compteCredite = this.compteService.getById(Integer.parseInt(credit[0]));
		compteDebite.setSolde(compteDebite.getSolde()-montant);
		compteCredite.setSolde(compteCredite.getSolde()+montant);
		this.compteService.update(compteDebite);
		this.compteService.update(compteCredite);
		return "redirect:/virements.html?idClient="+idClient;
	}

}
