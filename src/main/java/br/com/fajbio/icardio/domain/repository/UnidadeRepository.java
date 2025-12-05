package br.com.fajbio.icardio.domain.repository;

import br.com.fajbio.icardio.domain.model.Unidade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends MongoRepository<Unidade,String> {
}
