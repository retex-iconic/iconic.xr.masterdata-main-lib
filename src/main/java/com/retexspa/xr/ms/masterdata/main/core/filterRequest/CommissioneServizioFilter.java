package com.retexspa.xr.ms.masterdata.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;

public class CommissioneServizioFilter {

    private String id;

    private String gerarchiaId;

    private String anagraficaServizioId;

    private String articoloId;

    private String flgDefault;

    private String profilo;
    private Long version;

    public CommissioneServizioFilter() {}

    public CommissioneServizioFilter(
            @JsonProperty("id") String id,
            @JsonProperty("gerarchiaId") String gerarchiaId,
            @JsonProperty("anagraficaServizioId") String anagraficaServizioId,
            @JsonProperty("articoloId") String articoloId,
            @JsonProperty("flgDefault") String flgDefault,
            @JsonProperty("profilo") String profilo,
            @JsonProperty("version") Long version) {

        this.id = id;
        this.gerarchiaId = gerarchiaId;
        this.anagraficaServizioId = anagraficaServizioId;
        this.articoloId = articoloId;
        this.flgDefault = flgDefault;
        this.profilo = profilo;
        this.version = version;
    }

    public static CommissioneServizioFilter createFilterFromMap(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(obj);

            LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);

            CommissioneServizioFilter filter = new CommissioneServizioFilter();
            if (map != null) {
                filter.setId((String) map.get("id"));
                filter.setGerarchiaId((String) map.get("gerarchiaId"));
                filter.setAnagraficaServizioId((String) map.get("anagraficaServizioId"));
                filter.setArticoloId((String) map.get("articoloId"));
                filter.setFlgDefault((String) map.get("flgDefault"));
                filter.setProfilo((String) map.get("profilo"));
                Object version = map.get("version");
                if (version != null) {
                    if (version instanceof Integer) {
                        filter.setVersion(Long.valueOf((Integer) version));
                    } else if (version instanceof Long) {
                        filter.setVersion((Long) version);
                    }
                }
            }
            return filter;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    

    public String getGerarchiaId() {
        return gerarchiaId;
    }

    public void setGerarchiaId(String gerarchiaId) {
        this.gerarchiaId = gerarchiaId;
    }

    public String getAnagraficaServizioId() {
        return anagraficaServizioId;
    }

    public void setAnagraficaServizioId(String anagraficaServizioId) {
        this.anagraficaServizioId = anagraficaServizioId;
    }

    public String getArticoloId() {
        return articoloId;
    }

    public void setArticoloId(String articoloId) {
        this.articoloId = articoloId;
    }

    public String getFlgDefault() {
        return flgDefault;
    }

    public void setFlgDefault(String flgDefault) {
        this.flgDefault = flgDefault;
    }

    public String getProfilo() {
        return profilo;
    }

    public void setProfilo(String profilo) {
        this.profilo = profilo;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
