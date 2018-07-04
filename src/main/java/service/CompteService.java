package service;

import dao.CompteRepository;
import domaine.Client;
import domaine.Compte;

public class CompteService extends CrudService<Compte> {
	

	private CompteRepository getRepo(){
		return (CompteRepository) this.repo;
	}
	
	public void deleteAllByClient(Client client){
		this.getRepo().deleteAllByClient(client);
	}

}
