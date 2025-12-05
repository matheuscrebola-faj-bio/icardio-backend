package br.com.fajbio.icardio.domain.service;

import br.com.fajbio.icardio.domain.model.Unidade;
import br.com.fajbio.icardio.domain.repository.UnidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UnidadeService {
    private final UnidadeRepository repository;
    public Unidade encontrarPeloId(String id) {
        return repository.findById(id).orElse(null);
    }
}
