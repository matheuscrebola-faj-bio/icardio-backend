package br.com.fajbio.gateway.api.dtos;

import java.math.BigDecimal;

public record Onda(
        BigDecimal inicio,
        BigDecimal fim
) {
}
