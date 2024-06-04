package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.retexspa.xr.ms.main.query.entities.AttributoQueryEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

@Entity
@Table(
    name = "config_attributi",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "config_attributi_uk",
          columnNames = {"config_id", "attributo_id"})
    })
public class ConfigAttributoQueryEntity {

  @Id @NonNull private String id;

  @ManyToOne(
      fetch = FetchType.LAZY,
      targetEntity = ConfigQueryEntity.class,
      cascade = {CascadeType.PERSIST})
  @JsonIgnore
  private ConfigQueryEntity config;

  @ManyToOne(fetch = FetchType.LAZY)
  private AttributoQueryEntity attributo;

  @Column(name = "valore")
  private String valore;

  public ConfigAttributoQueryEntity() {}

  public ConfigAttributoQueryEntity(
      @NotNull String id,
      ConfigQueryEntity config,
      AttributoQueryEntity attributo,
      String valore) {
    this.id = id;
    this.config = config;
    this.attributo = attributo;
    this.valore = valore;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ConfigQueryEntity getConfig() {
    return config;
  }

  public void setConfig(ConfigQueryEntity config) {
    this.config = config;
  }

  public AttributoQueryEntity getAttributo() {
    return attributo;
  }

  public void setAttributo(AttributoQueryEntity attributo) {
    this.attributo = attributo;
  }

  public String getValore() {
    return valore;
  }

  public void setValore(String valore) {
    this.valore = valore;
  }
}
