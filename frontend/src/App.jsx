import React from "react";
import { Routes, Route, Link } from "react-router-dom";
import Register from "./components/Register";
import Login from "./components/Login";

export default function App() {
  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h1>Plateforme de formation TXLFORMA</h1>
      <nav style={{ display: "flex", gap: "15px", marginBottom: "20px" }}>
        <Link to="/register">Inscription</Link>
        <Link to="/login">Connexion</Link>
      </nav>

      <Routes>
        <Route path="/" element={<h2>Bienvenue sur la plateformeeeee 🎓</h2>} />
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </div>
  );
}
