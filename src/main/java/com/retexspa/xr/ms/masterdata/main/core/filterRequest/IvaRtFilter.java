package com.retexspa.xr.ms.masterdata.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;

public class IvaRtFilter {
    private String id;

    private String codice;

    private String descrizione;

    private String nome;

    private String rtTipoEsenzione;

    private String rtTaxCode;

    private String rtShortDesc;

    private String rtFullDesc;

    private String rtType;

    private String rtDescr;
    private String flgCancellato;
    private LocalDateTime dataCancellazione;
    private String atecoId;

    private String ivaId;

    private String gerarchiaId;

    private String padreId;
    private Long version;

    public IvaRtFilter() {}

    public IvaRtFilter(
            @JsonProperty("id") String id,
            @JsonProperty("codice") String codice,
            @JsonProperty("descrizione") String descrizione,
            @JsonProperty("nome") String nome,
            @JsonProperty("rtTipoEsenzione") String rtTipoEsenzione,
            @JsonProperty("rtTaxCode") String rtTaxCode,
            @JsonProperty("rtShortDesc") String rtShortDesc,
            @JsonProperty("rtFullDesc") String rtFullDesc,
            @JsonProperty("rtType") String rtType,
            @JsonProperty("rtDescr") String rtDescr,
            @JsonProperty("flgCancellato") String flgCancellato,
            @JsonProperty("dataCancellazione") LocalDateTime dataCancellazione,
            @JsonProperty("atecoId") String atecoId,
            @JsonProperty("ivaId") String ivaId,
            @JsonProperty("gerarchiaId") String gerarchiaId,
            @JsonProperty("padreId") String padreId,
            @JsonProperty("version") Long version) {
        this.id = id;
        this.codice = codice;
        this.descrizione = descrizione;
        this.nome = nome;
        this.rtTipoEsenzione = rtTipoEsenzione;
        this.rtTaxCode = rtTaxCode;
        this.rtShortDesc = rtShortDesc;
        this.rtFullDesc = rtFullDesc;
        this.rtType = rtType;
        this.rtDescr = rtDescr;
        this.flgCancellato = flgCancellato;
        this.dataCancellazione = dataCancellazione;
        this.atecoId = atecoId;
        this.ivaId = ivaId;
        this.gerarchiaId = gerarchiaId;
        this.padreId = padreId;
        this.version = version;
    }

    public static IvaRtFilter createFilterFromMap(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(obj);
            LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);
            IvaRtFilter filter = new IvaRtFilter();
            if (map != null) {
                filter.setId((String) map.get("id"));
                filter.setCodice((String) map.get("codice"));
                filter.setNome((String) map.get("nome"));
                filter.setDescrizione((String) map.get("descrizione"));
                filter.setRtTipoEsenzione((String) map.get("rtTipoEsenzione"));
                filter.setRtTaxCode((String) map.get("rtTaxCode"));
                filter.setRtShortDesc((String) map.get("rtShortDesc"));
                filter.setRtFullDesc((String) map.get("rtFullDesc"));
                filter.setRtType((String) map.get("rtType"));
                filter.setRtDescr((String) map.get("rtDescr"));
                filter.setFlgCancellato((String) map.get("flgCancellato"));
                filter.setDataCancellazione((LocalDateTime) map.get("dataCancellazione"));
                filter.setAtecoId((String) map.get("atecoId"));
                filter.setIvaId((String) map.get("ivaId"));
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRtTipoEsenzione() {
        return rtTipoEsenzione;
    }

    public void setRtTipoEsenzione(String rtTipoEsenzione) {
        this.rtTipoEsenzione = rtTipoEsenzione;
    }

    public String getRtTaxCode() {
        return rtTaxCode;
    }

    public void setRtTaxCode(String rtTaxCode) {
        this.rtTaxCode = rtTaxCode;
    }

    public String getRtShortDesc() {
        return rtShortDesc;
    }

    public void setRtShortDesc(String rtShortDesc) {
        this.rtShortDesc = rtShortDesc;
    }

    public String getRtFullDesc() {
        return rtFullDesc;
    }

    public void setRtFullDesc(String rtFullDesc) {
        this.rtFullDesc = rtFullDesc;
    }

    public String getRtType() {
        return rtType;
    }

    public void setRtType(String rtType) {
        this.rtType = rtType;
    }

    public String getRtDescr() {
        return rtDescr;
    }

    public void setRtDescr(String rtDescr) {
        this.rtDescr = rtDescr;
    }

    public String getFlgCancellato() {
        return flgCancellato;
    }

    public void setFlgCancellato(String flgCancellato) {
        this.flgCancellato = flgCancellato;
    }

    public LocalDateTime getDataCancellazione() {
        return dataCancellazione;
    }

    public void setDataCancellazione(LocalDateTime dataCancellazione) {
        this.dataCancellazione = dataCancellazione;
    }

    public String getAtecoId() {
        return atecoId;
    }

    public void setAtecoId(String atecoId) {
        this.atecoId = atecoId;
    }

    public String getIvaId() {
        return ivaId;
    }

    public void setIvaId(String ivaId) {
        this.ivaId = ivaId;
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
