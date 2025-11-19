package com.txlforma.backendsae501.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.txlforma.backendsae501.model.Paiement;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}
