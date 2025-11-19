package com.txlforma.backendsae501.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_session;

    @Temporal(TemporalType.DATE)
    private Date date_debut;

    @Temporal(TemporalType.DATE)
    private Date date_fin;

    private int nb_places;

    // --- Relations ---

    // Une session appartient à une formation
    @ManyToOne
    @JoinColumn(name = "id_formation")
    private Formation formation;

    // Une session peut être animée par un intervenant
    @ManyToOne
    @JoinColumn(name = "id_intervenant")
    private Intervenant intervenant;

    // Une session a plusieurs inscriptions
    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<Inscription> inscriptions;

    // Une session peut avoir plusieurs paiements
    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<Paiement> paiements;

    // Une session peut avoir plusieurs évaluations
    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<Evaluation> evaluations;

    // --- Constructeurs ---
    public Session() {}

    public Session(Date date_debut, Date date_fin, int nb_places) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.nb_places = nb_places;
    }

    // --- Getters / Setters ---
    public Long getId_session() {
        return id_session;
    }

    public void setId_session(Long id_session) {
        this.id_session = id_session;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public int getNb_places() {
        return nb_places;
    }

    public void setNb_places(int nb_places) {
        this.nb_places = nb_places;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public Intervenant getIntervenant() {
        return intervenant;
    }

    public void setIntervenant(Intervenant intervenant) {
        this.intervenant = intervenant;
    }

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }
}
