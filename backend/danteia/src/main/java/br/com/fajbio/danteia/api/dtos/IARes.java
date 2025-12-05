package br.com.fajbio.danteia.api.dtos;

import java.math.BigDecimal;

public record IARes(
        Byte ordem,
        String diagnostico,
        BigDecimal porcentagem
) {
}
