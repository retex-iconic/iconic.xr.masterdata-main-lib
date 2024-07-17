package com.retexspa.xr.ms.masterdata.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;

public class VariazioniCausaliFilter {

    private String id;
    private String nome;
    private String codice;
    private String description;
    private String tipologiaVariazione;
    private Integer priorita;
    private String flgAttiva;
    private String gerarchiaId;
    private Long version;
    private String padreId;
    private String flgCancellato;
    private LocalDateTime dataCancellazione;

    public VariazioniCausaliFilter(
            @JsonProperty("id") String id,
            @JsonProperty("nome") String nome,
            @JsonProperty("codice") String codice,
            @JsonProperty("description") String description,
            @JsonProperty("tipologiaVariazione") String tipologiaVariazione,
            @JsonProperty("priorita") Integer priorita,
            @JsonProperty("flgAttiva") String flgAttiva,
            @JsonProperty("gerarchiaId") String gerarchiaId,
            @JsonProperty("version") Long version,
            @JsonProperty("padreId") String padreId,
            @JsonProperty("flgCancellato") String flgCancellato,
            @JsonProperty("dataCancellazione") LocalDateTime dataCancellazione) {

        this.id = id;
        this.nome = nome;
        this.codice = codice;
        this.description = description;
        this.tipologiaVariazione = tipologiaVariazione;
        this.priorita = priorita;
        this.flgAttiva = flgAttiva;
        this.gerarchiaId = gerarchiaId;
        this.padreId = padreId;
        this.version = version;
        this.flgCancellato = flgCancellato;
        this.dataCancellazione = dataCancellazione;
    }

    public VariazioniCausaliFilter() {

    }

    public static VariazioniCausaliFilter createFilterFromMap(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(obj);
            LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);
            VariazioniCausaliFilter filter = new VariazioniCausaliFilter();
            if (map != null) {
                filter.setId((String) map.get("id"));
                filter.setCodice((String) map.get("codice"));
                filter.setNome((String) map.get("nome"));
                filter.setDescription((String) map.get("description"));
                filter.setTipologiaVariazione((String) map.get("tipologiaVariazione"));
                filter.setPriorita((Integer) map.get("priorita"));
                filter.setFlgAttiva((String) map.get("flgAttiva"));
                filter.setGerarchiaId((String) map.get("gerarchiaId"));

                filter.setPadreId((String) map.get("padreId"));
                filter.setFlgCancellato((String) map.get("flgCancellato"));
                filter.setDataCancellazione((LocalDateTime) map.get("dataCancellazione"));

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

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodice() {
        return this.codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTipologiaVariazione() {
        return this.tipologiaVariazione;
    }

    public void setTipologiaVariazione(String tipologiaVariazione) {
        this.tipologiaVariazione = tipologiaVariazione;
    }

    public Integer getPriorita() {
        return this.priorita;
    }

    public void setPriorita(Integer priorita) {
        this.priorita = priorita;
    }

    public String getFlgAttiva() {
        return this.flgAttiva;
    }

    public void setFlgAttiva(String flgAttiva) {
        this.flgAttiva = flgAttiva;
    }

    public String getGerarchiaId() {
        return this.gerarchiaId;
    }

    public void setGerarchiaId(String gerarchiaId) {
        this.gerarchiaId = gerarchiaId;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getPadreId() {
        return this.padreId;
    }

    public void setPadreId(String padreId) {
        this.padreId = padreId;
    }

    public String getFlgCancellato() {
        return this.flgCancellato;
    }

    public void setFlgCancellato(String flgCancellato) {
        this.flgCancellato = flgCancellato;
    }

    public LocalDateTime getDataCancellazione() {
        return this.dataCancellazione;
    }

    public void setDataCancellazione(LocalDateTime dataCancellazione) {
        this.dataCancellazione = dataCancellazione;
    }

}
