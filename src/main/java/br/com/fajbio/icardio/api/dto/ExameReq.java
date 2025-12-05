package br.com.fajbio.icardio.api.dto;

import br.com.fajbio.icardio.domain.enums.EDocumento;
import br.com.fajbio.icardio.domain.model.auxiliares.Antecedente;
import br.com.fajbio.icardio.domain.model.auxiliares.Sintoma;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExameReq(
        EDocumento tipo,
        String documento,
        String nome,
        LocalDate nascimento,
        BigDecimal peso,
        BigDecimal altura,
        Sintoma sintoma,
        Antecedente antecedente,
        String observacoes,
        String exame
) {
}
