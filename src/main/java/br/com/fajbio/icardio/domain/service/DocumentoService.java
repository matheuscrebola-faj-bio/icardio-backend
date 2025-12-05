package br.com.fajbio.icardio.domain.service;

import br.com.fajbio.icardio.domain.model.Documento;
import br.com.fajbio.icardio.domain.repository.DocumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DocumentoService {
    private final DocumentoRepository repository;

    @Transactional
    public Documento salvar(Documento documento){
        return repository.save(documento);
    }
}
