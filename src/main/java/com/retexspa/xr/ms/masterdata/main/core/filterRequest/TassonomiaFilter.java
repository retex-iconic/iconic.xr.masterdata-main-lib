package com.retexspa.xr.ms.masterdata.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;

public class TassonomiaFilter {

    private String id;
    private String nome;
    private String codice;
    private String descrizione;
    private String tipoTassonomiaId;
    private String gerarchiaId;
    private String nodoId;
    private String padreId;
    private Long version;

    public TassonomiaFilter(@JsonProperty("id") String id,
                            @JsonProperty("nome") String nome,
                            @JsonProperty("codice") String codice,
                            @JsonProperty("descrizione") String descrizione,
                            @JsonProperty("tipoTassonomiaId") String tipoTassonomiaId,
                            @JsonProperty("gerarchiaId") String gerarchiaId,
                            @JsonProperty("nodoId") String nodoId,
                            @JsonProperty("padreId") String padreId,
                            @JsonProperty("version") Long version) {
        this.id = id;
        this.nome = nome;
        this.codice = codice;
        this.descrizione = descrizione;
        this.tipoTassonomiaId = tipoTassonomiaId;
        this.gerarchiaId = gerarchiaId;
        this.nodoId = nodoId;
        this.padreId = padreId;
        this.version = version;
    }

    public TassonomiaFilter() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getTipoTassonomiaId() {
        return tipoTassonomiaId;
    }

    public void setTipoTassonomiaId(String tipoTassonomiaId) {
        this.tipoTassonomiaId = tipoTassonomiaId;
    }

    public String getGerarchiaId() {
        return gerarchiaId;
    }

    public void setGerarchiaId(String gerarchiaId) {
        this.gerarchiaId = gerarchiaId;
    }

    public String getNodoId() {
        return nodoId;
    }

    public void setNodoId(String nodoId) {
        this.nodoId = nodoId;
    }

    public String getPadreId() {
        return padreId;
    }

    public void setPadreId(String padreId) {
        this.padreId = padreId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public static TassonomiaFilter createFilterFromMap(Object obj) {
        // LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;

        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(obj);

            LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);

            TassonomiaFilter filter = new TassonomiaFilter();
            if (map != null) {
                filter.setId((String) map.get("id"));
                filter.setCodice((String) map.get("codice"));
                filter.setNome((String) map.get("nome"));
                filter.setDescrizione((String) map.get("descrizione"));
                filter.setTipoTassonomiaId((String) map.get("tipoTassonomiaId"));
                filter.setGerarchiaId((String) map.get("gerarchiaId"));
                filter.setNodoId((String) map.get("nodoId"));
                filter.setPadreId((String) map.get("padreId"));
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

}
