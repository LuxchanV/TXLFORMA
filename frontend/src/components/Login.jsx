import React, { useState } from "react";
import axios from "axios";
import "./Login.css"; // fichier CSS spécial connexion

export default function Login() {
  const [email, setEmail] = useState("");
  const [motDePasse, setMotDePasse] = useState("");
  const [showPassword, setShowPassword] = useState(false);
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
        setMessage("Connexion réussie !");
      } else {
        setMessage("Identifiants incorrects");
      }
    } catch (error) {
      console.error(error);
      setMessage("Erreur serveur");
    }
  };

  return (
    <div className="login-container">

      {/* GAUCHE */}
      <div className="left-section">

        <img src="/logoblanc.png" alt="logo" className="logo" />

        <form className="form" onSubmit={handleSubmit}>

          {/* Email */}
          <div className="input-group">
            <img src="/Email.png" className="icon" alt="email-icon" />
            <input
              type="email"
              placeholder="Example@gmail.com"
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>

          {/* Mot de passe */}
          <div className="input-group">
            <img src="/Lock.png" className="icon" alt="lock-icon" />

            <input
              type={showPassword ? "text" : "password"}
              placeholder="Mot de passe"
              onChange={(e) => setMotDePasse(e.target.value)}
              required
            />

            <img
              src={showPassword ? "/Eye.png" : "/CloseEye.png"}
              className="icon-eye"
              alt="toggle-password"
              onClick={() => setShowPassword(!showPassword)}
            />
          </div>

          <button className="btn-submit" type="submit">Se connecter</button>

          {message && <p className="message">{message}</p>}
        </form>

        <p className="register-text">
          Vous voulez vous inscrire ?
          <a href="/register"> S’inscrire</a>
        </p>

      </div>

      {/* DROITE */}
      <div className="right-section">
        <h1>Connexion</h1>
        <p>
          Simply dummy text of the printing and typesetting industry.
          Lorem Ipsum has been the industry’s standard dummy text ever since the 1500s.
          It has survived five centuries and remains widely used today.
        </p>
      </div>

    </div>
  );
}
