package br.com.fajbio.gateway.api.dtos;

import br.com.fajbio.gateway.api.enums.EPerfil;

import java.time.LocalDateTime;

public record UsuarioRes(
        String id,
        String nome,
        String sobrenome,
        String documento,
        String email,
        String telefone,
        String assinatura,
        EPerfil perfil,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm,
        Boolean ativo
) {
}
