package com.retexspa.xr.ms.masterdata.main.query;


import com.retexspa.xr.ms.main.core.entities.GerarchiaQueryDTO;

public class Aggregato {
  private String id;
  private GerarchiaQueryDTO gerarchia;

  public String getId() {
    return id;
  }

  public String getGerarchia_id() {
    return gerarchia.getId();
  }

  public GerarchiaQueryDTO getGerarchia() {
    return gerarchia;
  }
}
