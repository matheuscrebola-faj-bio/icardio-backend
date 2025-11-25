import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

export default function NovoUsuario() {
  const navigate = useNavigate();
  
  const [form, setForm] = useState({
    nome: '',
    sobrenome: '',
    login: '',
    senha: '',
    documento: '',
    email: '',
    telefone: '',
    assinatura: '',
    perfil: 'USUARIO'
  });

  const perfis = [
    { value: 'MEDICO', label: 'Médico' },
    { value: 'USUARIO', label: 'Usuário' },
    { value: 'MEDICO_ADM', label: 'Médico Administrador' },
    { value: 'ADMIN', label: 'Administrador' },
    { value: 'GERENTE', label: 'Gerente' }
  ];

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Novo usuário:', form);
    alert('Usuário cadastrado com sucesso!');
    navigate('/usuarios');
  };

  return (
    <div className="container">
      <h2 className="page-title">Novo Usuário</h2>
      
      <div className="card">
        <form onSubmit={handleSubmit}>
          <div className="grid-2">
            <div className="form-group">
              <label>Nome *</label>
              <input
                type="text"
                name="nome"
                className="input"
                value={form.nome}
                onChange={handleChange}
                placeholder="Nome"
                required
              />
            </div>

            <div className="form-group">
              <label>Sobrenome *</label>
              <input
                type="text"
                name="sobrenome"
                className="input"
                value={form.sobrenome}
                onChange={handleChange}
                placeholder="Sobrenome"
                required
              />
            </div>
          </div>

          <div className="grid-2">
            <div className="form-group">
              <label>Login *</label>
              <input
                type="text"
                name="login"
                className="input"
                value={form.login}
                onChange={handleChange}
                placeholder="nome.sobrenome"
                required
              />
            </div>

            <div className="form-group">
              <label>Senha *</label>
              <input
                type="password"
                name="senha"
                className="input"
                value={form.senha}
                onChange={handleChange}
                placeholder="Digite a senha"
                required
              />
            </div>
          </div>

          <div className="form-group">
            <label>Documento (CPF) *</label>
            <input
              type="text"
              name="documento"
              className="input"
              value={form.documento}
              onChange={handleChange}
              placeholder="000.000.000-00"
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
                placeholder="usuario@email.com"
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
                placeholder="(11) 98765-4321"
                required
              />
            </div>
          </div>

          <div className="form-group">
            <label>Perfil *</label>
            <select
              name="perfil"
              className="input"
              value={form.perfil}
              onChange={handleChange}
              required
            >
              {perfis.map(perfil => (
                <option key={perfil.value} value={perfil.value}>
                  {perfil.label}
                </option>
              ))}
            </select>
          </div>

          <div className="form-group">
            <label>Assinatura (opcional)</label>
            <input
              type="text"
              name="assinatura"
              className="input"
              value={form.assinatura}
              onChange={handleChange}
              placeholder="Ex: Dr. João Silva - CRM 12345"
            />
            <small style={{ color: 'var(--text-muted)', fontSize: '12px', marginTop: '4px', display: 'block' }}>
              Campo usado principalmente para médicos (nome completo + CRM)
            </small>
          </div>

          <div style={{ display: 'flex', gap: '12px', marginTop: '24px' }}>
            <button type="button" className="btn btn-secondary" onClick={() => navigate('/usuarios')}>
              Cancelar
            </button>
            <button type="submit" className="btn btn-primary">
              Cadastrar Usuário
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
