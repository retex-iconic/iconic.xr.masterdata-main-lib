package com.retexspa.xr.ms.masterdata.main.core.dto.tipoCassaEsteso;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class TipoCassaEstesoIndexDTO {
    private String tipoCassaEstesoId;
    private LinkedList<String> tabCasseEstessaIds;

    public TipoCassaEstesoIndexDTO() {
    }

    public TipoCassaEstesoIndexDTO(String tipoCassaEstesoId) {
        this.tipoCassaEstesoId = tipoCassaEstesoId;
    }

    public static String getIdFromTipoCassaEsteso(String tipoCassaEstesoId) {
        return UUID.nameUUIDFromBytes(("/TipoCassaEstesoIndex/" + tipoCassaEstesoId).getBytes()).toString();
    }


    public static String getDetailNameTabCasseEstessaIds() {
        return "tabCasseEstessaIds";
    }


}
