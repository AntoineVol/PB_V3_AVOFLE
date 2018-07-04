package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domaine.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	
}
