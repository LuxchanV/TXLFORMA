package com.txlforma.backendsae501.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.txlforma.backendsae501.model.Formation;
import com.txlforma.backendsae501.repository.FormationRepository;

@RestController
@RequestMapping("/api/formations")
@CrossOrigin(origins = "*")
public class FormationController {

    @Autowired
    private FormationRepository formationRepository;

    @GetMapping
    public List<Formation> getAll() {
        return formationRepository.findAll();
    }

    @PostMapping
    public Formation create(@RequestBody Formation formation) {
        return formationRepository.save(formation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        formationRepository.deleteById(id);
    }
}
