package com.retexspa.xr.ms.masterdata.main.core.dto.tipoCassaEsteso;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@Setter
public class TipoCassaEstesoBaseDTO {

    @NotNull(message = "codice is mandatory")
    @NotEmpty(message = "codice is mandatory")
    @NotBlank(message = "codice is mandatory")
    private String codice;

    @NotNull(message = "nome is mandatory")
    @NotEmpty(message = "nome is mandatory")
    @NotBlank(message = "nome is mandatory")
    private String nome;

    @NotNull(message = "descrizione is mandatory")
    @NotEmpty(message = "descrizione is mandatory")
    @NotBlank(message = "descrizione is mandatory")
    private String descrizione;

    private String tipoCassaId;

    @EnumValidator(enumClazz = Enums.CheckSN.class, message = "FlgCancellato not valid")
    private String flgCancellato;
    @JsonIgnore
    public String getAggregateId() {
        return UUID.randomUUID().toString();
    }

    public static String getName() {
        return "TipoCassaEsteso";
    }

    public static String getAggregateName() {
        return "TipoCassaEstesoAggregate";
    }
}
