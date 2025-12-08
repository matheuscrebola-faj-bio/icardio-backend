package br.com.fajbio.icardio.domain.repository;

import br.com.fajbio.icardio.domain.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario,String> {
    Usuario findByLogin(String login);
}
