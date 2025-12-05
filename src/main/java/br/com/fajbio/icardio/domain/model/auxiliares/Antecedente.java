package br.com.fajbio.icardio.domain.model.auxiliares;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Antecedente {
    private String dor;
    private String marcapasso;
    private String arritmia;
    private String diabetes;
    private String infarto;
    private String hipertensao;
    private String insuficiencia;
    private String cirugia;
    private String tabagismo;
    private String colesterol;
    private String avc;
}
