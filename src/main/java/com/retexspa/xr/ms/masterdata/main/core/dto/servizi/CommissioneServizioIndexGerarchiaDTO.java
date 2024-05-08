package com.retexspa.xr.ms.masterdata.main.core.dto.servizi;


import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

public class CommissioneServizioIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  private String servizioId;
  private String profilo;

  public CommissioneServizioIndexGerarchiaDTO() {}

  public CommissioneServizioIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public String getServizioId() {
    return servizioId;
  }

  public void setServizioId(String servizioId) {
    this.servizioId = servizioId;
  }

  public String getProfilo() {
    return profilo;
  }

  public void setProfilo(String profilo) {
    this.profilo = profilo;
  }

  public static String getUk(CommissioneServizioBaseDTO comm) {
    String uk =
        comm.getServizioId()
            + CommissioneServizioIndexGerarchiaDTO.getUkSeparator()
            + comm.getProfilo();
    return uk;
  }
}
