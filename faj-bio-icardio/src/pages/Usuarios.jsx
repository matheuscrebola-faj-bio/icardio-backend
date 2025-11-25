import { useState } from 'react';
import { Link } from 'react-router-dom';

export default function Usuarios() {
  const [usuarios] = useState([
    {
      id: '1',
      nome: 'João',
      sobrenome: 'Silva',
      login: 'joao.silva',
      documento: '123.456.789-00',
      email: 'joao.silva@fajbio.com.br',
      telefone: '(11) 98765-4321',
      assinatura: 'Dr. João Silva - CRM 12345',
      perfil: 'MEDICO',
      criadoEm: '2024-01-01T10:00:00',
      atualizadoEm: '2024-01-15T14:30:00',
      ativo: true
    },
    {
      id: '2',
      nome: 'Maria',
      sobrenome: 'Costa',
      login: 'maria.costa',
      documento: '987.654.321-00',
      email: 'maria.costa@fajbio.com.br',
      telefone: '(11) 98765-1234',
      assinatura: 'Dra. Maria Costa - CRM 54321',
      perfil: 'MEDICO_ADM',
      criadoEm: '2024-01-05T09:00:00',
      atualizadoEm: '2024-01-10T16:00:00',
      ativo: true
    },
    {
      id: '3',
      nome: 'Pedro',
      sobrenome: 'Santos',
      login: 'pedro.santos',
      documento: '456.789.123-00',
      email: 'pedro.santos@fajbio.com.br',
      telefone: '(11) 98765-5678',
      assinatura: '',
      perfil: 'USUARIO',
      criadoEm: '2023-12-20T11:00:00',
      atualizadoEm: '2024-01-08T10:00:00',
      ativo: true
    },
    {
      id: '4',
      nome: 'Ana',
      sobrenome: 'Oliveira',
      login: 'ana.oliveira',
      documento: '321.654.987-00',
      email: 'ana.oliveira@fajbio.com.br',
      telefone: '(11) 98765-9999',
      assinatura: '',
      perfil: 'GERENTE',
      criadoEm: '2024-01-03T08:00:00',
      atualizadoEm: '2024-01-12T15:00:00',
      ativo: false
    },
  ]);

  const formatDate = (dateString) => {
    return new Date(dateString).toLocaleString('pt-BR');
  };

  const getPerfilLabel = (perfil) => {
    const labels = {
      'MEDICO': 'Médico',
      'USUARIO': 'Usuário',
      'MEDICO_ADM': 'Médico Admin',
      'ADMIN': 'Administrador',
      'GERENTE': 'Gerente'
    };
    return labels[perfil] || perfil;
  };

  const getPerfilBadge = (perfil) => {
    const classes = {
      'MEDICO': 'badge-success',
      'MEDICO_ADM': 'badge-success',
      'ADMIN': 'badge-pending',
      'GERENTE': 'badge-warning',
      'USUARIO': 'badge-warning'
    };
    return `badge ${classes[perfil] || ''}`;
  };

  const handleEdit = (id) => {
    alert(`Editar usuário ${id}`);
  };

  const handleDelete = (id) => {
    if (confirm('Deseja realmente excluir este usuário?')) {
      alert(`Usuário ${id} excluído`);
    }
  };

  return (
    <div className="container">
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '24px' }}>
        <h2 className="page-title" style={{ marginBottom: 0 }}>Usuários</h2>
        <Link to="/usuarios/novo" className="btn btn-primary">
          + Novo Usuário
        </Link>
      </div>

      <div className="card">
        <table>
          <thead>
            <tr>
              <th>Nome</th>
              <th>Login</th>
              <th>Documento</th>
              <th>Email</th>
              <th>Telefone</th>
              <th>Perfil</th>
              <th>Status</th>
              <th>Ações</th>
            </tr>
          </thead>
          <tbody>
            {usuarios.map(usuario => (
              <tr key={usuario.id}>
                <td style={{ fontWeight: 500 }}>
                  {usuario.nome} {usuario.sobrenome}
                </td>
                <td>{usuario.login}</td>
                <td>{usuario.documento}</td>
                <td>{usuario.email}</td>
                <td>{usuario.telefone}</td>
                <td>
                  <span className={getPerfilBadge(usuario.perfil)}>
                    {getPerfilLabel(usuario.perfil)}
                  </span>
                </td>
                <td>
                  <span className={usuario.ativo ? 'badge badge-success' : 'badge badge-warning'}>
                    {usuario.ativo ? 'Ativo' : 'Inativo'}
                  </span>
                </td>
                <td>
                  <div style={{ display: 'flex', gap: '8px' }}>
                    <button
                      className="btn btn-secondary btn-sm"
                      onClick={() => handleEdit(usuario.id)}
                    >
                      ✏️
                    </button>
                    <button
                      className="btn btn-secondary btn-sm"
                      onClick={() => handleDelete(usuario.id)}
                    >
                      🗑️
                    </button>
                  </div>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
