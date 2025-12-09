package br.com.fajbio.icardio.domain.repository;

import br.com.fajbio.icardio.domain.model.Unidade;
import br.com.fajbio.icardio.domain.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadeRepository extends MongoRepository<Unidade,String> {
    Unidade findByUsuarios(Usuario usuario);
}
