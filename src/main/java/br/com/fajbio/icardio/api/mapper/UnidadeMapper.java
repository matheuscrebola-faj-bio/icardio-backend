package br.com.fajbio.icardio.api.mapper;

import br.com.fajbio.icardio.api.dto.UnidadeReq;
import br.com.fajbio.icardio.api.dto.UnidadeRes;
import br.com.fajbio.icardio.domain.model.Unidade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<UnidadeRes> mapear(List<Unidade> unidades) {
        return unidades.stream().map(this::mapear).collect(Collectors.toList());
    }

    public UnidadeRes mapear(Unidade unidade){
        return UnidadeRes.builder()
                .id(unidade.getId())
                .nome(unidade.getNome())
                .apelido(unidade.getApelido())
                .cnpj(unidade.getCnpj())
                .cidade(unidade.getCidade())
                .estado(unidade.getEstado())
                .endereco(unidade.getEndereco())
                .contato(unidade.getContato())
                .email(unidade.getEmail())
                .telefone(unidade.getTelefone())
                .build();
    }

}
