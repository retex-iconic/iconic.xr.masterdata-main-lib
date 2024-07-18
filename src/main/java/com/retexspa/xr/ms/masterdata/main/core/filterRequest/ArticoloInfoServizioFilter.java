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
public class ArticoloInfoServizioFilter {
    private String id;
    private String gerarchiaId;
    private String articoloId;
    private String servizioId;
    private String flgCancellato;
    private Long version;
    private LocalDateTime dataCancellazione;
    public ArticoloInfoServizioFilter() {
    }

    public ArticoloInfoServizioFilter(@JsonProperty("id") String id,
                                      @JsonProperty("gerarchiaId") String gerarchiaId,
                                      @JsonProperty("articoloId") String articoloId,
                                      @JsonProperty("servizioId") String servizioId,
                                      @JsonProperty("flgCancellato") String flgCancellato,
                                      @JsonProperty("dataCancellazione") LocalDateTime dataCancellazione,
                                      @JsonProperty("version") Long version) {
        this.id = id;
        this.gerarchiaId = gerarchiaId;
        this.articoloId = articoloId;
        this.servizioId = servizioId;
        this.flgCancellato = flgCancellato;
        this.dataCancellazione = dataCancellazione;
        this.version = version;
    }
    public static ArticoloInfoServizioFilter createFilterFromMap(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(obj);
            LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);
            ArticoloInfoServizioFilter filter = new ArticoloInfoServizioFilter();
            if (map != null) {
                filter.setId((String) map.get("id"));
                filter.setArticoloId((String) map.get("articoloId"));
                filter.setServizioId((String) map.get("servizioId"));
                filter.setGerarchiaId((String) map.get("gerarchiaId"));
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
