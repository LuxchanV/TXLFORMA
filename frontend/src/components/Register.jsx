import React, { useState } from "react";
import axios from "axios";
import "./Register.css";

export default function Register() {
  const [formData, setFormData] = useState({
    nom: "",
    prenom: "",
    email: "",
    motDePasse: "",
    telephone: ""
  });

  const [showPassword, setShowPassword] = useState(false);
  const [message, setMessage] = useState("");

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post("http://localhost:8080/api/utilisateurs", formData);
      setMessage("Inscription réussie !");
    } catch (error) {
      console.error(error);
      setMessage("Erreur lors de l'inscription");
    }
  };

  return (
    <div className="register-container">

      {/* GAUCHE */}
      <div className="left-section">

        <img src="/logoblanc.png" alt="logo" className="logo" />

        <form className="form" onSubmit={handleSubmit}>

          <div className="input-group">
            <img src="/TestAccount.png" className="icon" alt="user" />
            <input type="text" name="nom" placeholder="Nom" onChange={handleChange} required />
          </div>

          <div className="input-group">
            <img src="/TestAccount.png" className="icon" alt="user" />
            <input type="text" name="prenom" placeholder="Prénom" onChange={handleChange} required />
          </div>

          <div className="input-group">
            <img src="/Email.png" className="icon" alt="email" />
            <input type="email" name="email" placeholder="Example@gmail.com" onChange={handleChange} required />
          </div>

          <div className="input-group">
            <img src="/Lock.png" className="icon" alt="lock" />

            <input
              type={showPassword ? "text" : "password"}
              name="motDePasse"
              placeholder="Mot de passe"
              onChange={handleChange}
              required
            />

            <img
              src={showPassword ? "/Eye.png" : "/CloseEye.png"}
              className="icon-eye"
              alt="toggle password"
              onClick={() => setShowPassword(!showPassword)}
            />
          </div>

          <div className="input-group">
            <img src="/Phone.png" className="icon" alt="phone" />
            <input type="text" name="telephone" placeholder="Numéro de téléphone" onChange={handleChange} required />
          </div>

          <button className="btn-submit" type="submit">Créer mon compte</button>

          {message && <p className="message">{message}</p>}

        </form>

        <p className="login-text">
          Vous avez déjà un compte ?
          <a href="/login"> Se connecter</a>
        </p>

      </div>

      {/* DROITE */}
      <div className="right-section">
        <h1>Inscription</h1>
        <p>
          Simply dummy text of the printing and typesetting industry.
          Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.
          It has survived not only five centuries, but also the leap into electronic typesetting.
        </p>
      </div>

    </div>
  );
}
