package br.com.fajbio.gateway.api.producers;

import br.com.fajbio.gateway.api.dtos.UsuarioReq;
import org.springframework.stereotype.Component;

@Component
public class AuthProducer {
    public void cadastrarUsuario(String token, UsuarioReq req) {
    }

    public void listarUsuarios(String token) {
    }

    public void atualizarUsuario(String token, String id, UsuarioReq req) {

    }
}
