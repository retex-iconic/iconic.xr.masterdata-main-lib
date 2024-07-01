package com.retexspa.xr.ms.masterdata.main.core.dto.casse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class TabCasseIndexDTO {
    private String tabCasseId;
    private LinkedList<String> tabCasseEstesaIds;

    public TabCasseIndexDTO() {
    }

    public TabCasseIndexDTO(String tabCasseId) {
        this.tabCasseId = tabCasseId;
    }

    public static String getIdFromTabCasse(String tabCassaId) {
        return UUID.nameUUIDFromBytes(("/TabCasseIndex/" + tabCassaId).getBytes()).toString();
    }


    public static String getDetailNameTabCasseEstesa() {
        return "tabCasseEstesaIds";
    }

}


