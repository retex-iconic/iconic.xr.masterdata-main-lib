package com.retexspa.xr.ms.masterdata.main.core.dto.iva;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import javax.validation.constraints.NotNull;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IvaRtUpdateDto {
  @NotNull(message = "nome is mandatory")
  private String nome;

  @NotNull(message = "descrizione is mandatory")
  private String descrizione;

  private String rtDescr;
  private String rtType;

  // interna
  private String rtFullDesc;

  // corta
  private String rtShortDesc;

  // tassa
  private String rtTaxCode;
  private String rtTipoEsenzione;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public String getRtDescr() {
    return rtDescr;
  }

  public void setRtDescr(String rtDescr) {
    this.rtDescr = rtDescr;
  }

  public String getRtType() {
    return rtType;
  }

  public void setRtType(String rtType) {
    this.rtType = rtType;
  }

  public String getRtFullDesc() {
    return rtFullDesc;
  }

  public void setRtFullDesc(String rtFullDesc) {
    this.rtFullDesc = rtFullDesc;
  }

  public String getRtShortDesc() {
    return rtShortDesc;
  }

  public void setRtShortDesc(String rtShortDesc) {
    this.rtShortDesc = rtShortDesc;
  }

  public String getRtTaxCode() {
    return rtTaxCode;
  }

  public void setRtTaxCode(String rtTaxCode) {
    this.rtTaxCode = rtTaxCode;
  }

  public String getRtTipoEsenzione() {
    return rtTipoEsenzione;
  }

  public void setRtTipoEsenzione(String rtTipoEsenzione) {
    this.rtTipoEsenzione = rtTipoEsenzione;
  }
}
