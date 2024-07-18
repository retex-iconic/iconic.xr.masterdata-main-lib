package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.articolo.ArticoloInfoServizioBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "articoli_info_servizio")
public class ArticoloInfoServizioQueryEntity implements Serializable {

  @Id @NonNull private String id;

  @Column(name = "flg_cancellato")
  private String flgCancellato;

  @ManyToOne(fetch = FetchType.LAZY)
  private GerarchiaQueryEntity gerarchia;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  private ArticoloQueryEntity articolo;

  @ManyToOne(fetch = FetchType.LAZY)
  private AnagraficaServizioQueryEntity servizio;
  @Column(name = "version")
  private Long version;
  @Column(name = "data_cancellazione")
  private LocalDateTime dataCancellazione;

  public ArticoloInfoServizioQueryEntity() {}

  public ArticoloInfoServizioQueryEntity(
      @NotNull String articoloInfoServizioId,
      ArticoloInfoServizioBaseDTO articoloInfoServizioDTO,
      Long version)
      throws IOException {
    this.id = articoloInfoServizioId;
    this.flgCancellato = articoloInfoServizioDTO.getFlgCancellato();
    this.version = version;
  }

  // getters and setters
  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = flgCancellato;
  }

  public ArticoloQueryEntity getArticolo() {
    return articolo;
  }

  public void setArticolo(ArticoloQueryEntity articolo) {
    this.articolo = articolo;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public LocalDateTime getDataCancellazione() {
    return dataCancellazione;
  }

  public void setDataCancellazione(LocalDateTime dataCancellazione) {
    this.dataCancellazione = dataCancellazione;
  }
}
