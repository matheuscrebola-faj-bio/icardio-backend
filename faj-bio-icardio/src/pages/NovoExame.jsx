import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

export default function NovoExame() {
  const navigate = useNavigate();
  
  const [form, setForm] = useState({
    tipoDocumento: 'cpf',
    documento: '',
    nome: '',
    dataNascimento: '',
    peso: '',
    altura: '',
    sintomas: [],
    antecedentes: [],
    observacoes: ''
  });

  const [modalOpen, setModalOpen] = useState(false);
  const [arquivos, setArquivos] = useState([]);

  const sintomasOpcoes = [
    'Dor no Peito AGORA',
    'Sem dor no Peito',
    'Antecede Dor no Peito',
    'Desmaio',
    'Falta de Ar',
    'Palpitação',
    'Sem sintomas'
  ];

  const antecedentesOpcoes = [
    'Marcapasso',
    'Arritmia',
    'Diabetes',
    'Infarto Prévio',
    'Hipertensão',
    'Insuficiência Cardíaca',
    'Cirurgia Cardíaca',
    'Tabagismo',
    'Colesterol Alto',
    'AVC',
    'Sem antecedentes'
  ];

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm(prev => ({ ...prev, [name]: value }));
  };

  const handleCheckbox = (tipo, valor) => {
    setForm(prev => {
      const lista = prev[tipo];
      if (lista.includes(valor)) {
        return { ...prev, [tipo]: lista.filter(v => v !== valor) };
      }
      return { ...prev, [tipo]: [...lista, valor] };
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Dados do exame:', form);
    console.log('Documentos anexados:', arquivos);
    alert(`Iniciando captura do ECG...\n${arquivos.length} documento(s) anexado(s)`);
    // Aqui faria a chamada API com form + arquivos
  };

  const handleOpenModal = () => {
    setModalOpen(true);
  };

  const handleCloseModal = () => {
    setModalOpen(false);
  };

  const handleFileChange = (e) => {
    const selectedFiles = Array.from(e.target.files);
    setArquivos(prev => [...prev, ...selectedFiles]);
  };

  const handleRemoveFile = (index) => {
    setArquivos(prev => prev.filter((_, i) => i !== index));
  };

  const handleConfirmFiles = () => {
    handleCloseModal();
  };

  const formatFileSize = (bytes) => {
    if (bytes === 0) return '0 Bytes';
    const k = 1024;
    const sizes = ['Bytes', 'KB', 'MB', 'GB'];
    const i = Math.floor(Math.log(bytes) / Math.log(k));
    return Math.round(bytes / Math.pow(k, i) * 100) / 100 + ' ' + sizes[i];
  };

  return (
    <div className="container">
      <h2 className="page-title">Novo Exame</h2>
      
      <div className="card">
        <form onSubmit={handleSubmit}>
          <div className="grid-2">
            <div className="form-group">
              <label>Tipo de Documento</label>
              <select
                name="tipoDocumento"
                className="input"
                value={form.tipoDocumento}
                onChange={handleChange}
              >
                <option value="cpf">CPF</option>
                <option value="rg">RG</option>
              </select>
            </div>
            
            <div className="form-group">
              <label>Documento (opcional)</label>
              <input
                type="text"
                name="documento"
                className="input"
                value={form.documento}
                onChange={handleChange}
                placeholder="Digite o documento"
              />
            </div>
          </div>

          <div className="form-group">
            <label>Nome Completo</label>
            <input
              type="text"
              name="nome"
              className="input"
              value={form.nome}
              onChange={handleChange}
              placeholder="Nome do paciente"
            />
          </div>

          <div className="grid-3">
            <div className="form-group">
              <label>Data de Nascimento</label>
              <input
                type="date"
                name="dataNascimento"
                className="input"
                value={form.dataNascimento}
                onChange={handleChange}
              />
            </div>
            
            <div className="form-group">
              <label>Peso (kg)</label>
              <input
                type="number"
                name="peso"
                className="input"
                value={form.peso}
                onChange={handleChange}
                placeholder="Ex: 70"
              />
            </div>
            
            <div className="form-group">
              <label>Altura (cm)</label>
              <input
                type="number"
                name="altura"
                className="input"
                value={form.altura}
                onChange={handleChange}
                placeholder="Ex: 170"
              />
            </div>
          </div>

          <div className="form-group">
            <label>Sintomas</label>
            <div className="checkbox-group">
              {sintomasOpcoes.map(sintoma => (
                <label key={sintoma} className="checkbox-item">
                  <input
                    type="checkbox"
                    checked={form.sintomas.includes(sintoma)}
                    onChange={() => handleCheckbox('sintomas', sintoma)}
                  />
                  {sintoma}
                </label>
              ))}
            </div>
          </div>

          <div className="form-group">
            <label>Antecedentes</label>
            <div className="checkbox-group">
              {antecedentesOpcoes.map(antecedente => (
                <label key={antecedente} className="checkbox-item">
                  <input
                    type="checkbox"
                    checked={form.antecedentes.includes(antecedente)}
                    onChange={() => handleCheckbox('antecedentes', antecedente)}
                  />
                  {antecedente}
                </label>
              ))}
            </div>
          </div>

          <div className="form-group">
            <label>Observações Complementares</label>
            <textarea
              name="observacoes"
              className="input"
              rows="4"
              value={form.observacoes}
              onChange={handleChange}
              placeholder="Informações adicionais..."
            />
          </div>

          <div style={{ display: 'flex', gap: '12px', marginTop: '24px', alignItems: 'center' }}>
            <button type="button" className="btn btn-secondary" onClick={() => navigate('/home')}>
              Cancelar
            </button>
            
            <button 
              type="button" 
              className="btn btn-secondary" 
              onClick={handleOpenModal}
              style={{ display: 'flex', alignItems: 'center', gap: '8px' }}
            >
              📎 Anexar Documentos
              {arquivos.length > 0 && (
                <span className="badge badge-success" style={{ marginLeft: '4px' }}>
                  {arquivos.length}
                </span>
              )}
            </button>
            
            <button type="submit" className="btn btn-primary">
              Iniciar Captura
            </button>
          </div>
        </form>
      </div>

      {/* Modal de Upload de Documentos */}
      {modalOpen && (
        <div className="modal-overlay" onClick={handleCloseModal}>
          <div className="modal" onClick={e => e.stopPropagation()}>
            <div className="modal-header">
              <h2>Anexar Documentos ao Exame</h2>
              <button 
                onClick={handleCloseModal}
                style={{ background: 'none', border: 'none', fontSize: '24px', cursor: 'pointer' }}
              >
                ×
              </button>
            </div>
            
            <div className="modal-body">
              <div style={{ marginBottom: '20px' }}>
                <label 
                  htmlFor="file-upload-exame" 
                  className="btn btn-primary"
                  style={{ cursor: 'pointer', display: 'inline-block' }}
                >
                  📁 Selecionar Arquivos
                </label>
                <input
                  id="file-upload-exame"
                  type="file"
                  multiple
                  accept=".pdf,.doc,.docx,.jpg,.jpeg,.png,.txt"
                  onChange={handleFileChange}
                  style={{ display: 'none' }}
                />
                <small style={{ display: 'block', marginTop: '8px', color: 'var(--text-muted)' }}>
                  Formatos aceitos: PDF, DOC, DOCX, JPG, PNG, TXT
                </small>
              </div>

              {arquivos.length > 0 && (
                <div>
                  <h3 style={{ fontSize: '14px', marginBottom: '12px', fontWeight: 600 }}>
                    Arquivos Selecionados ({arquivos.length})
                  </h3>
                  <div style={{ maxHeight: '300px', overflowY: 'auto' }}>
                    {arquivos.map((arquivo, index) => (
                      <div 
                        key={index}
                        style={{
                          display: 'flex',
                          justifyContent: 'space-between',
                          alignItems: 'center',
                          padding: '12px',
                          background: '#f9f9f9',
                          borderRadius: '6px',
                          marginBottom: '8px'
                        }}
                      >
                        <div style={{ flex: 1 }}>
                          <div style={{ fontWeight: 500, marginBottom: '4px', fontSize: '14px' }}>
                            📄 {arquivo.name}
                          </div>
                          <div style={{ fontSize: '12px', color: 'var(--text-muted)' }}>
                            {formatFileSize(arquivo.size)}
                          </div>
                        </div>
                        <button
                          type="button"
                          className="btn btn-secondary btn-sm"
                          onClick={() => handleRemoveFile(index)}
                          style={{ padding: '6px 12px' }}
                        >
                          🗑️
                        </button>
                      </div>
                    ))}
                  </div>
                </div>
              )}

              {arquivos.length === 0 && (
                <div 
                  style={{
                    textAlign: 'center',
                    padding: '40px',
                    background: '#f9f9f9',
                    borderRadius: '8px',
                    border: '2px dashed var(--border)'
                  }}
                >
                  <div style={{ fontSize: '48px', marginBottom: '16px' }}>📁</div>
                  <p style={{ color: 'var(--text-muted)' }}>
                    Nenhum arquivo selecionado
                  </p>
                  <p style={{ color: 'var(--text-muted)', fontSize: '12px', marginTop: '8px' }}>
                    Os documentos serão anexados ao exame
                  </p>
                </div>
              )}
            </div>
            
            <div className="modal-footer">
              <button type="button" className="btn btn-secondary" onClick={handleCloseModal}>
                Cancelar
              </button>
              <button 
                type="button"
                className="btn btn-primary" 
                onClick={handleConfirmFiles}
              >
                Confirmar {arquivos.length > 0 && `(${arquivos.length})`}
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}
