package br.com.fajbio.gateway.api.controllers;

import br.com.fajbio.gateway.api.consumers.UnidadeConsumer;
import br.com.fajbio.gateway.api.dtos.UnidadeReq;
import br.com.fajbio.gateway.api.dtos.UnidadeRes;
import br.com.fajbio.gateway.api.producers.UnidadeProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unidades")
@RequiredArgsConstructor
public class UnidadeController {
    private final UnidadeConsumer consumer;
    private final UnidadeProducer producer;

    @PostMapping
    public ResponseEntity<?> cadastrarUnidade(
            @RequestHeader String token,
            @RequestBody UnidadeReq req
    ){
        return null;
    }

    @GetMapping
    public ResponseEntity<UnidadeRes> listarUnidades(
            @RequestHeader String token
        ){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadeRes> buscarPeloId(
            @RequestHeader String token,
            @PathVariable String id
    ){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarUnidade(
            @RequestHeader String token,
            @PathVariable String id
        ){
        return null;
    }

    @PutMapping("/{id}/usuario")
    public ResponseEntity<?> adicionarUsuario(
            @RequestHeader String token,
            @PathVariable String id
        ){
        return null;
    }

    @DeleteMapping
    public ResponseEntity<?> deletarUnidade(
            @RequestHeader String token
        ){
        return null;
    }
}
