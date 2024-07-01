package com.retexspa.xr.ms.masterdata.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public class TabCasseQueryDTO {
    private String id;
    private String codice;
    private String nome;
    private String descrizione;
    private String gerarchiaId;
    private String tipoCassaId;
    private Boolean attiva;
    private String flgCancellato;
    private LocalDateTime dataCancellazione;
    private Long version;
}
