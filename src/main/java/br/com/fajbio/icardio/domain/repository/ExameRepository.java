package br.com.fajbio.icardio.domain.repository;

import br.com.fajbio.icardio.domain.model.Exame;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExameRepository extends MongoRepository<Exame,String> {
}
