package br.com.fajbio.icardio.api.dto;

import br.com.fajbio.icardio.domain.enums.EUsuario;
import lombok.Builder;

@Builder
public record UsuarioRes(
        String id,
        String nome,
        String sobrenome,
        String email,
        String telefone,
        EUsuario perfil
) {
}
