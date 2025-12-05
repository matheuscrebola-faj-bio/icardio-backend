package br.com.fajbio.icardio.api.mapper;

import br.com.fajbio.icardio.api.dto.ExameReq;
import br.com.fajbio.icardio.api.dto.PacienteRes;
import br.com.fajbio.icardio.domain.model.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PacienteMapper {

    public PacienteRes mapear(Paciente paciente){
        return PacienteRes.builder()
                .id(paciente.getId())
                .nome(paciente.getNome())
                .dataexame(paciente.getDataexame())
                .build();
    }

    public List<PacienteRes> mapear(List<Paciente> pacientes) {
        return pacientes.stream()
                .map(this::mapear)
                .collect(Collectors.toList());
    }

    public Paciente mapear(ExameReq req, Documento doc, Unidade uni, Usuario usr, Exame exa) {
        return Paciente.builder()
                .nome(req.nome())
                .dataexame(LocalDateTime.now().toString())
                .documento(doc)
                .unidade(uni)
                .usuario(usr)
                .exame(exa)
                .build();
    }
}
