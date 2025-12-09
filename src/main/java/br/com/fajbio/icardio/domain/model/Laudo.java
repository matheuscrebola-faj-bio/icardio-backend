package br.com.fajbio.icardio.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Laudo {
    @Id
    private String id;
    private LocalDate data;
    @DBRef
    private Unidade unidade;
    @DBRef
    private Exame exame;
    @DBRef
    private Documento ecg;
}
