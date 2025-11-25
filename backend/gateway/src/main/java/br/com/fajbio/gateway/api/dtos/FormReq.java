package br.com.fajbio.gateway.api.dtos;

import br.com.fajbio.gateway.api.enums.ETipoDoc;

import java.math.BigDecimal;

public record FormReq(
        ETipoDoc tipo,
        String documento,
        String nome,
        String data,
        BigDecimal peso,
        BigDecimal altura,
        Sintomas sintomas,
        Antecedentes antecedentes,
        String observacoes
) {
}
