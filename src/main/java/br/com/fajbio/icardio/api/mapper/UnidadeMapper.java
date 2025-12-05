package br.com.fajbio.icardio.api.mapper;

import br.com.fajbio.icardio.api.dto.UnidadeReq;
import br.com.fajbio.icardio.domain.model.Unidade;
import org.springframework.stereotype.Component;

@Component
public class UnidadeMapper {
    public Unidade mapear(UnidadeReq req) {
        return Unidade.builder()
                .nome(req.nome())
                .apelido(req.apelido())
                .cnpj(req.cnpj())
                .cidade(req.cidade())
                .estado(req.estado())
                .endereco(req.endereco())
                .contato(req.contato())
                .email(req.email())
                .telefone(req.telefone())
                .build();
    }
}
