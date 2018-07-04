package presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domaine.Client;
import service.ClientService;
import service.CompteCourantService;
import service.CompteEpargneService;
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

	@GetMapping("/Acceuil/Edition")
	public ModelAndView editClient (@RequestParam Integer idClient) {
		ModelAndView mav = new ModelAndView("clientEdition");
		mav.addObject("modelClient", this.clientService.getById(idClient));
		return mav;
	}
	
	@PostMapping("/Acceuil/Edition")
	public String validateClient(@ModelAttribute Client modelClient) {
		this.clientService.update(modelClient);
		return "redirect:/Acceuil.html";
	}
	
	
	@RequestMapping("/listeClients")
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

}
