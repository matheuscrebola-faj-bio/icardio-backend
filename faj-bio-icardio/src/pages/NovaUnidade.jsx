import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

export default function NovaUnidade() {
  const navigate = useNavigate();
  
  const [form, setForm] = useState({
    nome: '',
    apelido: '',
    cnpj: '',
    cidade: '',
    estado: '',
    endereco: '',
    contato: '',
    email: '',
    telefone: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Nova unidade:', form);
    alert('Unidade cadastrada com sucesso!');
    navigate('/unidades');
  };

  return (
    <div className="container">
      <h2 className="page-title">Nova Unidade</h2>
      
      <div className="card">
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label>Nome da Unidade *</label>
            <input
              type="text"
              name="nome"
              className="input"
              value={form.nome}
              onChange={handleChange}
              placeholder="Ex: Clínica Central"
              required
            />
          </div>

          <div className="grid-2">
            <div className="form-group">
              <label>Apelido *</label>
              <input
                type="text"
                name="apelido"
                className="input"
                value={form.apelido}
                onChange={handleChange}
                placeholder="Ex: Central"
                required
              />
            </div>

            <div className="form-group">
              <label>CNPJ *</label>
              <input
                type="text"
                name="cnpj"
                className="input"
                value={form.cnpj}
                onChange={handleChange}
                placeholder="00.000.000/0000-00"
                required
              />
            </div>
          </div>

          <div className="grid-2">
            <div className="form-group">
              <label>Cidade *</label>
              <input
                type="text"
                name="cidade"
                className="input"
                value={form.cidade}
                onChange={handleChange}
                placeholder="Ex: São Paulo"
                required
              />
            </div>

            <div className="form-group">
              <label>Estado *</label>
              <select
                name="estado"
                className="input"
                value={form.estado}
                onChange={handleChange}
                required
              >
                <option value="">Selecione</option>
                <option value="AC">AC</option>
                <option value="AL">AL</option>
                <option value="AP">AP</option>
                <option value="AM">AM</option>
                <option value="BA">BA</option>
                <option value="CE">CE</option>
                <option value="DF">DF</option>
                <option value="ES">ES</option>
                <option value="GO">GO</option>
                <option value="MA">MA</option>
                <option value="MT">MT</option>
                <option value="MS">MS</option>
                <option value="MG">MG</option>
                <option value="PA">PA</option>
                <option value="PB">PB</option>
                <option value="PR">PR</option>
                <option value="PE">PE</option>
                <option value="PI">PI</option>
                <option value="RJ">RJ</option>
                <option value="RN">RN</option>
                <option value="RS">RS</option>
                <option value="RO">RO</option>
                <option value="RR">RR</option>
                <option value="SC">SC</option>
                <option value="SP">SP</option>
                <option value="SE">SE</option>
                <option value="TO">TO</option>
              </select>
            </div>
          </div>

          <div className="form-group">
            <label>Endereço *</label>
            <input
              type="text"
              name="endereco"
              className="input"
              value={form.endereco}
              onChange={handleChange}
              placeholder="Ex: Av. Paulista, 1000"
              required
            />
          </div>

          <div className="form-group">
            <label>Contato Responsável *</label>
            <input
              type="text"
              name="contato"
              className="input"
              value={form.contato}
              onChange={handleChange}
              placeholder="Nome do responsável"
              required
            />
          </div>

          <div className="grid-2">
            <div className="form-group">
              <label>Email *</label>
              <input
                type="email"
                name="email"
                className="input"
                value={form.email}
                onChange={handleChange}
                placeholder="contato@unidade.com.br"
                required
              />
            </div>

            <div className="form-group">
              <label>Telefone *</label>
              <input
                type="tel"
                name="telefone"
                className="input"
                value={form.telefone}
                onChange={handleChange}
                placeholder="(11) 3000-0000"
                required
              />
            </div>
          </div>

          <div style={{ display: 'flex', gap: '12px', marginTop: '24px' }}>
            <button type="button" className="btn btn-secondary" onClick={() => navigate('/unidades')}>
              Cancelar
            </button>
            <button type="submit" className="btn btn-primary">
              Cadastrar Unidade
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
