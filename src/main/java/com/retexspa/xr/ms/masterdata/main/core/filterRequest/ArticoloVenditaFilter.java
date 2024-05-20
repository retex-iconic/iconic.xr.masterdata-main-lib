package com.retexspa.xr.ms.masterdata.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;

public class ArticoloVenditaFilter {
    private String id;
    private String nome;
    private String codice;
    private String descrizione;
    private String articoloId;
    private String gerarchiaId;
    private String padreId;
    private String statoId;
    private String tipoArticoloVenditaId;
    private String sottotipoArticoloVenditaId;
    private String repartoId;
    private String ivaId;
    private Double costo;
    private Integer tara;
    private Integer maxArt;
    private LocalDateTime dataOraInizio;
    private LocalDateTime dataOraFine;
    private String oraFine;
    private String oraInizio;
    private Integer aa3;
    private Integer aa4;
    private String flgCancellato;
    private LocalDateTime dataCancellazione;
    private Long version;

    public ArticoloVenditaFilter() {}

    public ArticoloVenditaFilter(
            @JsonProperty("id") String id,
            @JsonProperty("nome") String nome,
            @JsonProperty("codice") String codice,
            @JsonProperty("descrizione") String descrizione,
            @JsonProperty("articoloId") String articoloId,
            @JsonProperty("gerarchiaId") String gerarchiaId,
            @JsonProperty("padreId") String padreId,
            @JsonProperty("statoId") String statoId,
            @JsonProperty("tipoArticoloVenditaId") String tipoArticoloVenditaId,
            @JsonProperty("sottotipoArticoloVenditaId") String sottotipoArticoloVenditaId,
            @JsonProperty("repartoId") String repartoId,
            @JsonProperty("ivaId") String ivaId,
            @JsonProperty("costo") Double costo,
            @JsonProperty("tara") Integer tara,
            @JsonProperty("maxArt") Integer maxArt,
            @JsonProperty("dataOraInizio") LocalDateTime dataOraInizio,
            @JsonProperty("dataOraFine") LocalDateTime dataOraFine,
            @JsonProperty("oraFine") String oraFine,
            @JsonProperty("oraInizio") String oraInizio,
            @JsonProperty("aa3") Integer aa3,
            @JsonProperty("aa4") Integer aa4,
            @JsonProperty("flgCancellato") String flgCancellato,
            @JsonProperty("dataCancellazione") LocalDateTime dataCancellazione,
            @JsonProperty("version") Long version) {
        this.id = id;
        this.nome = nome;
        this.codice = codice;
        this.descrizione = descrizione;
        this.articoloId = articoloId;
        this.gerarchiaId = gerarchiaId;
        this.padreId = padreId;
        this.statoId = statoId;
        this.tipoArticoloVenditaId = tipoArticoloVenditaId;
        this.sottotipoArticoloVenditaId = sottotipoArticoloVenditaId;
        this.repartoId = repartoId;
        this.ivaId = ivaId;
        this.costo = costo;
        this.tara = tara;
        this.maxArt = maxArt;
        this.dataOraInizio = dataOraInizio;
        this.dataOraFine = dataOraFine;
        this.oraFine = oraFine;
        this.oraInizio = oraInizio;
        this.aa3 = aa3;
        this.aa4 = aa4;
        this.flgCancellato = flgCancellato;
        this.dataCancellazione = dataCancellazione;
        this.version = version;
    }

    public static ArticoloVenditaFilter createFilterFromMap(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(obj);

            LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);

            ArticoloVenditaFilter filter = new ArticoloVenditaFilter();
            if (map != null) {
                filter.setId((String) map.get("id"));
                filter.setCodice((String) map.get("codice"));
                filter.setNome((String) map.get("nome"));
                filter.setDescrizione((String) map.get("descrizione"));
                filter.setArticoloId((String) map.get("articoloId"));
                filter.setGerarchiaId((String) map.get("gerarchiaId"));
                filter.setPadreId((String) map.get("padreId"));
                filter.setStatoId((String) map.get("statoId"));
                filter.setTipoArticoloVenditaId((String) map.get("tipoArticoloVenditaId"));
                filter.setSottotipoArticoloVenditaId((String) map.get("sottotipoArticoloVenditaId"));
                filter.setRepartoId((String) map.get("repartoId"));
                filter.setIvaId((String) map.get("ivaId"));
                filter.setTara((Integer) map.get("tara"));
                filter.setMaxArt((Integer) map.get("maxArt"));
                filter.setCosto((Double) map.get("costo"));
                filter.setDataOraInizio((LocalDateTime) map.get("dataOraInizio"));
                filter.setDataOraFine((LocalDateTime) map.get("dataOraFine"));
                filter.setOraFine((String) map.get("oraFine"));
                filter.setOraInizio((String) map.get("oraInizio"));
                filter.setAa3((Integer) map.get("aa3"));
                filter.setAa4((Integer) map.get("aa4"));
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

    public String getArticoloId() {
        return articoloId;
    }

    public void setArticoloId(String articoloId) {
        this.articoloId = articoloId;
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

    public String getStatoId() {
        return statoId;
    }

    public void setStatoId(String statoId) {
        this.statoId = statoId;
    }

    public String getTipoArticoloVenditaId() {
        return tipoArticoloVenditaId;
    }

    public void setTipoArticoloVenditaId(String tipoArticoloVenditaId) {
        this.tipoArticoloVenditaId = tipoArticoloVenditaId;
    }

    public String getSottotipoArticoloVenditaId() {
        return sottotipoArticoloVenditaId;
    }

    public void setSottotipoArticoloVenditaId(String sottotipoArticoloVenditaId) {
        this.sottotipoArticoloVenditaId = sottotipoArticoloVenditaId;
    }

    public String getRepartoId() {
        return repartoId;
    }

    public void setRepartoId(String repartoId) {
        this.repartoId = repartoId;
    }

    public String getIvaId() {
        return ivaId;
    }

    public void setIvaId(String ivaId) {
        this.ivaId = ivaId;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Integer getTara() {
        return tara;
    }

    public void setTara(Integer tara) {
        this.tara = tara;
    }

    public Integer getMaxArt() {
        return maxArt;
    }

    public void setMaxArt(Integer maxArt) {
        this.maxArt = maxArt;
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

    public String getOraFine() {
        return oraFine;
    }

    public void setOraFine(String oraFine) {
        this.oraFine = oraFine;
    }

    public String getOraInizio() {
        return oraInizio;
    }

    public void setOraInizio(String oraInizio) {
        this.oraInizio = oraInizio;
    }

    public Integer getAa3() {
        return aa3;
    }

    public void setAa3(Integer aa3) {
        this.aa3 = aa3;
    }

    public Integer getAa4() {
        return aa4;
    }

    public void setAa4(Integer aa4) {
        this.aa4 = aa4;
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
