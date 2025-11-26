package br.com.fajbio.autenticacao.domain.services;

import br.com.fajbio.autenticacao.api.dtos.UsuarioReq;
import br.com.fajbio.autenticacao.domain.models.Usuario;
import br.com.fajbio.autenticacao.domain.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repository;

    @Transactional
    protected Usuario salvar(Usuario usuario){
        return repository.save(usuario);
    }
    @Transactional
    public Usuario cadastrar(Usuario usuario){
        return salvar(usuario);
    }

    public Usuario encontrarPeloId(String id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public Usuario atualizar(String id, UsuarioReq req){
        var usuario = encontrarPeloId(id);
        usuario.setNome(req.nome());
        usuario.setSobrenome(req.sobrenome());
        usuario.setLogin(req.login());
        usuario.setSenha(req.senha());
        usuario.setDocumento(req.documento());
        usuario.setEmail(req.email());
        usuario.setTelefone(req.telefone());
        usuario.setAssinatura(req.assinatura());
        usuario.setPerfil(req.perfil());
        usuario.setAtualizadoEm(LocalDateTime.now());
        return salvar(usuario);
    }

    @Transactional
    public void desativar(String id){
        var usuario = encontrarPeloId(id);
        usuario.setAtivo(false);
        usuario.setAtualizadoEm(LocalDateTime.now());
        salvar(usuario);
    }

    @Transactional
    public void ativar(String id){
        var usuario = encontrarPeloId(id);
        usuario.setAtivo(true);
        usuario.setAtualizadoEm(LocalDateTime.now());
        salvar(usuario);
    }
}
