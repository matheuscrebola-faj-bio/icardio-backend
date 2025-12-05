package br.com.fajbio.icardio.api.dto;

public record UnidadeReq(
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
