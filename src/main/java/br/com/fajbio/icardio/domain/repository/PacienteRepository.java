package br.com.fajbio.icardio.domain.repository;

import br.com.fajbio.icardio.domain.model.Paciente;
import br.com.fajbio.icardio.domain.model.Unidade;
import br.com.fajbio.icardio.domain.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente,String> {
    List<Paciente> findByUnidade(Unidade unidade);

    List<Paciente> findByUnidadeAndUsuario(Unidade uni, Usuario usr);
}
