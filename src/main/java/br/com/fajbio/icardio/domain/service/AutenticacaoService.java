package br.com.fajbio.icardio.domain.service;

import br.com.fajbio.icardio.api.dto.LoginReq;
import br.com.fajbio.icardio.domain.model.Autenticacao;
import br.com.fajbio.icardio.domain.repository.AutenticacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AutenticacaoService {
    private final AutenticacaoRepository repository;
    private final UsuarioService usuarioService;

    public boolean validarToken(String token) {
        var tk = encontrarPeloToken(token);
        return tk != null;
    }

    public Autenticacao encontrarPeloToken(String token){
        return repository.findByToken(token);
    }

    public boolean validarUsuario(LoginReq req) {
        var usuario = usuarioService.encontrarPeloLogin(req.usuario());
        return usuario != null && usuario.getSenha().equals(req.senha());
    }

    @Transactional
    public Autenticacao salvar(Autenticacao auth) {
        return repository.save(auth);
    }

    @Transactional
    public void excluirToken(String token) {
        Autenticacao auth = repository.findByToken(token);
        repository.deleteById(auth.getId());
    }

    @Transactional
    public Autenticacao renovarToken(String token) {
        Autenticacao auth = repository.findByToken(token);
        auth.setToken(UUID.randomUUID().toString());
        return salvar(auth);
    }
}
