package br.com.fajbio.gateway.api.dtos;

public record LaudoRes(
        String id,
        String nome,
        Onda p,
        Onda q,
        Onda r,
        Onda s,
        Onda t
) {
}
