package br.com.fajbio.icardio.api.controller;

import br.com.fajbio.icardio.api.dto.UsuarioReq;
import br.com.fajbio.icardio.api.dto.UsuarioRes;
import br.com.fajbio.icardio.api.mapper.UsuarioMapper;
import br.com.fajbio.icardio.domain.service.AutenticacaoService;
import br.com.fajbio.icardio.domain.service.UnidadeService;
import br.com.fajbio.icardio.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UsuarioController {
    private final AutenticacaoService autenticacaoService;
    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;
    private final UnidadeService unidadeService;

    @PostMapping
    public ResponseEntity<?> cadastrarUsuario(
            @RequestHeader String token,
            @RequestHeader String usuario,
            @RequestHeader String unidade,
            @RequestBody UsuarioReq req
        ){
        if (!autenticacaoService.validarToken(token) || !usuarioService.validarUsuarioGestor(usuario)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        var usr = usuarioService.cadastrarUsuario(usuarioMapper.mapear(req));
        unidadeService.adicionarUsuario(unidade,usr);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> listarUsuarios(
            @RequestHeader String token,
            @RequestHeader String unidade,
            @RequestHeader String usuario
        ){
        if (!autenticacaoService.validarToken(token) || !usuarioService.validarUsuarioGestor(usuario)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        List<UsuarioRes> res = usuarioMapper.mapear(unidadeService.encontrarUsuarios(unidade));
//        var res = usuarioService.encontrarTodos();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
