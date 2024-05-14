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
    name = "master_data_config_attributi",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "master_data_config_attributi_uk",
          columnNames = {"master_data_config_id", "attributo_id"})
    })
public class MasterDataConfigAttributoQueryEntity {

  @Id @NonNull private String id;

  @ManyToOne(
      fetch = FetchType.LAZY,
      targetEntity = MasterDataConfigQueryEntity.class,
      cascade = {CascadeType.PERSIST})
  @JsonIgnore
  private MasterDataConfigQueryEntity masterDataConfig;

  @ManyToOne(fetch = FetchType.LAZY)
  private AttributoQueryEntity attributo;

  @Column(name = "valore")
  private String valore;

  public MasterDataConfigAttributoQueryEntity() {}

  public MasterDataConfigAttributoQueryEntity(
      @NotNull String id,
      MasterDataConfigQueryEntity masterDataConfig,
      AttributoQueryEntity attributo,
      String valore) {
    this.id = id;
    this.masterDataConfig = masterDataConfig;
    this.attributo = attributo;
    this.valore = valore;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public MasterDataConfigQueryEntity getMasterDataConfig() {
    return masterDataConfig;
  }

  public void setMasterDataConfig(MasterDataConfigQueryEntity masterDataConfig) {
    this.masterDataConfig = masterDataConfig;
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
