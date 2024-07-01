package com.retexspa.xr.ms.masterdata.main.core.dto.casse;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.dto.attributo.AttributoValoreDTO;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@Setter
public class TabCasseBaseDTO {
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
    @NotNull(message = "gerarchiaId is mandatory")
    @NotEmpty(message = "gerarchiaId is mandatory")
    @NotBlank(message = "gerarchiaId is mandatory")
    private String gerarchiaId;
    @NotNull(message = "tipoCassaId is mandatory")
    @NotEmpty(message = "tipoCassaId is mandatory")
    @NotBlank(message = "tipoCassaId is mandatory")
    private String tipoCassaId;
    @NotNull(message = "attiva is mandatory")
    private Boolean attiva;
    private List<AttributoValoreDTO> attributes;
    @EnumValidator(enumClazz = Enums.CheckSN.class, message = "FlgCancellato not valid")
    private String flgCancellato;

    @JsonIgnore
    public String getAggregateId() {
        return UUID.randomUUID().toString();
    }

    public static String getName() {
        return "TabCasse";
    }

    public static String getAggregateName() {
        return "TabCasseAggregate";
    }

}
