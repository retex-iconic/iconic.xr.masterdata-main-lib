package com.retexspa.xr.ms.masterdata.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;

public class VariazioniRegoleMonitoraggioFilter {
    private String id;
    private String gerarchiaId;
    private String padreId;
    private String codice;
    private String nome;
    private String descrizione;
    private String schema;
    private String nomeTabella;
    private String nomeCampo;
    private String regolaConfronto;
    private String variazioniCausaliId;
    private String flgSalva;
    private String flgSalvaCancellazione;
    private String flgAttiva;
    private Long version;

    public VariazioniRegoleMonitoraggioFilter(
            @JsonProperty("id") String id,
            @JsonProperty("nome") String nome,
            @JsonProperty("codice") String codice,
            @JsonProperty("descrizione") String descrizione,
            @JsonProperty("schema") String schema,
            @JsonProperty("nomeTabella") String nomeTabella,
            @JsonProperty("nomeCampo") String nomeCampo,
            @JsonProperty("gerarchiaId") String gerarchiaId,
            @JsonProperty("version") Long version,
            @JsonProperty("padreId") String padreId,
            @JsonProperty("regolaConfronto") String regolaConfronto,
            @JsonProperty("variazioniCausaliId") String variazioniCausaliId,
            @JsonProperty("flgSalva") String flgSalva,
            @JsonProperty("flgSalvaCancellazione") String flgSalvaCancellazione,
            @JsonProperty("flgAttiva") String flgAttiva) {
        this.id = id;
        this.gerarchiaId = gerarchiaId;
        this.padreId = padreId;
        this.codice = codice;
        this.nome = nome;
        this.descrizione = descrizione;
        this.schema = schema;
        this.nomeTabella = nomeTabella;
        this.nomeCampo = nomeCampo;
        this.regolaConfronto = regolaConfronto;
        this.variazioniCausaliId = variazioniCausaliId;
        this.flgSalva = flgSalva;
        this.flgSalvaCancellazione = flgSalvaCancellazione;
        this.flgAttiva = flgAttiva;
        this.version = version;
    }

    public VariazioniRegoleMonitoraggioFilter() {

    }

    public static VariazioniRegoleMonitoraggioFilter createFilterFromMap(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(obj);
            LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);
            VariazioniRegoleMonitoraggioFilter filter = new VariazioniRegoleMonitoraggioFilter();
            if (map != null) {
                filter.setId((String) map.get("id"));
                filter.setGerarchiaId((String) map.get("gerarchiaId"));
                filter.setPadreId((String) map.get("padreId"));
                filter.setCodice((String) map.get("codice"));
                filter.setNome((String) map.get("nome"));
                filter.setDescrizione((String) map.get("descrizione"));
                filter.setSchema((String) map.get("schema"));
                filter.setNomeTabella((String) map.get("nomeTabella"));
                filter.setNomeCampo((String) map.get("nomeCampo"));
                filter.setRegolaConfronto((String) map.get("regolaConfronto"));
                filter.setVariazioniCausaliId((String) map.get("variazionicausaliId"));
                filter.setFlgSalva((String) map.get("flgSalva"));
                filter.setFlgSalvaCancellazione((String) map.get("flgSalvaCancellazione"));
                filter.setFlgAttiva((String) map.get("flgAttiva"));

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

    public String getGerarchiaId() {
        return this.gerarchiaId;
    }

    public void setGerarchiaId(String gerarchiaId) {
        this.gerarchiaId = gerarchiaId;
    }

    public String getPadreId() {
        return this.padreId;
    }

    public void setPadreId(String padreId) {
        this.padreId = padreId;
    }

    public String getCodice() {
        return this.codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getSchema() {
        return this.schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getNomeTabella() {
        return this.nomeTabella;
    }

    public void setNomeTabella(String nomeTabella) {
        this.nomeTabella = nomeTabella;
    }

    public String getNomeCampo() {
        return this.nomeCampo;
    }

    public void setNomeCampo(String nomeCampo) {
        this.nomeCampo = nomeCampo;
    }

    public String getRegolaConfronto() {
        return this.regolaConfronto;
    }

    public void setRegolaConfronto(String regolaConfronto) {
        this.regolaConfronto = regolaConfronto;
    }

    public String getVariazioniCausaliId() {
        return this.variazioniCausaliId;
    }

    public void setVariazioniCausaliId(String variazioniCausaliId) {
        this.variazioniCausaliId = variazioniCausaliId;
    }

    public String getFlgSalva() {
        return this.flgSalva;
    }

    public void setFlgSalva(String flgSalva) {
        this.flgSalva = flgSalva;
    }

    public String getFlgSalvaCancellazione() {
        return this.flgSalvaCancellazione;
    }

    public void setFlgSalvaCancellazione(String flgSalvaCancellazione) {
        this.flgSalvaCancellazione = flgSalvaCancellazione;
    }

    public String getFlgAttiva() {
        return this.flgAttiva;
    }

    public void setFlgAttiva(String flgAttiva) {
        this.flgAttiva = flgAttiva;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
