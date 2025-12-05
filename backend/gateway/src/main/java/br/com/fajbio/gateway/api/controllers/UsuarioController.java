package br.com.fajbio.gateway.api.controllers;

import br.com.fajbio.gateway.api.consumers.AuthConsumer;
import br.com.fajbio.gateway.api.dtos.UsuarioReq;
import br.com.fajbio.gateway.api.dtos.UsuarioRes;
import br.com.fajbio.gateway.api.producers.AuthProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final AuthProducer producer;
    private final AuthConsumer consumer;

    @PostMapping
    public ResponseEntity<?> cadastrarUsuario(
            @RequestHeader String token,
            @RequestBody UsuarioReq req
    ){
        producer.cadastrarUsuario(token,req);
        var res = consumer.respostaCadastro();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioRes>> listarUsuarios(
            @RequestHeader String token
    ){
        producer.listarUsuarios(token);
        var res = consumer.listaUsuarios();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> encontrarPeloId(
            @RequestHeader String token,
            @PathVariable String id
    ){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarUsuario(
            @RequestHeader String token,
            @PathVariable String id,
            @RequestBody UsuarioReq req
    ){
        producer.atualizarUsuario(token,id,req);
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUsuario(
            @PathVariable String id,
            @RequestHeader String token
    ){
        return null;
    }
}
