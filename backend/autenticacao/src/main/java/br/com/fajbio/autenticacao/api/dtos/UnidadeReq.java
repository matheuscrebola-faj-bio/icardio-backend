package br.com.fajbio.autenticacao.api.dtos;

public record UnidadeReq(
        String nome,
        String apelido,
        String cidade,
        String estado,
        String endereco,
        String contato,
        String email,
        String telefone
) {
}
