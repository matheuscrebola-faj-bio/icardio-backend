package br.com.fajbio.icardio.domain.repository;

import br.com.fajbio.icardio.domain.model.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente,String> {
}
