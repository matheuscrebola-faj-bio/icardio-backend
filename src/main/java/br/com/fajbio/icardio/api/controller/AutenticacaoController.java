package br.com.fajbio.icardio.api.controller;

import br.com.fajbio.icardio.api.dto.LoginReq;
import br.com.fajbio.icardio.api.dto.LoginRes;
import br.com.fajbio.icardio.api.mapper.AutenticacaoMapper;
import br.com.fajbio.icardio.domain.service.AutenticacaoService;
import br.com.fajbio.icardio.domain.service.UnidadeService;
import br.com.fajbio.icardio.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AutenticacaoController {
    private final AutenticacaoService autenticacaoService;
    private final AutenticacaoMapper autenticacaoMapper;
    private final UsuarioService usuarioService;
    private final UnidadeService unidadeService;

    @PostMapping("/login")
    public ResponseEntity<LoginRes> login(
            @RequestBody LoginReq req
    ){
        if (!autenticacaoService.validarUsuario(req)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        var usuario = usuarioService.encontrarPeloLogin(req.usuario());
        var unidade = unidadeService.encontrarPeloUsuario(usuario);
        var res = autenticacaoMapper.mapear(usuario.getId(),unidade.getId());
        var auth = autenticacaoMapper.mapear(res);
        autenticacaoService.salvar(auth);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(
            @RequestHeader String token
    ){
        autenticacaoService.excluirToken(token);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/refresh")
    public ResponseEntity<LoginRes> refresh(
            @RequestHeader String token
    ){
        var ref = autenticacaoService.renovarToken(token);
        var res = autenticacaoMapper.mapear(ref);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
