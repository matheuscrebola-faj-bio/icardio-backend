package br.com.fajbio.autenticacao.domain.repositories;

import br.com.fajbio.autenticacao.domain.models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario,String> {
}
