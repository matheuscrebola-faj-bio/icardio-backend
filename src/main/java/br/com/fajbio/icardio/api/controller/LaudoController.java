package br.com.fajbio.icardio.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/laudos")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LaudoController {

    @GetMapping
    public void listarLaudos(
            @RequestHeader String token,
            @RequestHeader String unidade,
            @RequestHeader String usuario
        ){

    }
}
