package br.com.fajbio.autenticacao.domain.repositories;

import br.com.fajbio.autenticacao.domain.models.Unidade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends MongoRepository<Unidade,String> {
}
