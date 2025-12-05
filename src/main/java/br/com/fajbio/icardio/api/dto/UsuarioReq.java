package br.com.fajbio.icardio.api.dto;

import br.com.fajbio.icardio.domain.enums.EUsuario;

public record UsuarioReq(
        String nome,
        String sobrenome,
        String login,
        String senha,
        String documento,
        String email,
        String telefone,
        EUsuario perfil,
        String assinatura
) {
}
