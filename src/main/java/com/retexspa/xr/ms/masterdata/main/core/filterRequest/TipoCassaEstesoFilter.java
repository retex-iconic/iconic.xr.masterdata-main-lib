package com.retexspa.xr.ms.masterdata.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;

@Getter
@Setter
public class TipoCassaEstesoFilter {

    private String id;
    private String codice;
    private String nome;
    private String descrizione;
    private String tipoCassaId;
    private String flgCancellato;
    private LocalDateTime dataCancellazione;
    private Long version;

    public TipoCassaEstesoFilter() {
    }

    public TipoCassaEstesoFilter(@JsonProperty("id") String id,
                           @JsonProperty("codice") String codice,
                           @JsonProperty("nome") String nome,
                           @JsonProperty("descrizione") String descrizione,
                           @JsonProperty("tipoCassaId") String tipoCassaId,
                           @JsonProperty("flgCancellato") String flgCancellato,
                           @JsonProperty("dataCancellazione") LocalDateTime dataCancellazione,
                           @JsonProperty("version") Long version) {
        this.id = id;
        this.codice = codice;
        this.nome = nome;
        this.descrizione = descrizione;
        this.tipoCassaId = tipoCassaId;
        this.flgCancellato = flgCancellato;
        this.dataCancellazione = dataCancellazione;
        this.version = version;
    }
    public static TipoCassaEstesoFilter createFilterFromMap(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(obj);
            LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);
            TipoCassaEstesoFilter filter = new TipoCassaEstesoFilter();
            if (map != null) {
                filter.setId((String) map.get("id"));
                filter.setCodice((String) map.get("codice"));
                filter.setNome((String) map.get("nome"));
                filter.setDescrizione((String) map.get("descrizione"));
                filter.setTipoCassaId((String) map.get("tipoCassaId"));
                filter.setFlgCancellato((String) map.get("flgCancellato"));
                DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
                Object dataCancellazione = map.get("dataCancellazione");
                if (dataCancellazione != null) {
                    if (dataCancellazione instanceof String) {
                        filter.setDataCancellazione(
                                LocalDateTime.parse((String) map.get("dataCancellazione"), formatter));
                    } else if (dataCancellazione instanceof LocalDateTime) {
                        filter.setDataCancellazione((LocalDateTime) dataCancellazione);
                    }
                }
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
