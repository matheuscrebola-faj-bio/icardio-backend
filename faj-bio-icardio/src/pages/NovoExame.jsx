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
    alert('Iniciando captura do ECG...');
    // Aqui faria a chamada API
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

          <div style={{ display: 'flex', gap: '12px', marginTop: '24px' }}>
            <button type="button" className="btn btn-secondary" onClick={() => navigate('/home')}>
              Cancelar
            </button>
            <button type="submit" className="btn btn-primary">
              Iniciar Captura
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
