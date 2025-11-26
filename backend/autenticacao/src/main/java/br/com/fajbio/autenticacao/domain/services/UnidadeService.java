package br.com.fajbio.autenticacao.domain.services;

import br.com.fajbio.autenticacao.api.dtos.UnidadeReq;
import br.com.fajbio.autenticacao.domain.models.Unidade;
import br.com.fajbio.autenticacao.domain.models.Usuario;
import br.com.fajbio.autenticacao.domain.repositories.UnidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UnidadeService {
    private final UnidadeRepository repository;

    @Transactional
    protected Unidade salvar(Unidade unidade){
        return repository.save(unidade);
    }
    @Transactional
    public Unidade cadastrar(Unidade unidade){
        return salvar(unidade);
    }

    public Unidade encontrarPeloId(String id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public Unidade atualizar(String id, UnidadeReq req){
        var unidade = encontrarPeloId(id);
        unidade.setNome(req.nome());
        unidade.setApelido(req.apelido());
        unidade.setCidade(req.cidade());
        unidade.setEstado(req.estado());
        unidade.setEndereco(req.endereco());
        unidade.setContato(req.contato());
        unidade.setEmail(req.email());
        unidade.setTelefone(req.telefone());
        unidade.setAtualizadoEm(LocalDateTime.now());
        return salvar(unidade);
    }

    @Transactional
    public Unidade adicionarUsuario(String id, List<Usuario> usuarios){
        var unidade = encontrarPeloId(id);
        unidade.getUsuarios().addAll(usuarios);
        unidade.setAtualizadoEm(LocalDateTime.now());
        return salvar(unidade);
    }

    @Transactional
    public Unidade adicionarUsuario(String id, Usuario usuarios){
        var unidade = encontrarPeloId(id);
        unidade.getUsuarios().add(usuarios);
        unidade.setAtualizadoEm(LocalDateTime.now());
        return salvar(unidade);
    }

    @Transactional
    public void desativar(String id){
        var unidade = encontrarPeloId(id);
        unidade.setAtualizadoEm(LocalDateTime.now());
        unidade.setAtivo(false);
        salvar(unidade);
    }

    @Transactional
    public void ativar(String id){
        var unidade = encontrarPeloId(id);
        unidade.setAtualizadoEm(LocalDateTime.now());
        unidade.setAtivo(true);
        salvar(unidade);
    }
}
