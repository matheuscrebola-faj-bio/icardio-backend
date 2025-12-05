package br.com.fajbio.icardio.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Unidade {
    @Id
    private String id;
    private String nome;
    private String apelido;
    private String cnpj;
    private String cidade;
    private String estado;
    private String endereco;
    private String contato;
    private String email;
    private String telefone;
    private List<Usuario> usuarios;
}
