package com.retexspa.xr.ms.masterdata.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;

public class ConfigFilter {

    private String id;
    private String codice;
    private String descrizione;
    private String nome;
    private String flgAttivo;
    private String flgCancellato;
    private String nodoId;
    private String contextId;
    private Long version;

    public ConfigFilter(
            @JsonProperty("id") String id,
            @JsonProperty("nome") String nome,
            @JsonProperty("codice") String codice,
            @JsonProperty("descrizione") String descrizione,
            @JsonProperty("flgAttivo") String flgAttivo,
            @JsonProperty("flgCancellato") String flgCancellato,
            @JsonProperty("nodoId") String nodoId,
            @JsonProperty("contexId") String contextId,
            @JsonProperty("version") Long version) {

        this.id = id;
        this.codice = codice;
        this.descrizione = descrizione;
        this.nome = nome;
        this.flgAttivo = flgAttivo;
        this.flgCancellato = flgCancellato;
        this.nodoId = nodoId;
        this.contextId = contextId;
        this.version = version;
    }

    public ConfigFilter() {

    }

    public static ConfigFilter createFilterFromMap(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(obj);
            LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);
            ConfigFilter filter = new ConfigFilter();
            if (map != null) {
                filter.setId((String) map.get("id"));
                filter.setCodice((String) map.get("codice"));
                filter.setNome((String) map.get("nome"));
                filter.setDescrizione((String) map.get("descrizione"));
                filter.setFlgAttivo((String) map.get("flgAttivo"));
                filter.setFlgCancellato((String) map.get("flgCancellato"));
                filter.setNodoId((String) map.get("nodoId"));
                filter.setContextId((String) map.get("contextId"));

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
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodice() {
        return this.codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFlgAttivo() {
        return this.flgAttivo;
    }

    public void setFlgAttivo(String flgAttivo) {
        this.flgAttivo = flgAttivo;
    }

    public String getFlgCancellato() {
        return this.flgCancellato;
    }

    public void setFlgCancellato(String flgCancellato) {
        this.flgCancellato = flgCancellato;
    }

    public String getNodoId() {
        return this.nodoId;
    }

    public void setNodoId(String nodoId) {
        this.nodoId = nodoId;
    }

    public String getContextId() {
        return this.contextId;
    }

    public void setContextId(String contextId) {
        this.contextId = contextId;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
