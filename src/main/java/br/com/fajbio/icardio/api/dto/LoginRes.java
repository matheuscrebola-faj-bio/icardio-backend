package br.com.fajbio.icardio.api.dto;

import br.com.fajbio.icardio.domain.enums.EUsuario;
import lombok.Builder;

@Builder
public record LoginRes(
        String token,
        String unidade,
        String usuario,
        EUsuario perfil
) {
}
