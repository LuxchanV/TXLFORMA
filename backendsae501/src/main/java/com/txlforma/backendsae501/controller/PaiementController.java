package com.txlforma.backendsae501.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.txlforma.backendsae501.model.Paiement;
import com.txlforma.backendsae501.repository.PaiementRepository;

@RestController
@RequestMapping("/api/paiements")
@CrossOrigin(origins = "*")
public class PaiementController {

    @Autowired
    private PaiementRepository paiementRepository;

    // 🔹 GET - Récupérer tous les paiements
    @GetMapping
    public List<Paiement> getAll() {
        return paiementRepository.findAll();
    }

    // 🔹 POST - Ajouter un paiement
    @PostMapping
    public Paiement create(@RequestBody Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    // 🔹 DELETE - Supprimer un paiement
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        paiementRepository.deleteById(id);
    }
}
