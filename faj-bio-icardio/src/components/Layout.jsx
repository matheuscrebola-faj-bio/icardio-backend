import { Link, useNavigate, Outlet } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';

export default function Layout() {
  const { logout } = useAuth();
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    navigate('/');
  };

  return (
    <div>
      <header className="header">
        <h1>FAJ BIO - iCardio</h1>
        <nav>
          <Link to="/home">Dashboard</Link>
          <Link to="/novo-exame">Novo Exame</Link>
          <Link to="/laudos">Laudos</Link>
          <Link to="/pacientes">Pacientes</Link>
          <Link to="/usuarios">Usuários</Link>
          <Link to="/unidades">Unidades</Link>
          <button className="logout-btn" onClick={handleLogout}>
            Sair
          </button>
        </nav>
      </header>
      <main>
        <Outlet />
      </main>
    </div>
  );
}
