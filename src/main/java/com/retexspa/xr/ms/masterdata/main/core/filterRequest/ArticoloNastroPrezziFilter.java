package com.retexspa.xr.ms.masterdata.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;

public class ArticoloNastroPrezziFilter {
    private String id;
    private String codice;
    private Double prezzoVendita;
    private LocalDateTime dataOraInizio;
    private LocalDateTime dataOraFine;
    private String padreId;
    private String gerarchiaId;
    private String articoloId;
    private Long version;

    public ArticoloNastroPrezziFilter() {}

    public ArticoloNastroPrezziFilter(
            @JsonProperty("id") String id,
            @JsonProperty("codice") String codice,
            @JsonProperty("prezzoVendita") Double prezzoVendita,
            @JsonProperty("dataOraInizio") LocalDateTime dataOraInizio,
            @JsonProperty("dataOraFine") LocalDateTime dataOraFine,
            @JsonProperty("padreId") String padreId,
            @JsonProperty("gerarchiaId") String gerarchiaId,
            @JsonProperty("articoloId") String articoloId,
            @JsonProperty("version") Long version) {
        this.id = id;
        this.codice = codice;
        this.prezzoVendita = prezzoVendita;
        this.dataOraInizio = dataOraInizio;
        this.dataOraFine = dataOraFine;
        this.padreId = padreId;
        this.gerarchiaId = gerarchiaId;
        this.articoloId = articoloId;
        this.version = version;
    }

    public static ArticoloNastroPrezziFilter createFilterFromMap(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(obj);

            LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);

            ArticoloNastroPrezziFilter filter = new ArticoloNastroPrezziFilter();
            if (map != null) {
                filter.setId((String) map.get("id"));
                filter.setCodice((String) map.get("codice"));
                filter.setPrezzoVendita((Double) map.get("prezzoVendita"));
                filter.setDataOraInizio((LocalDateTime) map.get("dataOraInizio"));
                filter.setDataOraFine((LocalDateTime) map.get("dataOraFine"));
                filter.setPadreId((String) map.get("padreId"));
                filter.setGerarchiaId((String) map.get("gerarchiaId"));
                filter.setArticoloId((String) map.get("articoloId"));

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

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public Double getPrezzoVendita() {
        return prezzoVendita;
    }

    public void setPrezzoVendita(Double prezzoVendita) {
        this.prezzoVendita = prezzoVendita;
    }

    public LocalDateTime getDataOraInizio() {
        return dataOraInizio;
    }

    public void setDataOraInizio(LocalDateTime dataOraInizio) {
        this.dataOraInizio = dataOraInizio;
    }

    public LocalDateTime getDataOraFine() {
        return dataOraFine;
    }

    public void setDataOraFine(LocalDateTime dataOraFine) {
        this.dataOraFine = dataOraFine;
    }

    public String getPadreId() {
        return padreId;
    }

    public void setPadreId(String padreId) {
        this.padreId = padreId;
    }

    public String getGerarchiaId() {
        return gerarchiaId;
    }

    public void setGerarchiaId(String gerarchiaId) {
        this.gerarchiaId = gerarchiaId;
    }

    public String getArticoloId() {
        return articoloId;
    }

    public void setArticoloId(String articoloId) {
        this.articoloId = articoloId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
