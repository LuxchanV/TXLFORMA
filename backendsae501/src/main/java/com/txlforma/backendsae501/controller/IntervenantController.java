package com.txlforma.backendsae501.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.txlforma.backendsae501.model.Intervenant;
import com.txlforma.backendsae501.repository.IntervenantRepository;

@RestController
@RequestMapping("/api/intervenants")
@CrossOrigin(origins = "*")
public class IntervenantController {

    private final IntervenantRepository intervenantRepository;

    @Autowired
    public IntervenantController(IntervenantRepository intervenantRepository) {
        this.intervenantRepository = intervenantRepository;
    }

    // 🔹 GET - Récupérer tous les intervenants
    @GetMapping
    public List<Intervenant> getAll() {
        return intervenantRepository.findAll();
    }

    // 🔹 POST - Ajouter un intervenant
    @PostMapping
    public Intervenant create(@RequestBody Intervenant intervenant) {
        return intervenantRepository.save(intervenant);
    }

    // 🔹 DELETE - Supprimer un intervenant
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        intervenantRepository.deleteById(id);
    }
}
