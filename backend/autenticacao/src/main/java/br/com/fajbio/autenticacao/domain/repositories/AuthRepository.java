package br.com.fajbio.autenticacao.domain.repositories;

import br.com.fajbio.autenticacao.domain.models.Auth;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends MongoRepository<Auth,String> {
}
