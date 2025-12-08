package br.com.fajbio.icardio.domain.repository;

import br.com.fajbio.icardio.domain.model.Autenticacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutenticacaoRepository extends MongoRepository<Autenticacao,String> {
    Autenticacao findByToken(String token);
}
