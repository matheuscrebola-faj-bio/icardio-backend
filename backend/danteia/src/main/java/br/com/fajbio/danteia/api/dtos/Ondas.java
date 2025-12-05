package br.com.fajbio.danteia.api.dtos;

import java.math.BigDecimal;

public record Ondas(
        BigDecimal inicio,
        BigDecimal fim
) {
}
