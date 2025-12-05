package br.com.fajbio.icardio.api.controller;

import br.com.fajbio.icardio.api.mapper.AutenticacaoMapper;
import br.com.fajbio.icardio.domain.service.AutenticacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AutenticacaoController {
    private final AutenticacaoService autenticacaoService;
    private final AutenticacaoMapper autenticacaoMapper;

    @PostMapping("/login")
    public void login(){

    }

    @PostMapping("/logout")
    public void logout(){

    }

    @PostMapping("/refresh")
    public void refresh(){

    }
}
