package br.com.fajbio.icardio.domain.service;

import br.com.fajbio.icardio.domain.model.Unidade;
import br.com.fajbio.icardio.domain.repository.LaudoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class HomeService {
    private final LaudoRepository laudoRepository;

    public Short encontrarLaudados(Unidade unidade) {
        return laudoRepository.countByDataAndUnidade(LocalDate.now(),unidade);
    }
}
