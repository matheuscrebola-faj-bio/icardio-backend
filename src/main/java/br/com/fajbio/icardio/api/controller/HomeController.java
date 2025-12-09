package br.com.fajbio.icardio.api.controller;

import br.com.fajbio.icardio.domain.service.AutenticacaoService;
import br.com.fajbio.icardio.domain.service.HomeService;
import br.com.fajbio.icardio.domain.service.UnidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
@CrossOrigin("*")
public class HomeController {
    private final AutenticacaoService autenticacaoService;
    private final HomeService homeService;
    private final UnidadeService unidadeService;

    @GetMapping("/laudados")
    public ResponseEntity<Short> examesLaudados(
            @RequestHeader String token,
            @RequestHeader String unidade
        ){
        if (!autenticacaoService.validarToken(token)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        var uni = unidadeService.encontrarPeloId(unidade);
        var res = homeService.encontrarLaudados(uni);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/pendentes")
    public ResponseEntity<?> examesPendentes(
            @RequestHeader String token,
            @RequestHeader String unidade
        ){
        if (!autenticacaoService.validarToken(token)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/hoje")
    public ResponseEntity<?> examesHoje(
            @RequestHeader String token,
            @RequestHeader String unidade,
            @RequestHeader String usuario
        ){
        if (!autenticacaoService.validarToken(token)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/diarios")
    public ResponseEntity<?> examesDiarios(
            @RequestHeader String token,
            @RequestHeader String unidade,
            @RequestHeader String usuario
        ){
        if (!autenticacaoService.validarToken(token)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/mes")
    public ResponseEntity<?> pacientesMes(
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
