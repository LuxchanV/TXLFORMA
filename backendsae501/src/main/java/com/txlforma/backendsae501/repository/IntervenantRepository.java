package com.txlforma.backendsae501.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.txlforma.backendsae501.model.Intervenant;

@Repository
public interface IntervenantRepository extends JpaRepository<Intervenant, Long> {
}
