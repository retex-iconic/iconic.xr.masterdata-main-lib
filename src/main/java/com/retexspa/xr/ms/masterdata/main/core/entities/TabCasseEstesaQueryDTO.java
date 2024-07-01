package com.retexspa.xr.ms.masterdata.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import com.retexspa.xr.ms.masterdata.main.core.dto.Enums;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public class TabCasseEstesaQueryDTO {

    private String id;

    private String cassaId;

    private LocalDate dataInizio;

    private String tipoCassaEstesoId;

    private String flgCancellato;

    private LocalDateTime dataCancellazione;

    private Long version;

}
