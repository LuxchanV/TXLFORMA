package com.txlforma.backendsae501.model;

import jakarta.persistence.*;

@Entity
@Table(name = "intervenants")
public class Intervenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_intervenant;

    private String nom;
    private String specialite;
    private String statut;
    private float heures_realisees;

    // Constructeurs
    public Intervenant() {}

    public Intervenant(String nom, String specialite, String statut, float heures_realisees) {
        this.nom = nom;
        this.specialite = specialite;
        this.statut = statut;
        this.heures_realisees = heures_realisees;
    }

    // Getters et Setters
    public Long getId_intervenant() { return id_intervenant; }
    public void setId_intervenant(Long id_intervenant) { this.id_intervenant = id_intervenant; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getSpecialite() { return specialite; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public float getHeures_realisees() { return heures_realisees; }
    public void setHeures_realisees(float heures_realisees) { this.heures_realisees = heures_realisees; }
}
