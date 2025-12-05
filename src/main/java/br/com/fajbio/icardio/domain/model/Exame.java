package br.com.fajbio.icardio.domain.model;

import br.com.fajbio.icardio.domain.enums.EDocumento;
import br.com.fajbio.icardio.domain.model.auxiliares.Antecedente;
import br.com.fajbio.icardio.domain.model.auxiliares.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Exame {
    @Id
    private String id;
    private EDocumento tipo;
    private String documento;
    private String nome;
    private LocalDate nascimento;
    private BigDecimal peso;
    private BigDecimal altura;
    private BigDecimal imc;
    private Sintoma sintoma;
    private Antecedente antecedente;
    private String observacoes;
    private LocalDateTime datahora;
    @DBRef
    private Documento exame;
    @DBRef
    private Unidade unidade;
    @DBRef
    private Usuario usuario;
}
