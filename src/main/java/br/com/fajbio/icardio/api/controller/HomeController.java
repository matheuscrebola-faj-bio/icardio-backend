package br.com.fajbio.icardio.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/laudados")
    public void examesLaudados(){

    }

    @GetMapping("/pendentes")
    public void examesPendentes(){

    }

    @GetMapping("/hoje")
    public void examesHoje(){

    }

    @GetMapping("/diarios")
    public void examesDiarios(){

    }

    @GetMapping("/mes")
    public void pacientesMes(){

    }
}
