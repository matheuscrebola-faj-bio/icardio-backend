package br.com.fajbio.icardio.api.mapper;

import br.com.fajbio.icardio.api.dto.ExameReq;
import br.com.fajbio.icardio.domain.model.Documento;
import br.com.fajbio.icardio.domain.model.Exame;
import br.com.fajbio.icardio.domain.model.Unidade;
import br.com.fajbio.icardio.domain.model.Usuario;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ExameMapper {
    public Exame mapear(ExameReq req, Unidade unidade, Usuario usuario, Documento documento){
        return Exame.builder()
                .tipo(req.tipo())
                .documento(req.documento())
                .nome(req.nome())
                .nascimento(req.nascimento())
                .peso(req.peso())
                .altura(req.altura())
                .imc(req.imc())
                .sintoma(req.sintoma())
                .antecedente(req.antecedente())
                .observacoes(req.observacoes())
                .exame(documento)
                .datahora(LocalDateTime.now())
                .unidade(unidade)
                .usuario(usuario)
                .build();
    }
}
