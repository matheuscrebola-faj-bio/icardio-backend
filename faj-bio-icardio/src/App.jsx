import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { AuthProvider } from './context/AuthContext';
import ProtectedRoute from './components/ProtectedRoute';
import Layout from './components/Layout';
import Login from './pages/Login';
import Home from './pages/Home';
import NovoExame from './pages/NovoExame';
import Pacientes from './pages/Pacientes';
import Laudos from './pages/Laudos';
import Usuarios from './pages/Usuarios';
import NovoUsuario from './pages/NovoUsuario';
import Unidades from './pages/Unidades';
import NovaUnidade from './pages/NovaUnidade';

function App() {
  return (
    <AuthProvider>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login />} />
          
          <Route element={
            <ProtectedRoute>
              <Layout />
            </ProtectedRoute>
          }>
            <Route path="/home" element={<Home />} />
            <Route path="/novo-exame" element={<NovoExame />} />
            <Route path="/pacientes" element={<Pacientes />} />
            <Route path="/laudos" element={<Laudos />} />
            <Route path="/usuarios" element={<Usuarios />} />
            <Route path="/usuarios/novo" element={<NovoUsuario />} />
            <Route path="/unidades" element={<Unidades />} />
            <Route path="/unidades/novo" element={<NovaUnidade />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </AuthProvider>
  );
}

export default App;
