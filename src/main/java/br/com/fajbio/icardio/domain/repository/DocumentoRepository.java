package br.com.fajbio.icardio.domain.repository;

import br.com.fajbio.icardio.domain.model.Documento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends MongoRepository<Documento,String> {
}
