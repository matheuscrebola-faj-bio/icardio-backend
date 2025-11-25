import { useState } from 'react';
import { Link } from 'react-router-dom';

export default function Unidades() {
  const [unidades] = useState([
    {
      id: '1',
      nome: 'Clínica Central',
      apelido: 'Central',
      cnpj: '12.345.678/0001-90',
      cidade: 'São Paulo',
      estado: 'SP',
      endereco: 'Av. Paulista, 1000',
      contato: 'Dr. Silva',
      email: 'central@fajbio.com.br',
      telefone: '(11) 3000-0000',
      usuarios: [],
      criadoEm: '2024-01-01T10:00:00',
      atualizadoEm: '2024-01-15T14:30:00',
      ativo: true
    },
    {
      id: '2',
      nome: 'Unidade Zona Norte',
      apelido: 'Zona Norte',
      cnpj: '23.456.789/0001-01',
      cidade: 'São Paulo',
      estado: 'SP',
      endereco: 'Rua das Flores, 500',
      contato: 'Dra. Costa',
      email: 'zonanorte@fajbio.com.br',
      telefone: '(11) 3100-0000',
      usuarios: [],
      criadoEm: '2024-01-05T09:00:00',
      atualizadoEm: '2024-01-10T16:00:00',
      ativo: true
    },
    {
      id: '3',
      nome: 'Unidade Campinas',
      apelido: 'Campinas',
      cnpj: '34.567.890/0001-12',
      cidade: 'Campinas',
      estado: 'SP',
      endereco: 'Av. Brasil, 200',
      contato: 'Dr. Santos',
      email: 'campinas@fajbio.com.br',
      telefone: '(19) 3200-0000',
      usuarios: [],
      criadoEm: '2023-12-15T11:00:00',
      atualizadoEm: '2024-01-12T10:00:00',
      ativo: false
    },
  ]);

  const formatDate = (dateString) => {
    return new Date(dateString).toLocaleString('pt-BR');
  };

  const handleEdit = (id) => {
    alert(`Editar unidade ${id}`);
  };

  const handleDelete = (id) => {
    if (confirm('Deseja realmente excluir esta unidade?')) {
      alert(`Unidade ${id} excluída`);
    }
  };

  return (
    <div className="container">
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '24px' }}>
        <h2 className="page-title" style={{ marginBottom: 0 }}>Unidades</h2>
        <Link to="/unidades/novo" className="btn btn-primary">
          + Nova Unidade
        </Link>
      </div>

      <div className="card">
        <table>
          <thead>
            <tr>
              <th>Nome</th>
              <th>Apelido</th>
              <th>CNPJ</th>
              <th>Cidade/Estado</th>
              <th>Contato</th>
              <th>Email</th>
              <th>Telefone</th>
              <th>Status</th>
              <th>Ações</th>
            </tr>
          </thead>
          <tbody>
            {unidades.map(unidade => (
              <tr key={unidade.id}>
                <td style={{ fontWeight: 500 }}>{unidade.nome}</td>
                <td>{unidade.apelido}</td>
                <td>{unidade.cnpj}</td>
                <td>{unidade.cidade}/{unidade.estado}</td>
                <td>{unidade.contato}</td>
                <td>{unidade.email}</td>
                <td>{unidade.telefone}</td>
                <td>
                  <span className={unidade.ativo ? 'badge badge-success' : 'badge badge-warning'}>
                    {unidade.ativo ? 'Ativo' : 'Inativo'}
                  </span>
                </td>
                <td>
                  <div style={{ display: 'flex', gap: '8px' }}>
                    <button
                      className="btn btn-secondary btn-sm"
                      onClick={() => handleEdit(unidade.id)}
                    >
                      ✏️
                    </button>
                    <button
                      className="btn btn-secondary btn-sm"
                      onClick={() => handleDelete(unidade.id)}
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
