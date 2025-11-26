package br.com.fajbio.gateway.api.controllers;

import br.com.fajbio.gateway.api.consumers.LaudoConsumer;
import br.com.fajbio.gateway.api.dtos.LaudoRes;
import br.com.fajbio.gateway.api.dtos.Laudos;
import br.com.fajbio.gateway.api.producers.LaudoProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laudos")
@RequiredArgsConstructor
public class LaudoController {
    private final LaudoConsumer consumer;
    private final LaudoProducer producer;

    @GetMapping
    public ResponseEntity<List<Laudos>> listarLaudos(
            @RequestHeader String token
        ){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LaudoRes> buscarPeloId(
            @RequestHeader String token,
            @PathVariable String id
        ){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarOndas(
            @RequestHeader String token,
            @PathVariable String id
    ){
        return null;
    }
}
