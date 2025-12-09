package br.com.fajbio.icardio.domain.service;

import br.com.fajbio.icardio.domain.model.Unidade;
import br.com.fajbio.icardio.domain.model.Usuario;
import br.com.fajbio.icardio.domain.repository.UnidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UnidadeService {
    private final UnidadeRepository repository;

    public Unidade encontrarPeloId(String id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public Unidade salvar(Unidade unidade) {
        return repository.save(unidade);
    }

    @Transactional
    public void criarUnidade(Unidade unidade) {
        salvar(unidade);
    }

    @Transactional
    public void adicionarUsuarios(String id, List<Usuario> usuarios) {
        var unidade = encontrarPeloId(id);
        if (unidade.getUsuarios() == null) {
            unidade.setUsuarios(new ArrayList<>());
        }
        unidade.getUsuarios().addAll(usuarios);
        salvar(unidade);
    }

    @Transactional
    public void adicionarUsuario(String id, Usuario usuario) {
        var unidade = encontrarPeloId(id);
        unidade.getUsuarios().add(usuario);
        salvar(unidade);
    }

    public List<Usuario> encontrarUsuarios(String unidade) {
        var uni = encontrarPeloId(unidade);
        return uni.getUsuarios();
    }

    public Unidade encontrarPeloUsuario(Usuario usuario) {
        return repository.findByUsuarios(usuario);
    }

    public List<Unidade> encontrarTodos() {
        return repository.findAll();
    }
}
