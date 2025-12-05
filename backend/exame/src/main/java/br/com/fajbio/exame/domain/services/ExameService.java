package br.com.fajbio.exame.domain.services;

import br.com.fajbio.exame.domain.models.Exame;
import br.com.fajbio.exame.domain.repositories.ExameRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExameService {
    private final ExameRespository respository;

    @Transactional
    protected Exame salvar(Exame exame){
        return respository.save(exame);
    }

    protected Exame encontrarPeloId(String id){
        return respository.findById(id).orElse(null);
    }

    protected List<Exame> encontrarTodos(){
        return respository.findAll();
    }

    public List<Exame> encontrarPeloPaciente(String paciente){
        return respository.findByPaciente(paciente);
    }

    public List<Exame> encontrarPeloCriadoEm(LocalDateTime criadoEm){
        return respository.findByCriadoEm(criadoEm);
    }
}
