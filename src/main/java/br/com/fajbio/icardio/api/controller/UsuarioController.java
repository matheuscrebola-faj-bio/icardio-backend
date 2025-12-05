package br.com.fajbio.icardio.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    @PostMapping
    public void cadastrarUsuario(
            @RequestHeader String token,
            @RequestHeader String unidade,
            @RequestHeader String usuario
        ){

    }

    @GetMapping
    public void listarUsuarios(
            @RequestHeader String token,
            @RequestHeader String unidade,
            @RequestHeader String usuario
        ){

    }
}
