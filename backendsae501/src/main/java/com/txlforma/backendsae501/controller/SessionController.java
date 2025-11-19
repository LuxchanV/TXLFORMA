package com.txlforma.backendsae501.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.txlforma.backendsae501.model.Session;
import com.txlforma.backendsae501.repository.SessionRepository;

@RestController
@RequestMapping("/api/sessions")
@CrossOrigin(origins = "*")
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;

    // 🔹 GET - Récupérer toutes les sessions
    @GetMapping
    public List<Session> getAll() {
        return sessionRepository.findAll();
    }

    // 🔹 POST - Créer une session
    @PostMapping
    public Session create(@RequestBody Session session) {
        return sessionRepository.save(session);
    }

    // 🔹 DELETE - Supprimer une session
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sessionRepository.deleteById(id);
    }
}
