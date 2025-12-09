package br.com.fajbio.icardio.api.controller;

import br.com.fajbio.icardio.api.dto.PacienteRes;
import br.com.fajbio.icardio.api.mapper.PacienteMapper;
import br.com.fajbio.icardio.domain.model.Paciente;
import br.com.fajbio.icardio.domain.service.AutenticacaoService;
import br.com.fajbio.icardio.domain.service.PacienteService;
import br.com.fajbio.icardio.domain.service.UnidadeService;
import br.com.fajbio.icardio.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PacienteController {
    private final AutenticacaoService autenticacaoService;
    private final PacienteService pacienteService;
    private final PacienteMapper pacienteMapper;
    private final UnidadeService unidadeService;
    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<PacienteRes>> listarPacientes(
            @RequestHeader String token,
            @RequestHeader String unidade,
            @RequestHeader String usuario
        ){
        if (!autenticacaoService.validarToken(token)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        var usr = usuarioService.encontrarPeloId(usuario);
        List<Paciente> pacientes = switch (usr.getPerfil()) {
            case ADM -> pacienteService.encontrarTodos();
            case MEDICO, TECNICO -> {
                var unidadeObj = unidadeService.encontrarPeloId(unidade);
                yield pacienteService.encontrarPelaUnidadeEUsuario(unidadeObj, usr);
            }
            default -> {
                var unidadeDefault = unidadeService.encontrarPeloId(unidade);
                yield pacienteService.encontrarPelaUnidade(unidadeDefault);
            }
        };
        List<PacienteRes> res = pacienteMapper.mapear(pacientes);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    //baixar arquivo
    @GetMapping("/{pacienteid}")
    public ResponseEntity<?> buscarExame(
            @RequestHeader String token,
            @RequestHeader String unidade,
            @RequestHeader String usuario,
            @PathVariable String pacienteid
    ){
        if (!autenticacaoService.validarToken(token)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
