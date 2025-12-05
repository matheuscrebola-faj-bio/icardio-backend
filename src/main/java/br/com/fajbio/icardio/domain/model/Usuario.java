package br.com.fajbio.icardio.domain.model;

import br.com.fajbio.icardio.domain.enums.EUsuario;

public class Usuario {
    private String id;
    private String nome;
    private String sobrenome;
    private String documento;
    private String email;
    private String telefone;
    private EUsuario perfil;
    private String assinatura;
}
