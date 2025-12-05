package br.com.fajbio.icardio.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/laudos")
@RequiredArgsConstructor
public class LaudoController {

    @GetMapping
    public void listarLaudos(
            @RequestHeader String token,
            @RequestHeader String unidade,
            @RequestHeader String usuario
        ){

    }
}
