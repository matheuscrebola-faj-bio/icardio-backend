package br.com.fajbio.icardio.api.dto;

import lombok.Builder;

@Builder
public record LoginRes(
        String token,
        String unidade,
        String usuario
) {
}
