package com.retexspa.xr.ms.masterdata.main.query.entities;

import javax.persistence.*;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.servizi.EsclusioniFpServizioBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "esclusioniFpServizio")
public class EsclusioniFpServizioQueryEntity {
  @Id @NonNull private String id;

  @Column(name = "codice")
  private String codice;

  @ManyToOne(fetch = FetchType.LAZY)
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  private AnagraficaServizioQueryEntity servizio;

  @ManyToOne(fetch = FetchType.LAZY)
  private FormaPagamentoQueryEntity formaPagamento;

  @NonNull private Double massimaleSingolo;

  @NonNull private Double massimaleCumulativo;

  private String flgSegnalazione;
  private String descSegnalazione;

  @Column(name = "version")
  private Long version;

  public EsclusioniFpServizioQueryEntity() {}

  public EsclusioniFpServizioQueryEntity(
          String id, EsclusioniFpServizioBaseDTO esclusioniFpServizioDTO, Long version) {
    this.id = id;
    this.codice = esclusioniFpServizioDTO.getCodice();
    this.massimaleCumulativo = esclusioniFpServizioDTO.getMassimaleCumulativo();
    this.massimaleSingolo = esclusioniFpServizioDTO.getMassimaleSingolo();
    this.flgSegnalazione = esclusioniFpServizioDTO.getFlgSegnalazione();
    this.descSegnalazione = esclusioniFpServizioDTO.getDescSegnalazione();
    this.version = version;
  }

  @NonNull
  public String getId() {
    return id;
  }

  public void setId(@NonNull String id) {
    this.id = id;
  }

  public String getCodice() {
    return codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public AnagraficaServizioQueryEntity getServizio() {
    return servizio;
  }

  public void setServizio(AnagraficaServizioQueryEntity servizio) {
    this.servizio = servizio;
  }

  @NonNull
  public Double getMassimaleSingolo() {
    return massimaleSingolo;
  }

  public void setMassimaleSingolo(@NonNull Double massimaleSingolo) {
    this.massimaleSingolo = massimaleSingolo;
  }

  @NonNull
  public Double getMassimaleCumulativo() {
    return massimaleCumulativo;
  }

  public void setMassimaleCumulativo(@NonNull Double massimaleCumulativo) {
    this.massimaleCumulativo = massimaleCumulativo;
  }

  public String getFlgSegnalazione() {
    return flgSegnalazione;
  }

  public void setFlgSegnalazione(String flgSegnalazione) {
    this.flgSegnalazione = flgSegnalazione;
  }

  public String getDescSegnalazione() {
    return descSegnalazione;
  }

  public void setDescSegnalazione(String descSegnalazione) {
    this.descSegnalazione = descSegnalazione;
  }

  public FormaPagamentoQueryEntity getFormaPagamento() {
    return formaPagamento;
  }

  public void setFormaPagamento(FormaPagamentoQueryEntity formaPagamento) {
    this.formaPagamento = formaPagamento;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
