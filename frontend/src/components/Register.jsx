import React, { useState } from "react";
import axios from "axios";

export default function Register() {
  const [formData, setFormData] = useState({
    nom: "",
    prenom: "",
    email: "",
    motDePasse: "",
  });

  const [message, setMessage] = useState("");

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post("http://localhost:8080/api/utilisateurs", formData);
      setMessage("✅ Inscription réussie !");
    } catch (error) {
      console.error(error);
      setMessage("❌ Erreur lors de l'inscription");
    }
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Inscription</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="nom"
          placeholder="Nom"
          onChange={handleChange}
        />
        <input
          type="text"
          name="prenom"
          placeholder="Prénom"
          onChange={handleChange}
        />
        <input
          type="email"
          name="email"
          placeholder="Email"
          onChange={handleChange}
        />
        <input
          type="password"
          name="motDePasse"
          placeholder="Mot de passe"
          onChange={handleChange}
        />
        <button type="submit">S'inscrire</button>
      </form>

      {message && <p>{message}</p>}
    </div>
  );
}
