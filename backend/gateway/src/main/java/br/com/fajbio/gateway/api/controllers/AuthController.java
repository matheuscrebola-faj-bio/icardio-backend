package br.com.fajbio.gateway.api.controllers;

import br.com.fajbio.gateway.api.consumers.AuthConsumer;
import br.com.fajbio.gateway.api.producers.AuthProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthProducer producer;
    private final AuthConsumer consumer;

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestHeader String token
        ){
        return null;
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(
            @RequestHeader String token
        ){
        return null;
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(
            @RequestHeader String token
        ){
        return null;
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validarToken(
            @RequestHeader String token
    ){
        return null;
    }

    @GetMapping("/me")
    public ResponseEntity<?> dadosUsuario(
            @RequestHeader String token
    ){
        return null;
    }

    @PutMapping("/me/senha")
    public ResponseEntity<?> atualizarSenha(
            @RequestHeader String token
    ){
        return null;
    }
}
