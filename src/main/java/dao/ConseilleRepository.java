package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domaine.Conseille;

@Repository
public interface ConseilleRepository extends JpaRepository<Conseille, Integer>{


	
}
