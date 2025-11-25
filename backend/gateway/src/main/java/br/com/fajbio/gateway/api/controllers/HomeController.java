package br.com.fajbio.gateway.api.controllers;

import br.com.fajbio.gateway.api.consumers.HomeConsumer;
import br.com.fajbio.gateway.api.producers.HomeProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {
    private final HomeProducer producer;
    private final HomeConsumer consumer;

    @GetMapping
    public ResponseEntity<?> dashboard(
            @RequestHeader String token
        ){
        return null;
    }

}
