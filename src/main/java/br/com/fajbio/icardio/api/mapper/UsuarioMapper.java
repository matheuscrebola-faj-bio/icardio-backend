package br.com.fajbio.icardio.api.mapper;

import br.com.fajbio.icardio.api.dto.UsuarioReq;
import br.com.fajbio.icardio.api.dto.UsuarioRes;
import br.com.fajbio.icardio.domain.model.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {
    public Usuario mapear(UsuarioReq req) {
        return Usuario.builder()
                .nome(req.nome())
                .sobrenome(req.sobrenome())
                .login(req.login())
                .senha(req.senha())
                .documento(req.documento())
                .email(req.email())
                .telefone(req.telefone())
                .perfil(req.perfil())
                .assinatura(req.assinatura())
                .build();
    }

    public UsuarioRes mapear(Usuario usuario){
        return UsuarioRes.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .sobrenome(usuario.getSobrenome())
                .email(usuario.getEmail())
                .telefone(usuario.getTelefone())
                .perfil(usuario.getPerfil())
                .build();
    }

    public List<UsuarioRes> mapear(List<Usuario> usuarios) {
        return usuarios.stream().map(this::mapear).collect(Collectors.toList());
    }
}
