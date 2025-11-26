package br.com.fajbio.autenticacao.api.dtos;

import br.com.fajbio.autenticacao.domain.enums.EPerfil;

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
