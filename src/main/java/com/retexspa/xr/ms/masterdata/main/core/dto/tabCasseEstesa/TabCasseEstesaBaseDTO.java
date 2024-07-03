package com.retexspa.xr.ms.masterdata.main.core.dto.tabCasseEstesa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import com.retexspa.xr.ms.masterdata.main.core.dto.Enums;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@Setter
public class TabCasseEstesaBaseDTO {

    @NotNull(message = "cassaId is mandatory")
    @NotEmpty(message = "cassaId is mandatory")
    @NotBlank(message = "cassaId is mandatory")
    private String cassaId;

    @NotNull(message = "dataInizio is mandatory")
    private LocalDate dataInizio;

    @NotNull(message = "tipoCassaEstesoId is mandatory")
    @NotEmpty(message = "tipoCassaEstesoId is mandatory")
    @NotBlank(message = "tipoCassaEstesoId is mandatory")
    private String tipoCassaEstesoId;

    @EnumValidator(enumClazz = Enums.CheckSN.class, message = "FlgCancellato not valid")
    private String flgCancellato;

    @JsonIgnore
    public String getAggregateId() {
        return UUID.randomUUID().toString();
    }

    public static String getName() {
        return "TabCasseEstesa";
    }

    public static String getAggregateName() {
        return "TabCasseEstesaAggregate";
    }

}
