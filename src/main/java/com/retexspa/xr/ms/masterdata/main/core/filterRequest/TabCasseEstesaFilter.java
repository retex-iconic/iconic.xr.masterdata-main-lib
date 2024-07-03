package com.retexspa.xr.ms.masterdata.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;

@Getter
@Setter
public class TabCasseEstesaFilter {

    private String id;
    private String cassaId;
    private LocalDate dataInizio;
    private String tipoCassaEstesoId;
    private String flgCancellato;
    private LocalDateTime dataCancellazione;
    private Long version;

    public TabCasseEstesaFilter() {
    }

    public TabCasseEstesaFilter(@JsonProperty("id") String id,
                           @JsonProperty("cassaId") String cassaId,
                           @JsonProperty("dataInizio") LocalDate dataInizio,
                           @JsonProperty("tipoCassaEstesoId") String tipoCassaEstesoId,
                           @JsonProperty("flgCancellato") String flgCancellato,
                           @JsonProperty("dataCancellazione") LocalDateTime dataCancellazione,
                           @JsonProperty("version") Long version) {
        this.id = id;
        this.cassaId = cassaId;
        this.dataInizio = dataInizio;
        this.tipoCassaEstesoId = tipoCassaEstesoId;
        this.flgCancellato = flgCancellato;
        this.dataCancellazione = dataCancellazione;
        this.version = version;
    }
    public static TabCasseEstesaFilter createFilterFromMap(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(obj);
            LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);
            TabCasseEstesaFilter filter = new TabCasseEstesaFilter();
            if (map != null) {
                filter.setId((String) map.get("id"));
                filter.setCassaId((String) map.get("cassaId"));
                filter.setTipoCassaEstesoId((String) map.get("tipoCassaEstesoId"));
                filter.setFlgCancellato((String) map.get("flgCancellato"));
                DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
                Object dataInizio = map.get("dataInizio");
                if (dataInizio != null) {
                    if (dataInizio instanceof String) {
                        filter.setDataInizio(
                                LocalDate.parse((String) map.get("dataInizio"), formatter));
                    } else if (dataInizio instanceof LocalDate) {
                        filter.setDataInizio((LocalDate) dataInizio);
                    }
                }
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
