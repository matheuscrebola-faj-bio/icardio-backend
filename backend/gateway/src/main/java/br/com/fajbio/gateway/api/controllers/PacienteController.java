package br.com.fajbio.gateway.api.controllers;

import br.com.fajbio.gateway.api.consumers.PacienteConsumer;
import br.com.fajbio.gateway.api.producers.PacienteProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {
    private final PacienteConsumer consumer;
    private final PacienteProducer producer;

    @GetMapping
    public ResponseEntity<?> listarPacientes(
            @RequestHeader String token
        ){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> baixarPDF(
            @RequestHeader String token,
            @PathVariable String id
        ){
        return null;
    }
}
