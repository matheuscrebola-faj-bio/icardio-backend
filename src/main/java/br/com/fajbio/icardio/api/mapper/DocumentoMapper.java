package br.com.fajbio.icardio.api.mapper;

import br.com.fajbio.icardio.domain.model.Documento;
import org.springframework.stereotype.Component;

@Component
public class DocumentoMapper {
    public Documento mapear(String documento){
        return Documento.builder()
                .documento(documento)
                .build();
    }
}
