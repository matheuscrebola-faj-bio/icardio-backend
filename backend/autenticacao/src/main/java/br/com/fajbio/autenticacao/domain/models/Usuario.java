package br.com.fajbio.autenticacao.domain.models;

import br.com.fajbio.autenticacao.domain.enums.EPerfil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "usuarios")
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
    private String assinatura;
    private EPerfil perfil;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private Boolean ativo;
}

