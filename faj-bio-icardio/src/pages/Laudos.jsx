import { useState } from 'react';

export default function Laudos() {
  const [laudos] = useState([
    { id: 1, data: '2024-01-16', paciente: 'Maria Silva' },
    { id: 2, data: '2024-01-15', paciente: 'João Santos' },
    { id: 3, data: '2024-01-14', paciente: 'Pedro Oliveira' },
    { id: 4, data: '2024-01-13', paciente: 'Lucas Ferreira' },
  ]);

  const [modalOpen, setModalOpen] = useState(false);
  const [laudoSelecionado, setLaudoSelecionado] = useState(null);
  const [ondas, setOndas] = useState({
    P: { inicio: '', fim: '' },
    Q: { inicio: '', fim: '' },
    R: { inicio: '', fim: '' },
    S: { inicio: '', fim: '' },
    T: { inicio: '', fim: '' }
  });

  const formatDate = (date) => {
    return new Date(date).toLocaleDateString('pt-BR');
  };

  const handleOpenModal = (laudo) => {
    setLaudoSelecionado(laudo);
    setModalOpen(true);
  };

  const handleCloseModal = () => {
    setModalOpen(false);
    setLaudoSelecionado(null);
    setOndas({
      P: { inicio: '', fim: '' },
      Q: { inicio: '', fim: '' },
      R: { inicio: '', fim: '' },
      S: { inicio: '', fim: '' },
      T: { inicio: '', fim: '' }
    });
  };

  const handleOndaChange = (onda, campo, valor) => {
    setOndas(prev => ({
      ...prev,
      [onda]: { ...prev[onda], [campo]: valor }
    }));
  };

  const handleSave = () => {
    console.log('Salvando laudo:', laudoSelecionado, 'Ondas:', ondas);
    alert('Laudo salvo com sucesso!');
    handleCloseModal();
  };

  // Gerar pontos do ECG simulado
  const generateECGPath = () => {
    const width = 800;
    const height = 160;
    const baseline = height / 2;
    let path = `M 0 ${baseline}`;
    
    for (let i = 0; i < 10; i++) {
      const x = i * 80;
      // P wave
      path += ` L ${x + 10} ${baseline}`;
      path += ` Q ${x + 15} ${baseline - 15} ${x + 20} ${baseline}`;
      // PR segment
      path += ` L ${x + 25} ${baseline}`;
      // Q wave
      path += ` L ${x + 28} ${baseline + 8}`;
      // R wave
      path += ` L ${x + 32} ${baseline - 50}`;
      // S wave
      path += ` L ${x + 36} ${baseline + 15}`;
      // ST segment
      path += ` L ${x + 45} ${baseline}`;
      // T wave
      path += ` Q ${x + 55} ${baseline - 20} ${x + 65} ${baseline}`;
      // baseline
      path += ` L ${x + 80} ${baseline}`;
    }
    
    return path;
  };

  return (
    <div className="container">
      <h2 className="page-title">Laudos</h2>
      
      <div className="card">
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Paciente</th>
              <th>Data</th>
              <th>Ação</th>
            </tr>
          </thead>
          <tbody>
            {laudos.map(laudo => (
              <tr key={laudo.id}>
                <td>{laudo.id}</td>
                <td>{laudo.paciente}</td>
                <td>{formatDate(laudo.data)}</td>
                <td>
                  <button
                    className="btn btn-primary btn-sm"
                    onClick={() => handleOpenModal(laudo)}
                  >
                    📈 Ver ECG
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      {modalOpen && (
        <div className="modal-overlay" onClick={handleCloseModal}>
          <div className="modal" onClick={e => e.stopPropagation()}>
            <div className="modal-header">
              <h2>Análise ECG - {laudoSelecionado?.paciente}</h2>
              <button 
                onClick={handleCloseModal}
                style={{ background: 'none', border: 'none', fontSize: '24px', cursor: 'pointer' }}
              >
                ×
              </button>
            </div>
            
            <div className="modal-body">
              <div className="ecg-chart">
                <svg width="100%" height="160" viewBox="0 0 800 160" preserveAspectRatio="xMidYMid meet">
                  {/* Grid */}
                  <defs>
                    <pattern id="grid" width="20" height="20" patternUnits="userSpaceOnUse">
                      <path d="M 20 0 L 0 0 0 20" fill="none" stroke="#ffcccc" strokeWidth="0.5"/>
                    </pattern>
                  </defs>
                  <rect width="100%" height="100%" fill="url(#grid)" />
                  
                  {/* ECG Line */}
                  <path d={generateECGPath()} className="ecg-line" />
                </svg>
              </div>

              <h3 style={{ marginBottom: '16px', fontSize: '16px' }}>Definir Intervalos das Ondas (ms)</h3>
              
              <div className="wave-inputs">
                {['P', 'Q', 'R', 'S', 'T'].map(onda => (
                  <div key={onda} className="wave-input">
                    <label>Onda {onda}</label>
                    <input
                      type="number"
                      placeholder="Início"
                      value={ondas[onda].inicio}
                      onChange={(e) => handleOndaChange(onda, 'inicio', e.target.value)}
                    />
                    <input
                      type="number"
                      placeholder="Fim"
                      value={ondas[onda].fim}
                      onChange={(e) => handleOndaChange(onda, 'fim', e.target.value)}
                      style={{ marginTop: '8px' }}
                    />
                  </div>
                ))}
              </div>
            </div>
            
            <div className="modal-footer">
              <button className="btn btn-secondary" onClick={handleCloseModal}>
                Cancelar
              </button>
              <button className="btn btn-primary" onClick={handleSave}>
                Salvar
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}
