package br.com.fajbio.icardio.api.mapper;

import br.com.fajbio.icardio.api.dto.ExameReq;
import br.com.fajbio.icardio.domain.model.Documento;
import br.com.fajbio.icardio.domain.model.Exame;
import br.com.fajbio.icardio.domain.model.Unidade;
import br.com.fajbio.icardio.domain.model.Usuario;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Component
public class ExameMapper {
    public Exame mapear(ExameReq req, Unidade unidade, Usuario usuario){
        return Exame.builder()
                .tipo(req.tipo())
                .documento(req.documento())
                .nome(req.nome())
                .nascimento(req.nascimento())
                .peso(req.peso())
                .altura(req.altura())
                .imc(calcularIMC(req.altura(),req.peso()))
                .sintoma(req.sintoma())
                .antecedente(req.antecedente())
                .observacoes(req.observacoes())
                .datahora(LocalDateTime.now())
                .unidade(unidade)
                .usuario(usuario)
                .build();
    }

    protected BigDecimal calcularIMC(BigDecimal altura, BigDecimal peso){
        byte escala = 2;
        BigDecimal alturaQuadrado = altura.multiply(altura);
        return peso.divide(alturaQuadrado, escala, RoundingMode.HALF_UP);
    }
}
