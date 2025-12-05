package br.com.fajbio.exame.domain.repositories;

import br.com.fajbio.exame.domain.models.Exame;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ExameRespository extends MongoRepository<Exame,String> {
    List<Exame> findByPaciente(String paciente);

    List<Exame> findByCriadoEm(LocalDateTime criadoEm);
}
