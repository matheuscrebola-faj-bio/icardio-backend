package br.com.fajbio.icardio.domain.service;

import br.com.fajbio.icardio.api.dto.UsuarioDTO;
import br.com.fajbio.icardio.domain.enums.EUsuario;
import br.com.fajbio.icardio.domain.model.Usuario;
import br.com.fajbio.icardio.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repository;

    public Usuario encontrarPeloId(String id) {
        return repository.findById(id).orElse(null);
    }

    public List<Usuario> encontrarPeloId(List<UsuarioDTO> dtos) {
        return dtos.stream()
                .map(dto -> encontrarPeloId(dto.id()))
                .collect(Collectors.toList());
    }

    public boolean validarUsuarioAdm(String usuario) {
        var usr = encontrarPeloId(usuario);
        return usr.getPerfil().equals(EUsuario.ADM);
    }

    public boolean validarUsuarioGestor(String usuario) {
        var usr = encontrarPeloId(usuario);
        return usr.getPerfil().equals(EUsuario.ADM) || usr.getPerfil().equals(EUsuario.GERENTE);
    }
}
