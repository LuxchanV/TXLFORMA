package com.txlforma.backendsae501.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.txlforma.backendsae501.model.Inscription;
import com.txlforma.backendsae501.repository.InscriptionRepository;

@RestController
@RequestMapping("/api/inscriptions")
@CrossOrigin(origins = "*")
public class InscriptionController {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    // 🔹 GET - Récupérer toutes les inscriptions
    @GetMapping
    public List<Inscription> getAll() {
        return inscriptionRepository.findAll();
    }

    // 🔹 POST - Ajouter une inscription
    @PostMapping
    public Inscription create(@RequestBody Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    // 🔹 DELETE - Supprimer une inscription
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        inscriptionRepository.deleteById(id);
    }
}
