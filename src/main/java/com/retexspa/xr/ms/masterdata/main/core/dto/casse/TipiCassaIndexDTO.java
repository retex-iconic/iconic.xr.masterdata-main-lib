package com.retexspa.xr.ms.masterdata.main.core.dto.casse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class TipiCassaIndexDTO {
    private String tipiCassaId;
    private LinkedList<String> tabCasseIds;
    private LinkedList<String> tipoCassaEstesoIds;

    public TipiCassaIndexDTO() {
    }

    public TipiCassaIndexDTO(String tipiCassaId) {
        this.tipiCassaId = tipiCassaId;
    }

    public static String getIdFromTipiCassa(String tipiCassaId) {
        return UUID.nameUUIDFromBytes(("/TipiCassaIndex/" + tipiCassaId).getBytes()).toString();
    }


    public static String getDetailTipoCassaEsteso() {
        return "tipoCassaEstesoIds";
    }

    public static String getDetailNameTabCasse() {
        return "tabCasseIds";
    }

}

