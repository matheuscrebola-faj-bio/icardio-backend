package br.com.fajbio.icardio.domain.service;

import br.com.fajbio.icardio.domain.model.Usuario;
import br.com.fajbio.icardio.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repository;

    public Usuario encontrarPeloId(String id) {
        return repository.findById(id).orElse(null);
    }
}
