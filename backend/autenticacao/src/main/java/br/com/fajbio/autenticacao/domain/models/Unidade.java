package br.com.fajbio.autenticacao.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "unidades")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Unidade {
    @Id
    private String id;
    private String nome;
    private String cidade;
    private String estado;
    @DBRef
    private List<Usuario> usuarios;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private Boolean ativo;
}
