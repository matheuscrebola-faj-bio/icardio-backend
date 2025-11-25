# FAJ BIO - iCardio

Sistema de gerenciamento de eletrocardiograma com React + Vite.

## 🚀 Como executar

```bash
# Instalar dependências
npm install

# Executar em modo desenvolvimento
npm run dev

# Build para produção
npm run build
```

## 📱 Telas do Sistema

### Autenticação
- **Login** - Autenticação com usuário/senha (gera token UUID)

### Dashboard
- **Home** - Dashboard com métricas (exames laudados, para laudar, pacientes mensais)

### Exames
- **Novo Exame** - Formulário completo com dados do paciente, sintomas, antecedentes
- **Laudos** - Lista de laudos com modal para análise ECG (ondas P, Q, R, S, T)
- **Pacientes** - Lista de pacientes com download de PDF

### Gestão
- **Usuários** - Lista e cadastro de usuários do sistema
  - Campos: nome, sobrenome, documento, email, telefone, assinatura, perfil
  - Perfis: MEDICO, USUARIO, MEDICO_ADM, ADMIN, GERENTE
  
- **Unidades** - Lista e cadastro de unidades/clínicas
  - Campos: nome, cidade, estado, endereço, contato, email, telefone

## 🎨 Tema

O projeto utiliza um tema vermelho (`#c41e3a`) como cor primária.

## 📁 Estrutura

```
src/
├── components/
│   ├── Layout.jsx              # Header + navegação
│   └── ProtectedRoute.jsx      # Proteção de rotas
├── context/
│   └── AuthContext.jsx         # Contexto de autenticação
├── pages/
│   ├── Login.jsx               # Tela de login
│   ├── Home.jsx                # Dashboard
│   ├── NovoExame.jsx           # Formulário de exame
│   ├── Laudos.jsx              # Lista de laudos + modal ECG
│   ├── Pacientes.jsx           # Lista de pacientes
│   ├── Usuarios.jsx            # Lista de usuários
│   ├── NovoUsuario.jsx         # Cadastro de usuário
│   ├── Unidades.jsx            # Lista de unidades
│   └── NovaUnidade.jsx         # Cadastro de unidade
├── App.jsx                     # Rotas principais
└── index.css                   # Estilos globais
```

## 🔐 Perfis de Usuário

- **MEDICO** - Médico padrão
- **USUARIO** - Usuário comum do sistema
- **MEDICO_ADM** - Médico com privilégios administrativos
- **ADMIN** - Administrador do sistema
- **GERENTE** - Gerente de unidade

## 📝 Observações

Este é um protótipo funcional sem validações complexas. O foco está na interface e fluxo de telas.
Os dados são mockados (simulados) e não há integração real com backend.
