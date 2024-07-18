package com.retexspa.xr.ms.masterdata.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;

@Getter
@Setter
public class ConfigContextFilter {
    private String id;
    private String codice;
    private String descrizione;
    private String nome;
    private String flgCancellato;
    private Long version;
    public ConfigContextFilter(){
    }
    public ConfigContextFilter(
            @JsonProperty("id") String id,
            @JsonProperty("codice") String codice,
            @JsonProperty("descrizione") String descrizione,
            @JsonProperty("nome") String nome,
            @JsonProperty("flgCancellato") String flgCancellato,
            @JsonProperty("version") Long version) {
        this.id = id;
        this.codice = codice;
        this.descrizione = descrizione;
        this.nome = nome;
        this.flgCancellato = flgCancellato;
        this.version = version;
    }
    public static ConfigContextFilter createFilterFromMap(Object obj) {

        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(obj);

            LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);

            ConfigContextFilter filter = new ConfigContextFilter();
            if (map != null) {
                filter.setId((String) map.get("id"));
                filter.setCodice((String) map.get("codice"));
                filter.setDescrizione((String) map.get("descrizione"));
                filter.setNome((String) map.get("nome"));
                filter.setFlgCancellato((String) map.get("flgCancellato"));
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
