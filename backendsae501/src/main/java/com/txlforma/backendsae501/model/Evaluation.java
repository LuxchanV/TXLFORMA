package com.txlforma.backendsae501.model;

import jakarta.persistence.*;

@Entity
@Table(name = "evaluations")
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_evaluation;

    private float note;
    private String attestation_pdf;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    // 🔹 Constructeurs
    public Evaluation() {}

    public Evaluation(float note, String attestation_pdf) {
        this.note = note;
        this.attestation_pdf = attestation_pdf;
    }

    // 🔹 Getters / Setters
    public Long getId_evaluation() { return id_evaluation; }
    public void setId_evaluation(Long id_evaluation) { this.id_evaluation = id_evaluation; }

    public float getNote() { return note; }
    public void setNote(float note) { this.note = note; }

    public String getAttestation_pdf() { return attestation_pdf; }
    public void setAttestation_pdf(String attestation_pdf) { this.attestation_pdf = attestation_pdf; }

    public Utilisateur getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }

    public Session getSession() { return session; }
    public void setSession(Session session) { this.session = session; }
}
