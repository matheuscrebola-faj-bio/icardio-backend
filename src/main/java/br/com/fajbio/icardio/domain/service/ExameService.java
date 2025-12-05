package br.com.fajbio.icardio.domain.service;

import br.com.fajbio.icardio.domain.model.Exame;
import br.com.fajbio.icardio.domain.repository.ExameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExameService {
    private final ExameRepository repository;

    @Transactional
    public Exame criarExame(Exame exame) {
        return repository.save(exame);
    }
}
