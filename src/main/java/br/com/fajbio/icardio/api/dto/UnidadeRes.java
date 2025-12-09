package br.com.fajbio.icardio.api.dto;

import lombok.Builder;

@Builder
public record UnidadeRes(
        String id,
        String nome,
        String apelido,
        String cnpj,
        String cidade,
        String estado,
        String endereco,
        String contato,
        String email,
        String telefone
) {
}
