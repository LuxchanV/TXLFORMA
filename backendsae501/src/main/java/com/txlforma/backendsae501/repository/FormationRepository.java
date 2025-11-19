package com.txlforma.backendsae501.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.txlforma.backendsae501.model.Formation;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {

    // Exemple de requête personnalisée :
    Formation findByNom(String nom);
}
