package presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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

	
}
