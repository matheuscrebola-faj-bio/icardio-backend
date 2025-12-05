package br.com.fajbio.gateway.api.controllers;

import br.com.fajbio.gateway.api.consumers.ExameConsumer;
import br.com.fajbio.gateway.api.dtos.FormReq;
import br.com.fajbio.gateway.api.producers.ExameProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exames")
@RequiredArgsConstructor
public class ExameController {
    private final ExameConsumer consumer;
    private final ExameProducer producer;

    @PostMapping
    public ResponseEntity<?> formulario(
            @RequestHeader String token,
            @RequestBody FormReq req
        ){
        return null;
    }

    @PostMapping("/ecg")
    public ResponseEntity<?> receberECG(
            @RequestHeader String token
        ){
        return null;
    }

    @PostMapping("/documentos")
    public ResponseEntity<?> receberDocumentos(
            @RequestHeader String token
        ){
        return null;
    }

    @GetMapping
    public ResponseEntity<?> listarExames(
            @RequestHeader String token
    ){
        return null;
    }


}
