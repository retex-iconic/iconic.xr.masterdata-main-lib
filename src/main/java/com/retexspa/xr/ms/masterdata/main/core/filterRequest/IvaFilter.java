package com.retexspa.xr.ms.masterdata.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;

public class IvaFilter {

    private String id;

    private String nome;

    private String codice;

    private String descrizione;

    private String tipoIva;

    private String codIvaAcquisto;

    private Double percentuale;

    private String naturaEsenzione;

    private String normaEsenzione;

    private String codiceEsterno;

    private String codiceECommerce;

    private String gerarchiaId;

    private String padreId;
    private Long version;

    public IvaFilter() {
    }

    public IvaFilter(
            @JsonProperty("id") String id,
            @JsonProperty("nome") String nome,
            @JsonProperty("codice") String codice,
            @JsonProperty("descrizione") String descrizione,
            @JsonProperty("tipoIva") String tipoIva,
            @JsonProperty("codIvaAcquisto") String codIvaAcquisto,
            @JsonProperty("percentuale") Double percentuale,
            @JsonProperty("naturaEsenzione") String naturaEsenzione,
            @JsonProperty("normaEsenzione") String normaEsenzione,
            @JsonProperty("codiceEsterno") String codiceEsterno,
            @JsonProperty("codiceECommerce") String codiceECommerce,
            @JsonProperty("gerarchiaId") String gerarchiaId,
            @JsonProperty("padreId") String padreId,
            @JsonProperty("version") Long version) {
        this.id = id;
        this.nome = nome;
        this.codice = codice;
        this.descrizione = descrizione;
        this.tipoIva = tipoIva;
        this.codIvaAcquisto = codIvaAcquisto;
        this.percentuale = percentuale;
        this.naturaEsenzione = naturaEsenzione;
        this.normaEsenzione = normaEsenzione;
        this.codiceEsterno = codiceEsterno;
        this.codiceECommerce = codiceECommerce;
        this.gerarchiaId = gerarchiaId;
        this.padreId = padreId;
        this.version = version;
    }

    public static IvaFilter createFilterFromMap(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(obj);
            LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);
            IvaFilter filter = new IvaFilter();
            if (map != null) {
                filter.setId((String) map.get("id"));
                filter.setCodice((String) map.get("codice"));
                filter.setNome((String) map.get("nome"));
                filter.setDescrizione((String) map.get("descrizione"));
                filter.setTipoIva((String) map.get("tipoIva"));
                filter.setCodIvaAcquisto((String) map.get("codIvaAcquisto"));
                filter.setPercentuale((Double) map.get("percentuale"));
                filter.setNaturaEsenzione((String) map.get("naturaEsenzione"));
                filter.setNormaEsenzione((String) map.get("normaEsenzione"));
                filter.setCodiceEsterno((String) map.get("codiceEsterno"));
                filter.setCodiceECommerce((String) map.get("codiceECommerce"));
                filter.setGerarchiaId((String) map.get("gerarchiaId"));
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

    public String getTipoIva() {
        return tipoIva;
    }

    public void setTipoIva(String tipoIva) {
        this.tipoIva = tipoIva;
    }

    public String getCodIvaAcquisto() {
        return codIvaAcquisto;
    }

    public void setCodIvaAcquisto(String codIvaAcquisto) {
        this.codIvaAcquisto = codIvaAcquisto;
    }

    public Double getPercentuale() {
        return percentuale;
    }

    public void setPercentuale(Double percentuale) {
        this.percentuale = percentuale;
    }

    public String getNaturaEsenzione() {
        return naturaEsenzione;
    }

    public void setNaturaEsenzione(String naturaEsenzione) {
        this.naturaEsenzione = naturaEsenzione;
    }

    public String getNormaEsenzione() {
        return normaEsenzione;
    }

    public void setNormaEsenzione(String normaEsenzione) {
        this.normaEsenzione = normaEsenzione;
    }

    public String getCodiceEsterno() {
        return codiceEsterno;
    }

    public void setCodiceEsterno(String codiceEsterno) {
        this.codiceEsterno = codiceEsterno;
    }

    public String getCodiceECommerce() {
        return codiceECommerce;
    }

    public void setCodiceECommerce(String codiceECommerce) {
        this.codiceECommerce = codiceECommerce;
    }

    public String getGerarchiaId() {
        return gerarchiaId;
    }

    public void setGerarchiaId(String gerarchiaId) {
        this.gerarchiaId = gerarchiaId;
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
}
