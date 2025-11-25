package br.com.fajbio.gateway.api.dtos;

public record Sintomas(
        Boolean peito,
        Boolean agora,
        Boolean desmaio,
        Boolean ar,
        Boolean palpitacao
) {
}
