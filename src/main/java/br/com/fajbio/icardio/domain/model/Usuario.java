package br.com.fajbio.icardio.domain.model;

import br.com.fajbio.icardio.domain.enums.EUsuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Usuario {
    @Id
    private String id;
    private String nome;
    private String sobrenome;
    private String documento;
    private String email;
    private String telefone;
    private EUsuario perfil;
    private String assinatura;
}
