package br.com.fajbio.icardio.domain.repository;

import br.com.fajbio.icardio.domain.model.Laudo;
import br.com.fajbio.icardio.domain.model.Unidade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LaudoRepository extends MongoRepository<Laudo,String> {
    Short countByDataAndUnidade(LocalDate data, Unidade unidade);
}
