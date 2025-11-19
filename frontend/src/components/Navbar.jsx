import { Link } from "react-router-dom";

export default function Navbar() {
  return (
    <nav className="navbar navbar-dark bg-dark p-3">
      <Link className="navbar-brand" to="/">TXLForma</Link>
      <div>
        <Link className="btn btn-outline-light mx-2" to="/login">Connexion</Link>
        <Link className="btn btn-outline-light mx-2" to="/register">Inscription</Link>
      </div>
    </nav>
  );
}
