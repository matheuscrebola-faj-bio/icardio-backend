package br.com.fajbio.icardio.domain.service;

import br.com.fajbio.icardio.domain.repository.AutenticacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutenticacaoService {
    private final AutenticacaoRepository repository;

    public boolean validarToken(String token) {
        return repository.findByToken(token);
    }
}
