package com.txlforma.backendsae501.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "paiements")
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paiement;

    private float montant;

    @Temporal(TemporalType.DATE)
    private Date date_paiement;

    private String mode;
    private boolean statut;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    // 🔹 Constructeurs
    public Paiement() {}

    public Paiement(float montant, Date date_paiement, String mode, boolean statut) {
        this.montant = montant;
        this.date_paiement = date_paiement;
        this.mode = mode;
        this.statut = statut;
    }

    // 🔹 Getters et Setters
    public Long getId_paiement() { return id_paiement; }
    public void setId_paiement(Long id_paiement) { this.id_paiement = id_paiement; }

    public float getMontant() { return montant; }
    public void setMontant(float montant) { this.montant = montant; }

    public Date getDate_paiement() { return date_paiement; }
    public void setDate_paiement(Date date_paiement) { this.date_paiement = date_paiement; }

    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }

    public boolean isStatut() { return statut; }
    public void setStatut(boolean statut) { this.statut = statut; }

    public Utilisateur getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }

    public Session getSession() { return session; }
    public void setSession(Session session) { this.session = session; }
}
