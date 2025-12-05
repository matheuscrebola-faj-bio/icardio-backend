package br.com.fajbio.icardio.domain.model.auxiliares;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Sintoma {
    private String dor;
    private String desmaio;
    private String ar;
    private String palpitacoes;
}
