package br.com.fajbio.icardio.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unidades")
@RequiredArgsConstructor
public class UnidadeController {

    @PostMapping
    public void cadastrarUnidade(
            @RequestHeader String token,
            @RequestHeader String unidade,
            @RequestHeader String usuario
        ){

    }

    @GetMapping
    public void listarUnidades(
            @RequestHeader String token,
            @RequestHeader String unidade,
            @RequestHeader String usuario
        ){

    }
}
