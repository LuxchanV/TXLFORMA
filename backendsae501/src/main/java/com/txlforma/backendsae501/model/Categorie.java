package com.txlforma.backendsae501.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categorie;

    private String nom;
    private String type;

    // Une catégorie peut contenir plusieurs formations
    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    private List<Formation> formations;

    // --- Constructeurs ---
    public Categorie() {}

    public Categorie(String nom, String type) {
        this.nom = nom;
        this.type = type;
    }

    // --- Getters et Setters ---
    public Long getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(Long id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Formation> getFormations() {
        return formations;
    }

    public void setFormations(List<Formation> formations) {
        this.formations = formations;
    }
}
