package br.com.fajbio.icardio.domain.model;

import br.com.fajbio.icardio.domain.enums.EDocumento;
import br.com.fajbio.icardio.domain.model.auxiliares.Antecedente;
import br.com.fajbio.icardio.domain.model.auxiliares.Sintoma;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Exame {
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
    private String exame;
}
