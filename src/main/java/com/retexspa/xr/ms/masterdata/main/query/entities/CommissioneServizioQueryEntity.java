package com.retexspa.xr.ms.masterdata.main.query.entities;

import javax.persistence.*;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.servizi.CommissioneServizioBaseDTO;
import lombok.NonNull;

@Entity
@Table(name = "commissioneServizio")
public class CommissioneServizioQueryEntity {
  @Id @NonNull private String id;

  @ManyToOne(fetch = FetchType.LAZY)
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  private AnagraficaServizioQueryEntity anagraficaServizio;

  @ManyToOne(fetch = FetchType.LAZY)
  private ArticoloQueryEntity articolo;

  @Column(name = "flgDefault")
  private String flgDefault;

  @Column(name = "profilo")
  private String profilo;

  @Column(name = "version")
  private Long version;

  public CommissioneServizioQueryEntity() {}

  public CommissioneServizioQueryEntity(
          String id, CommissioneServizioBaseDTO commissioneServizioBaseDTO, Long version) {
    this.id = id;
    this.flgDefault = commissioneServizioBaseDTO.getFlgDefault();
    this.profilo = commissioneServizioBaseDTO.getProfilo();
    this.version = version;
  }

  @NonNull
  public String getId() {
    return id;
  }

  public void setId(@NonNull String id) {
    this.id = id;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public AnagraficaServizioQueryEntity getAnagraficaServizio() {
    return anagraficaServizio;
  }

  public void setAnagraficaServizio(AnagraficaServizioQueryEntity anagraficaServizio) {
    this.anagraficaServizio = anagraficaServizio;
  }

  public ArticoloQueryEntity getArticolo() {
    return articolo;
  }

  public void setArticolo(ArticoloQueryEntity articoloServizio) {
    this.articolo = articoloServizio;
  }

  public String getFlgDefault() {
    return flgDefault;
  }

  public void setFlgDefault(String flg_default) {
    this.flgDefault = flg_default;
  }

  public String getProfilo() {
    return profilo;
  }

  public void setProfilo(String profilo) {
    this.profilo = profilo;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
