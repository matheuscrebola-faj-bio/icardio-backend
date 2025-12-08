package br.com.fajbio.icardio.api.controller;

import br.com.fajbio.icardio.api.dto.UnidadeReq;
import br.com.fajbio.icardio.api.dto.UsuarioDTO;
import br.com.fajbio.icardio.api.mapper.UnidadeMapper;
import br.com.fajbio.icardio.api.mapper.UsuarioMapper;
import br.com.fajbio.icardio.domain.model.Usuario;
import br.com.fajbio.icardio.domain.service.AutenticacaoService;
import br.com.fajbio.icardio.domain.service.UnidadeService;
import br.com.fajbio.icardio.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidades")
@RequiredArgsConstructor
public class UnidadeController {
    private final AutenticacaoService autenticacaoService;
    private final UsuarioService usuarioService;
    private final UnidadeService unidadeService;
    private final UnidadeMapper unidadeMapper;

    @PostMapping
    public ResponseEntity<?> cadastrarUnidade(
            @RequestHeader String token,
            @RequestHeader String usuario,
            @RequestBody UnidadeReq req
        ){
        if (!autenticacaoService.validarToken(token) || !usuarioService.validarUsuarioAdm(usuario)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        unidadeService.criarUnidade(unidadeMapper.mapear(req));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> listarUnidades(
            @RequestHeader String token,
            @RequestHeader String usuario
        ){
        if (!autenticacaoService.validarToken(token) || !usuarioService.validarUsuarioAdm(usuario)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/unidade")
    public ResponseEntity<?> adicionarUsuario(
            @RequestHeader String token,
            @RequestHeader String usuario,
            @PathVariable String unidade,
            @RequestBody List<UsuarioDTO> dtos
            ){
        if (!autenticacaoService.validarToken(token) || !usuarioService.validarUsuarioGestor(usuario)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
            List<Usuario> usuarios = usuarioService.encontrarPeloId(dtos);
            unidadeService.adicionarUsuarios(unidade,usuarios);
            return new ResponseEntity<>(HttpStatus.OK);
    }
}
