package com.txlforma.backendsae501.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "formations")
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_formation;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(length = 255)
    private String description;

    private double tarif;

    // 🔹 Relation : Une formation appartient à une catégorie
    @ManyToOne
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;

    // 🔹 Relation : Une formation peut avoir plusieurs sessions
    @OneToMany(mappedBy = "formation", cascade = CascadeType.ALL)
    private List<Session> sessions;

    // --- Constructeurs ---
    public Formation() {}

    public Formation(String nom, String description, double tarif) {
        this.nom = nom;
        this.description = description;
        this.tarif = tarif;
    }

    // --- Getters & Setters ---
    public Long getId_formation() {
        return id_formation;
    }

    public void setId_formation(Long id_formation) {
        this.id_formation = id_formation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }
}
