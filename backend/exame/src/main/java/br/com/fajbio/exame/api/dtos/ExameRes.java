package br.com.fajbio.exame.api.dtos;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Base64;

@Builder
public record ExameRes(
        String id,
        String paciente,
        Base64 imagem,
        LocalDateTime criadoEm
) {
}
