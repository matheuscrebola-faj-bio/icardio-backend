package br.com.fajbio.icardio.domain.service;

import br.com.fajbio.icardio.api.dto.UsuarioDTO;
import br.com.fajbio.icardio.domain.enums.EUsuario;
import br.com.fajbio.icardio.domain.model.Usuario;
import br.com.fajbio.icardio.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repository;

    public Usuario encontrarPeloId(String id) {
        return repository.findById(id).orElse(null);
    }

    public List<Usuario> encontrarPeloId(List<UsuarioDTO> dtos) {
        return dtos.stream()
                .filter(dto -> dto != null && dto.id() != null && !dto.id().isBlank())
                .map(dto -> encontrarPeloId(dto.id()))
                .toList(); // Java 16+
    }

    public boolean validarUsuarioAdm(String usuario) {
        var usr = encontrarPeloId(usuario);
        return usr.getPerfil().equals(EUsuario.ADM);
    }

    public boolean validarUsuarioGestor(String usuario) {
        var usr = encontrarPeloId(usuario);
        return usr.getPerfil().equals(EUsuario.ADM) || usr.getPerfil().equals(EUsuario.GERENTE);
    }

    @Transactional
    public Usuario cadastrarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario encontrarPeloLogin(String login) {
        return repository.findByLogin(login);
    }

    public List<Usuario> encontrarTodos() {
        return repository.findAll();
    }
}
