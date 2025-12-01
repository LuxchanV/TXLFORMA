// src/components/Home.jsx
import React, { useState, useEffect, useRef } from "react";
import { useNavigate } from "react-router-dom";
import "./Home.css";

export default function Home() {
  const navigate = useNavigate();

  /* ----------------------------------------
       ANIMATION COMPTEURS (STATS)
  ----------------------------------------- */
  const statsRef = useRef(null);

  useEffect(() => {
    const stats = document.querySelectorAll(".stat-number");
    let started = false;

    const observer = new IntersectionObserver((entries) => {
      if (entries[0].isIntersecting && !started) {
        started = true;

        stats.forEach((stat) => {
          const target = parseInt(stat.dataset.value, 10);
          let count = 0;
          const step = target / 80;

          const timer = setInterval(() => {
            count += step;
            if (count >= target) {
              clearInterval(timer);
              stat.textContent = target + stat.dataset.suffix;
            } else {
              stat.textContent = Math.floor(count) + stat.dataset.suffix;
            }
          }, 20);
        });
      }
    });

    if (statsRef.current) observer.observe(statsRef.current);
    return () => observer.disconnect();
  }, []);

  /* ----------------------------------------
       FORMATIONS — SLIDER PRO
  ----------------------------------------- */
  const formations = [
    { id: 1, title: "Développement Front-End", text: "Maîtrise HTML, CSS, JavaScript et React.", icon: "💻" },
    { id: 2, title: "Développement Back-End", text: "Java Spring, API, MySQL, Node.js.", icon: "🛠️" },
    { id: 3, title: "Cybersécurité", text: "Sécurité réseau, attaques et protections.", icon: "🔐" },
    { id: 4, title: "UX/UI Design", text: "Prototypes, personas, maquettes Figma.", icon: "🎨" },
    { id: 5, title: "Data & IA", text: "Python, Machine Learning, DataViz.", icon: "🤖" },
    { id: 6, title: "Gestion de projet", text: "Méthodes Agile, Scrum et Kanban.", icon: "📊" },
  ];

  const sliderRef = useRef(null);
  const scrollNext = () => sliderRef.current.scrollBy({ left: 330, behavior: "smooth" });
  const scrollPrev = () => sliderRef.current.scrollBy({ left: -330, behavior: "smooth" });

  /* ----------------------------------------
       AVIS — SLIDER PRO (2 cartes visibles)
  ----------------------------------------- */
  const testimonials = [
    {
      id: 1,
      title: "Une plateforme vraiment incroyable",
      author: "Sarah M.",
      text: "Je me sens enfin à l’aise avec le numérique, tout est bien structuré.",
      image: "https://images.pexels.com/photos/1181686/pexels-photo-1181686.jpeg",
      avatar: "https://randomuser.me/api/portraits/women/65.jpg",
      views: "244 000",
    },
    {
      id: 2,
      title: "Je recommande de fou",
      author: "Bilal",
      text: "Les formateurs sont disponibles et le suivi est vraiment top.",
      image: "https://images.pexels.com/photos/1181524/pexels-photo-1181524.jpeg",
      avatar: "https://randomuser.me/api/portraits/men/71.jpg",
      views: "203 587",
    },
    {
      id: 3,
      title: "Les cours front-end sont incroyables",
      author: "Lina",
      text: "J'ai enfin compris JavaScript grâce aux explications super claires.",
      image: "https://images.pexels.com/photos/1181352/pexels-photo-1181352.jpeg",
      avatar: "https://randomuser.me/api/portraits/women/44.jpg",
      views: "251 232",
    },
    {
      id: 4,
      title: "Moi j’aime bieeen heeein",
      author: "Yanis",
      text: "L’ambiance est grave cool et les projets ressemblent à des vrais cas concrets.",
      image: "https://images.pexels.com/photos/1181675/pexels-photo-1181675.jpeg",
      avatar: "https://randomuser.me/api/portraits/men/32.jpg",
      views: "189 420",
    },
  ];

  const [testimonialIndex] = useState(0);
  const testimonialsRef = useRef(null);

  const nextTestimonials = () =>
    testimonialsRef.current.scrollBy({ left: 520, behavior: "smooth" });

  const prevTestimonials = () =>
    testimonialsRef.current.scrollBy({ left: -520, behavior: "smooth" });

  /* ----------------------------------------
       SCROLL TO FORMATIONS
  ----------------------------------------- */
  const scrollToFormations = () => {
    document.getElementById("formations-section")?.scrollIntoView({ behavior: "smooth" });
  };

  /* ----------------------------------------
       RENDER INTERFACE
  ----------------------------------------- */
  return (
    <div className="home">

      {/* NAVBAR */}
      <header className="navbar">
        <div className="nav-left">
          <img src="/logonoir.png" className="nav-logo" alt="logo" />
        </div>

        <nav className="nav-center">
          <button onClick={scrollToFormations}>Formations</button>
          <a href="#contact-section">Contact</a>
          <a href="#about-section">À propos</a>
        </nav>

        <div className="nav-right">
          <button className="nav-login" onClick={() => navigate("/login")}>Login</button>
          <button className="nav-signup" onClick={() => navigate("/register")}>Sign Up</button>
        </div>
      </header>

      {/* HERO */}
      <section className="hero">
        <div className="hero-left">
          <h1>Découvrez nos<br /><span>formations digitales</span></h1>
          <p className="hero-text">
            TXL FORMA est une plateforme moderne dédiée à l’apprentissage interactif.
          </p>
          <button className="hero-btn" onClick={scrollToFormations}>Commencer</button>
        </div>

        <div className="hero-right">
          <div className="hero-circle">
            <img src="/fillehome.png" className="hero-image" />
          </div>
        </div>
      </section>

      {/* STATS */}
      <section className="stats-section" ref={statsRef}>
        <div className="stats-header">
          <h2>Notre succès</h2>
          <p>Une plateforme moderne, complète et efficace pour te former rapidement.</p>
        </div>

        <div className="stats-grid">
          <div className="stat-box"><span className="stat-number" data-value="15000" data-suffix="+">0</span><span className="stat-label">Étudiants</span></div>
          <div className="stat-box"><span className="stat-number" data-value="95" data-suffix="%">0</span><span className="stat-label">Taux de satisfaction</span></div>
          <div className="stat-box"><span className="stat-number" data-value="35" data-suffix="">0</span><span className="stat-label">Formations</span></div>
          <div className="stat-box"><span className="stat-number" data-value="27" data-suffix="">0</span><span className="stat-label">Experts</span></div>
        </div>
      </section>

      {/* FORMATIONS */}
      <section className="formations-section" id="formations-section">
        <h2>Toutes les formations <span className="txl-green">TXL FORMA</span></h2>
        <p className="formations-subtitle">Une sélection de compétences essentielles pour maîtriser le digital.</p>

        {/* FLÈCHES */}
        <button className="formations-arrow left" onClick={scrollPrev}>‹</button>
        <button className="formations-arrow right" onClick={scrollNext}>›</button>

        <div className="formations-slider" ref={sliderRef}>
          {formations.map(f => (
            <div key={f.id} className="formation-card">
              <div className="formation-icon">{f.icon}</div>
              <h3>{f.title}</h3>
              <p>{f.text}</p>
              <button className="formation-btn">Découvrir</button>
            </div>
          ))}
        </div>
      </section>

      {/* AVIS — SLIDER PRO */}
      <section className="testimonials-section" id="about-section">
        <h2 className="testimonials-title">Ils nous font confiance</h2>

        {/* Flèches pro (comme formations) */}
        <button className="testimonials-arrow left" onClick={prevTestimonials}>‹</button>
        <button className="testimonials-arrow right" onClick={nextTestimonials}>›</button>

        <div className="testimonials-slider" ref={testimonialsRef}>
          {testimonials.map(t => (
            <div key={t.id} className="testimonial-card">
              <div className="testimonial-image-wrapper">
                <img src={t.image} className="testimonial-image" />
              </div>

              <h3 className="testimonial-title">{t.title}</h3>

              <div className="testimonial-author">
                <img src={t.avatar} className="testimonial-avatar" />
                <span>{t.author}</span>
              </div>

              <p className="testimonial-text">{t.text}</p>

              <div className="testimonial-footer">
                <span className="stars">★★★★★</span>
                <span className="views">{t.views} vues</span>
              </div>
            </div>
          ))}
        </div>
      </section>

      {/* CONTACT */}
      <section className="contact-section" id="contact-section">
        <h2>Contact</h2>
        <p>Besoin d’aide ? Notre équipe te répond rapidement.</p>
        <button className="contact-btn">Nous contacter</button>
      </section>

      {/* FOOTER */}
      <footer className="footer">
        <p>© 2025 TXL FORMA — Tous droits réservés</p>
      </footer>
    </div>
  );
}
