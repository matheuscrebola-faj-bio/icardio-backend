package br.com.fajbio.icardio.api.dto;

import lombok.Builder;

@Builder
public record PacienteRes(
        String id,
        String nome,
        String dataexame,
        String idade
) {
}
