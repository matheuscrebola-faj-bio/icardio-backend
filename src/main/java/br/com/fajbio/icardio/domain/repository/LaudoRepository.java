package br.com.fajbio.icardio.domain.repository;

import br.com.fajbio.icardio.domain.model.Laudo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaudoRepository extends MongoRepository<Laudo,String> {
}
