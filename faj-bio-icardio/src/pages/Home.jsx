import { Link } from 'react-router-dom';

export default function Home() {
  // Dados simulados expandidos
  const stats = {
    laudados: 127,
    paraLaudar: 15,
    pacientesMes: 89,
    examesHoje: 8,
    mediaDiaria: 12,
    usuariosAtivos: 24,
    unidadesAtivas: 3
  };

  const examesPendentes = [
    { id: 101, paciente: 'Maria Silva', data: '2024-11-25 09:30', prioridade: 'alta' },
    { id: 102, paciente: 'João Santos', data: '2024-11-25 10:15', prioridade: 'normal' },
    { id: 103, paciente: 'Ana Costa', data: '2024-11-25 11:00', prioridade: 'alta' },
    { id: 104, paciente: 'Pedro Oliveira', data: '2024-11-25 14:30', prioridade: 'normal' },
    { id: 105, paciente: 'Carla Souza', data: '2024-11-24 16:45', prioridade: 'urgente' }
  ];

  const atividadesRecentes = [
    { tipo: 'laudo', descricao: 'Laudo #127 finalizado', hora: '14:30', usuario: 'Dr. João Silva' },
    { tipo: 'exame', descricao: 'Novo exame cadastrado', hora: '13:45', usuario: 'Recepção' },
    { tipo: 'laudo', descricao: 'Laudo #126 finalizado', hora: '12:20', usuario: 'Dra. Maria Costa' },
    { tipo: 'paciente', descricao: 'Paciente cadastrado', hora: '11:00', usuario: 'Recepção' }
  ];

  const getPrioridadeBadge = (prioridade) => {
    const classes = {
      'urgente': 'badge-pending',
      'alta': 'badge-warning',
      'normal': 'badge-success'
    };
    return `badge ${classes[prioridade]}`;
  };

  const getPrioridadeLabel = (prioridade) => {
    return prioridade.charAt(0).toUpperCase() + prioridade.slice(1);
  };

  const getTipoIcon = (tipo) => {
    const icons = {
      'laudo': '📋',
      'exame': '🔬',
      'paciente': '👤'
    };
    return icons[tipo] || '•';
  };

  return (
    <div className="container">
      <div style={{ marginBottom: '32px' }}>
        <h2 className="page-title" style={{ marginBottom: '8px' }}>Dashboard</h2>
        <p style={{ color: 'var(--text-muted)', fontSize: '14px' }}>
          Visão geral do sistema - {new Date().toLocaleDateString('pt-BR', { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' })}
        </p>
      </div>

      {/* Estatísticas Principais */}
      <div className="grid-3" style={{ marginBottom: '32px' }}>
        <div className="stat-card">
          <h3>{stats.laudados}</h3>
          <p>Exames Laudados</p>
          <small style={{ color: 'var(--text-muted)', fontSize: '12px' }}>Total no mês</small>
        </div>
        
        <div className="stat-card">
          <h3>{stats.paraLaudar}</h3>
          <p>Exames Pendentes</p>
          <small style={{ color: 'var(--primary)', fontSize: '12px', fontWeight: 500 }}>Requer atenção</small>
        </div>
        
        <div className="stat-card">
          <h3>{stats.pacientesMes}</h3>
          <p>Pacientes no Mês</p>
          <small style={{ color: 'var(--text-muted)', fontSize: '12px' }}>Novembro 2024</small>
        </div>
      </div>

      {/* Estatísticas Secundárias */}
      <div className="grid-3" style={{ marginBottom: '32px' }}>
        <div className="stat-card" style={{ background: '#fff5f7' }}>
          <h3 style={{ fontSize: '28px', color: 'var(--text)' }}>{stats.examesHoje}</h3>
          <p style={{ fontSize: '13px' }}>Exames Hoje</p>
        </div>
        
        <div className="stat-card" style={{ background: '#fff5f7' }}>
          <h3 style={{ fontSize: '28px', color: 'var(--text)' }}>{stats.mediaDiaria}</h3>
          <p style={{ fontSize: '13px' }}>Média Diária</p>
        </div>

        <div className="stat-card" style={{ background: '#fff5f7' }}>
          <h3 style={{ fontSize: '28px', color: 'var(--text)' }}>{stats.usuariosAtivos}</h3>
          <p style={{ fontSize: '13px' }}>Usuários Ativos</p>
        </div>
      </div>

      {/* Grid com duas colunas */}
      <div className="grid-2" style={{ marginBottom: '32px', alignItems: 'start' }}>
        {/* Exames Pendentes */}
        <div className="card">
          <h3 style={{ fontSize: '16px', marginBottom: '16px', display: 'flex', alignItems: 'center', gap: '8px' }}>
            ⏰ Exames Pendentes de Laudo
          </h3>
          <div style={{ maxHeight: '280px', overflowY: 'auto' }}>
            {examesPendentes.map(exame => (
              <div 
                key={exame.id} 
                style={{ 
                  padding: '12px', 
                  borderBottom: '1px solid var(--border)',
                  display: 'flex',
                  justifyContent: 'space-between',
                  alignItems: 'center'
                }}
              >
                <div>
                  <div style={{ fontWeight: 500, marginBottom: '4px' }}>
                    #{exame.id} - {exame.paciente}
                  </div>
                  <div style={{ fontSize: '12px', color: 'var(--text-muted)' }}>
                    {exame.data}
                  </div>
                </div>
                <span className={getPrioridadeBadge(exame.prioridade)}>
                  {getPrioridadeLabel(exame.prioridade)}
                </span>
              </div>
            ))}
          </div>
          <Link 
            to="/laudos" 
            style={{ 
              display: 'block', 
              textAlign: 'center', 
              marginTop: '12px',
              color: 'var(--primary)',
              textDecoration: 'none',
              fontSize: '14px',
              fontWeight: 500
            }}
          >
            Ver todos os laudos →
          </Link>
        </div>

        {/* Atividades Recentes */}
        <div className="card">
          <h3 style={{ fontSize: '16px', marginBottom: '16px', display: 'flex', alignItems: 'center', gap: '8px' }}>
            📊 Atividades Recentes
          </h3>
          <div style={{ maxHeight: '280px', overflowY: 'auto' }}>
            {atividadesRecentes.map((atividade, index) => (
              <div 
                key={index}
                style={{ 
                  padding: '12px', 
                  borderBottom: index < atividadesRecentes.length - 1 ? '1px solid var(--border)' : 'none',
                  display: 'flex',
                  gap: '12px'
                }}
              >
                <div style={{ fontSize: '20px' }}>{getTipoIcon(atividade.tipo)}</div>
                <div style={{ flex: 1 }}>
                  <div style={{ fontWeight: 500, marginBottom: '4px', fontSize: '14px' }}>
                    {atividade.descricao}
                  </div>
                  <div style={{ fontSize: '12px', color: 'var(--text-muted)' }}>
                    {atividade.hora} - {atividade.usuario}
                  </div>
                </div>
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
}
