package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domaine.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {
	

}
