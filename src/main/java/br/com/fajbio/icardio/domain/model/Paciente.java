package br.com.fajbio.icardio.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Paciente {
    @Id
    private String id;
    private String nome;
    private String dataexame;
    @DBRef
    private Documento documento;
    @DBRef
    private Unidade unidade;
    @DBRef
    private Usuario usuario;
    @DBRef
    private Exame exame;
}
