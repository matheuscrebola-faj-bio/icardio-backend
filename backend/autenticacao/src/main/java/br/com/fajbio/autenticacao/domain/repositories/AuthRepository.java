package br.com.fajbio.autenticacao.domain.repositories;

import br.com.fajbio.autenticacao.domain.models.Auth;
import br.com.fajbio.autenticacao.domain.models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AuthRepository extends MongoRepository<Auth,String> {

    Auth findByUsuario(Usuario usuario);
    Auth findByToken(String token);
    Auth findByExpiraEm(LocalDateTime time);
}
