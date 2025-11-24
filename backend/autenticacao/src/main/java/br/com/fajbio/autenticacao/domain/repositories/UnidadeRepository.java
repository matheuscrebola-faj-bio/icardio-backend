package br.com.fajbio.autenticacao.domain.repositories;

import br.com.fajbio.autenticacao.domain.models.Unidade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends MongoRepository<Unidade,String> {
    Unidade findByNome(String nome);
    Unidade findByCidade(String cidade);
    Unidade findByEstado(String estado);
    Unidade findByEndereco(String endereco);
    Unidade findByContato(String contato);
    Unidade findByEmail(String email);
    Unidade findByTelefone(String telefone);
    Unidade findByAtivo(Boolean ativo);
}
