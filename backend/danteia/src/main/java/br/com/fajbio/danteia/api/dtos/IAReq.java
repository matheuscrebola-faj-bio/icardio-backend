package br.com.fajbio.danteia.api.dtos;

import java.math.BigDecimal;

public record IAReq(
        BigDecimal altura,
        BigDecimal peso,
        BigDecimal fc,
        Byte idade,
        String marcapasso,
        String sexo,
        Ondas p,
        Ondas pri,
        Ondas qrs,
        Ondas qt,
        Ondas qtc,
        Ondas rr
        ) {
}
