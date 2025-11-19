package com.txlforma.backendsae501.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.txlforma.backendsae501.model.Evaluation;
import com.txlforma.backendsae501.repository.EvaluationRepository;

@RestController
@RequestMapping("/api/evaluations")
@CrossOrigin(origins = "*")
public class EvaluationController {

    @Autowired
    private EvaluationRepository evaluationRepository;

    // 🔹 GET - Récupérer toutes les évaluations
    @GetMapping
    public List<Evaluation> getAll() {
        return evaluationRepository.findAll();
    }

    // 🔹 POST - Ajouter une évaluation
    @PostMapping
    public Evaluation create(@RequestBody Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    // 🔹 DELETE - Supprimer une évaluation
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        evaluationRepository.deleteById(id);
    }
}
