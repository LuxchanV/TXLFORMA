import React, { useState } from "react";
import axios from "axios";

export default function Login() {
  const [email, setEmail] = useState("");
  const [motDePasse, setMotDePasse] = useState("");
  const [message, setMessage] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await axios.get("http://localhost:8080/api/utilisateurs");
      const users = res.data;

      const found = users.find(
        (u) => u.email === email && u.motDePasse === motDePasse
      );

      if (found) {
        setMessage("✅ Connexion réussie !");
      } else {
        setMessage("❌ Identifiants incorrects");
      }
    } catch (error) {
      console.error(error);
      setMessage("❌ Erreur serveur");
    }
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Connexion</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="email"
          placeholder="Email"
          onChange={(e) => setEmail(e.target.value)}
        />
        <input
          type="password"
          placeholder="Mot de passe"
          onChange={(e) => setMotDePasse(e.target.value)}
        />
        <button type="submit">Se connecter</button>
      </form>

      {message && <p>{message}</p>}
    </div>
  );
}
