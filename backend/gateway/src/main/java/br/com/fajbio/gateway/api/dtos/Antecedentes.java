package br.com.fajbio.gateway.api.dtos;

public record Antecedentes(
        Boolean marcapasso,
        Boolean arritmia,
        Boolean diabetes,
        Boolean infarto,
        Boolean hipertensao,
        Boolean insuficiencia,
        Boolean cirurgia,
        Boolean tabagismo,
        Boolean colesterol,
        Boolean avc
) {
}
