package com.txlforma.backendsae501.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "inscriptions")
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_inscription;

    @Temporal(TemporalType.DATE)
    private Date date_inscription;

    private String statut;

    // 🔹 Relations
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    // 🔹 Constructeurs
    public Inscription() {}

    public Inscription(Date date_inscription, String statut) {
        this.date_inscription = date_inscription;
        this.statut = statut;
    }

    // 🔹 Getters / Setters
    public Long getId_inscription() { return id_inscription; }
    public void setId_inscription(Long id_inscription) { this.id_inscription = id_inscription; }

    public Date getDate_inscription() { return date_inscription; }
    public void setDate_inscription(Date date_inscription) { this.date_inscription = date_inscription; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public Utilisateur getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }

    public Session getSession() { return session; }
    public void setSession(Session session) { this.session = session; }
}
