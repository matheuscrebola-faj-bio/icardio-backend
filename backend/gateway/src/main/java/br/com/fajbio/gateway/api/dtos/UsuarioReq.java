package br.com.fajbio.gateway.api.dtos;

import br.com.fajbio.gateway.api.enums.EPerfil;

public record UsuarioReq(
        String nome,
        String sobrenome,
        String login,
        String senha,
        String documento,
        String email,
        String telefone,
        String assinatura,
        EPerfil perfil
) {
}
