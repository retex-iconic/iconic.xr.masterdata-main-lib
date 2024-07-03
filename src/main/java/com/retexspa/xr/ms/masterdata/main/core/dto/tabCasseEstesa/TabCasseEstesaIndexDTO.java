package com.retexspa.xr.ms.masterdata.main.core.dto.tabCasseEstesa;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class TabCasseEstesaIndexDTO {

    private String tabCasseEstesaId;

    public TabCasseEstesaIndexDTO() {
    }

    public TabCasseEstesaIndexDTO(String tabCasseEstesaId) {
        this.tabCasseEstesaId = tabCasseEstesaId;
    }

    public static String getIdFromTabCasseEstesa(String tabCasseEstesaId) {
        return UUID.nameUUIDFromBytes(("/TabCasseEstesaIndex/" + tabCasseEstesaId).getBytes()).toString();
    }

}
