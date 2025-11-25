package br.com.fajbio.gateway.api.dtos;

import java.time.LocalDateTime;

public record UnidadeRes(
        String id,
        String nome,
        String apelido,
        String cidade,
        String estado,
        String endereco,
        String contato,
        String email,
        String telefone,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm,
        Boolean ativo
) {
}
