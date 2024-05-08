package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.google.common.base.Joiner;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.retexspa.xr.ms.masterdata.main.core.dto.attributo.AttributoBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "attributi")
public class AttributoQueryEntity {

  @Id @NonNull private String id;

  @Column(name = "chiave")
  private String chiave;

  @Column(name = "descrizione")
  private String descrizione;

  @Column(name = "aggregato")
  private String aggregato;

  @Column(name = "check_value")
  private String checkValue;

  @Column(name = "version")
  private Long version;

  public AttributoQueryEntity() {}

  public AttributoQueryEntity(String id, AttributoBaseDTO attributoBaseDTO, Long version) {
    this.id = id;
    this.chiave = attributoBaseDTO.getChiave();
    this.descrizione = attributoBaseDTO.getDescrizione();
    this.aggregato = attributoBaseDTO.getAggregato();
    if (attributoBaseDTO.getCheckValue() != null && !attributoBaseDTO.getCheckValue().isEmpty()) {
      this.checkValue =
          Joiner.on(attributoBaseDTO.getCheckValueSeparator())
              .join(attributoBaseDTO.getCheckValue());
    } else {
      this.checkValue = null;
    }
     this.version = version;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getChiave() {
    return chiave;
  }

  public void setChiave(String chiave) {
    this.chiave = chiave;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public String getAggregato() {
    return aggregato;
  }

  public void setAggregato(String aggregato) {
    this.aggregato = aggregato;
  }

  public String getCheckValue() {
    return this.checkValue;
  }

  public void setCheckValue(String checkValue) {
    this.checkValue = checkValue;
  }

  public Long getVersion() {
    return this.version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
