package br.com.fajbio.icardio.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/laudados")
    public void examesLaudados(
            @RequestHeader String token,
            @RequestHeader String unidade,
            @RequestHeader String usuario
        ){

    }

    @GetMapping("/pendentes")
    public void examesPendentes(
            @RequestHeader String token,
            @RequestHeader String unidade,
            @RequestHeader String usuario
        ){

    }

    @GetMapping("/hoje")
    public void examesHoje(
            @RequestHeader String token,
            @RequestHeader String unidade,
            @RequestHeader String usuario
        ){

    }

    @GetMapping("/diarios")
    public void examesDiarios(
            @RequestHeader String token,
            @RequestHeader String unidade,
            @RequestHeader String usuario
        ){

    }

    @GetMapping("/mes")
    public void pacientesMes(
            @RequestHeader String token,
            @RequestHeader String unidade,
            @RequestHeader String usuario
        ){

    }
}
