package service;

import java.util.List;

import dao.CompteRepository;
import domaine.Client;
import domaine.Compte;
import domaine.CompteCourant;

public class CompteService extends CrudService<Compte> {
	

	private CompteRepository getRepo(){
		return (CompteRepository) this.repo;
	}
	
	public void deleteAllByClient(Client client){
		this.getRepo().deleteAllByClient(client);
	}
	public List<Compte> getAllByClient(Client client){
		return this.getRepo().getAllByClient(client);
		
	}
}
