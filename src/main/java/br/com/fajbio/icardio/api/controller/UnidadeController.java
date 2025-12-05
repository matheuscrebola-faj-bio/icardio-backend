package br.com.fajbio.icardio.api.controller;

import br.com.fajbio.icardio.domain.service.AutenticacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unidades")
@RequiredArgsConstructor
public class UnidadeController {
    private final AutenticacaoService autenticacaoService;

    @PostMapping
    public ResponseEntity<?> cadastrarUnidade(
            @RequestHeader String token,
            @RequestHeader String unidade,
            @RequestHeader String usuario
        ){
        if (!autenticacaoService.validarToken(token)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> listarUnidades(
            @RequestHeader String token,
            @RequestHeader String unidade,
            @RequestHeader String usuario
        ){
        if (!autenticacaoService.validarToken(token)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
