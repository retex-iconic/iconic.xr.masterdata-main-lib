package com.retexspa.xr.ms.masterdata.main.core.dto.tabCasseEstesa;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class TabCasseEstesaDTO extends TabCasseEstesaBaseDTO {
    private String id;
}
