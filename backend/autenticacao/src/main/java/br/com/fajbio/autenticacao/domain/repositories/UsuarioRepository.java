package br.com.fajbio.autenticacao.domain.repositories;

import br.com.fajbio.autenticacao.domain.enums.EPerfil;
import br.com.fajbio.autenticacao.domain.models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario,String> {
    Usuario findByNome(String nome);
    Usuario findBySobrenome(String sobrenome);
    Usuario findByDocumento(String documento);
    Usuario findByEmail(String email);
    Usuario findByTelefone(String telefone);
    Usuario findByAssinatura(String assinatura);
    Usuario findByPerfil(EPerfil perfil);
    Usuario findByAtivo(Boolean ativo);
}
