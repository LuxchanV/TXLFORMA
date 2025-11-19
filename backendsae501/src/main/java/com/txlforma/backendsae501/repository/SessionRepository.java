package com.txlforma.backendsae501.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.txlforma.backendsae501.model.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
}
