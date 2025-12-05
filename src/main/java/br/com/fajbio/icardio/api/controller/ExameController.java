package br.com.fajbio.icardio.api.controller;

import br.com.fajbio.icardio.api.dto.ExameReq;
import br.com.fajbio.icardio.api.mapper.DocumentoMapper;
import br.com.fajbio.icardio.api.mapper.ExameMapper;
import br.com.fajbio.icardio.api.mapper.PacienteMapper;
import br.com.fajbio.icardio.domain.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exames")
@RequiredArgsConstructor
public class ExameController {
    private final ExameMapper exameMapper;
    private final ExameService exameService;
    private final UnidadeService unidadeService;
    private final UsuarioService usuarioService;
    private final AutenticacaoService autenticacaoService;
    private final DocumentoService documentoService;
    private final DocumentoMapper documentoMapper;
    private final PacienteMapper pacienteMapper;
    private final PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> criarExame(
        @RequestHeader String token,
        @RequestHeader String unidade,
        @RequestHeader String usuario,
        @RequestBody ExameReq req
        ){
        if (!autenticacaoService.validarToken(token)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        var uni = unidadeService.encontrarPeloId(unidade);
        var usr = usuarioService.encontrarPeloId(usuario);
        var doc = documentoService.salvar(documentoMapper.mapear(req.documento()));
        var exa = exameService.criarExame(exameMapper.mapear(req,uni,usr));
        pacienteService.criarPaciente(pacienteMapper.mapear(req,doc,uni,usr,exa));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
