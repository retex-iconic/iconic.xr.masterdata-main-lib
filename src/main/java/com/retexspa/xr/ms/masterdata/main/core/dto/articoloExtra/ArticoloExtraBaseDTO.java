package com.retexspa.xr.ms.masterdata.main.core.dto.articoloExtra;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.BaseDTO;

import java.util.UUID;
import javax.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ArticoloExtraBaseDTO extends BaseDTO {

  @NotNull(message = "articolo_id is mandatory")
  private String articoloId;

  private String layoutESL;

  private String gruppo;

  private String descrizioneBreve;

  private String unitaDiMisura;

  private Integer quantita;

  private Integer scortaMinima;

  private Integer deposito;

  private String scaffale;

  private Double superficieEspositiva;

  private Integer quantitaImpegnata;

  private Integer scortaMassima;

  private Integer layoutEtichetta;

  private String tipoProdotto;

  private Integer numeroEtichette;

  private String tipoScaricoVenduto;

  private String fornitorePrimario;

  private String fornitoreEtichetta;

  private Integer posizionamento;

  private Integer stagionalita;

  private Integer tipoProdotto2;

  private String svalorizzazione;

  private String cluster;

  private String assortimentoPuntoVendita;

  public String getArticoloId() {
    return this.articoloId;
  }

  public void setArticolo_id(String articoloId) {
    this.articoloId = articoloId;
  }

  public String getLayoutESL() {
    return this.layoutESL;
  }

  public void setLayoutESL(String layoutESL) {
    this.layoutESL = layoutESL;
  }

  public String getGruppo() {
    return this.gruppo;
  }

  public void setGruppo(String gruppo) {
    this.gruppo = gruppo;
  }

  public String getDescrizioneBreve() {
    return this.descrizioneBreve;
  }

  public void setDescrizioneBreve(String descrizioneBreve) {
    this.descrizioneBreve = descrizioneBreve;
  }

  public String getUnitaDiMisura() {
    return this.unitaDiMisura;
  }

  public void setUnitaDiMisura(String unitaDiMisura) {
    this.unitaDiMisura = unitaDiMisura;
  }

  public Integer getQuantita() {
    return this.quantita;
  }

  public void setQuantita(Integer quantita) {
    this.quantita = quantita;
  }

  public Integer getScortaMinima() {
    return this.scortaMinima;
  }

  public void setScortaMinima(Integer scortaMinima) {
    this.scortaMinima = scortaMinima;
  }

  public Integer getDeposito() {
    return this.deposito;
  }

  public void setDeposito(Integer deposito) {
    this.deposito = deposito;
  }

  public String getScaffale() {
    return this.scaffale;
  }

  public void setScaffale(String scaffale) {
    this.scaffale = scaffale;
  }

  public Double getSuperficieEspositiva() {
    return this.superficieEspositiva;
  }

  public void setSuperficieEspositiva(Double superficieEspositiva) {
    this.superficieEspositiva = superficieEspositiva;
  }

  public Integer getQuantitaImpegnata() {
    return this.quantitaImpegnata;
  }

  public void setQuantitaImpegnata(Integer quantitaImpegnata) {
    this.quantitaImpegnata = quantitaImpegnata;
  }

  public Integer getScortaMassima() {
    return this.scortaMassima;
  }

  public void setScortaMassima(Integer scortaMassima) {
    this.scortaMassima = scortaMassima;
  }

  public Integer getLayoutEtichetta() {
    return this.layoutEtichetta;
  }

  public void setLayoutEtichetta(Integer layoutEtichetta) {
    this.layoutEtichetta = layoutEtichetta;
  }

  public String getTipoProdotto() {
    return this.tipoProdotto;
  }

  public void setTipoProdotto(String tipoProdotto) {
    this.tipoProdotto = tipoProdotto;
  }

  public Integer getNumeroEtichette() {
    return this.numeroEtichette;
  }

  public void setNumeroEtichette(Integer numeroEtichette) {
    this.numeroEtichette = numeroEtichette;
  }

  public String getTipoScaricoVenduto() {
    return this.tipoScaricoVenduto;
  }

  public void setTipoScaricoVenduto(String tipoScaricoVenduto) {
    this.tipoScaricoVenduto = tipoScaricoVenduto;
  }

  public String getFornitorePrimario() {
    return this.fornitorePrimario;
  }

  public void setFornitorePrimario(String fornitorePrimario) {
    this.fornitorePrimario = fornitorePrimario;
  }

  public String getFornitoreEtichetta() {
    return this.fornitoreEtichetta;
  }

  public void setFornitoreEtichetta(String fornitoreEtichetta) {
    this.fornitoreEtichetta = fornitoreEtichetta;
  }

  public Integer getPosizionamento() {
    return this.posizionamento;
  }

  public void setPosizionamento(Integer posizionamento) {
    this.posizionamento = posizionamento;
  }

  public Integer getStagionalita() {
    return this.stagionalita;
  }

  public void setStagionalita(Integer stagionalita) {
    this.stagionalita = stagionalita;
  }

  public Integer getTipoProdotto2() {
    return this.tipoProdotto2;
  }

  public void setTipoProdotto2(Integer tipoProdotto2) {
    this.tipoProdotto2 = tipoProdotto2;
  }

  public String getSvalorizzazione() {
    return this.svalorizzazione;
  }

  public void setSvalorizzazione(String svalorizzazione) {
    this.svalorizzazione = svalorizzazione;
  }

  public String getCluster() {
    return this.cluster;
  }

  public void setCluster(String cluster) {
    this.cluster = cluster;
  }

  public String getAssortimentoPuntoVendita() {
    return this.assortimentoPuntoVendita;
  }

  public void setAssortimentoPuntoVendita(String assortimentoPuntoVendita) {
    this.assortimentoPuntoVendita = assortimentoPuntoVendita;
  }

  @JsonIgnore
  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }
}
