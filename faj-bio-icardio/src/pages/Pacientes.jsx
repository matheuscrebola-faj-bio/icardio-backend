import { useState } from 'react';

export default function Pacientes() {
  // Dados simulados
  const [pacientes] = useState([
    { id: 1, nome: 'Maria Silva', dataExame: '2024-01-15', dataLaudo: '2024-01-16', status: 'Laudado' },
    { id: 2, nome: 'João Santos', dataExame: '2024-01-14', dataLaudo: '2024-01-15', status: 'Laudado' },
    { id: 3, nome: 'Ana Costa', dataExame: '2024-01-14', dataLaudo: null, status: 'Pendente' },
    { id: 4, nome: 'Pedro Oliveira', dataExame: '2024-01-13', dataLaudo: '2024-01-14', status: 'Laudado' },
    { id: 5, nome: 'Carla Souza', dataExame: '2024-01-13', dataLaudo: null, status: 'Em análise' },
    { id: 6, nome: 'Lucas Ferreira', dataExame: '2024-01-12', dataLaudo: '2024-01-13', status: 'Laudado' },
  ]);

  const formatDate = (date) => {
    if (!date) return '-';
    return new Date(date).toLocaleDateString('pt-BR');
  };

  const getStatusBadge = (status) => {
    const classes = {
      'Laudado': 'badge-success',
      'Pendente': 'badge-pending',
      'Em análise': 'badge-warning'
    };
    return `badge ${classes[status] || ''}`;
  };

  const handleDownload = (id) => {
    // Simula download do PDF
    alert(`Baixando laudo do paciente ID: ${id}`);
  };

  return (
    <div className="container">
      <h2 className="page-title">Pacientes</h2>
      
      <div className="card">
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Nome</th>
              <th>Data Exame</th>
              <th>Data Laudo</th>
              <th>Status</th>
              <th>Ação</th>
            </tr>
          </thead>
          <tbody>
            {pacientes.map(paciente => (
              <tr key={paciente.id}>
                <td>{paciente.id}</td>
                <td>{paciente.nome}</td>
                <td>{formatDate(paciente.dataExame)}</td>
                <td>{formatDate(paciente.dataLaudo)}</td>
                <td>
                  <span className={getStatusBadge(paciente.status)}>
                    {paciente.status}
                  </span>
                </td>
                <td>
                  <button
                    className="btn btn-secondary btn-sm"
                    onClick={() => handleDownload(paciente.id)}
                    disabled={paciente.status !== 'Laudado'}
                  >
                    📄 Baixar PDF
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
