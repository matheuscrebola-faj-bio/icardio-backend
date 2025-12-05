package br.com.fajbio.exame.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Base64;

@Document
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Exame {
    @Id
    private String id;
    private String paciente;
    private Base64 imagem;
    private LocalDateTime criadoEm;
}
