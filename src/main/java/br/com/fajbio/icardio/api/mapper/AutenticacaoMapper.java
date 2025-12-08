package br.com.fajbio.icardio.api.mapper;

import br.com.fajbio.icardio.api.dto.LoginRes;
import br.com.fajbio.icardio.domain.model.Autenticacao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AutenticacaoMapper {
    public LoginRes mapear(String usuario, String unidade) {
        return LoginRes.builder()
                .token(UUID.randomUUID().toString())
                .unidade(unidade)
                .usuario(usuario)
                .build();
    }

    public Autenticacao mapear(LoginRes res){
        return Autenticacao.builder()
                .token(res.token())
                .unidade(res.unidade())
                .usuario(res.usuario())
                .build();
    }

    public LoginRes mapear(Autenticacao auth) {
        return LoginRes.builder()
                .token(auth.getToken())
                .unidade(auth.getUnidade())
                .usuario(auth.getUsuario())
                .build();
    }
}
