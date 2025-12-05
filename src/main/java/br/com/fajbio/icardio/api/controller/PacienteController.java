package br.com.fajbio.icardio.api.controller;

import br.com.fajbio.icardio.domain.service.AutenticacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {
    private final AutenticacaoService autenticacaoService;

    @GetMapping
    public ResponseEntity<?> listarPacientes(
            @RequestHeader String token,
            @RequestHeader String unidade,
            @RequestHeader String usuario
        ){
        if (!autenticacaoService.validarToken(token)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/paciente")
    public ResponseEntity<?> encontrarPaciente(
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
