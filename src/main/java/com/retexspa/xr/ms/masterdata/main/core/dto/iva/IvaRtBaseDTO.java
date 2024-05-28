package com.retexspa.xr.ms.masterdata.main.core.dto.iva;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.BaseDTO;

import java.util.UUID;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class IvaRtBaseDTO extends BaseDTO {

  // relation id IvaBaseDTO
  private String ivaId;

  private String rtTipoEsenzione;
  /*
   * N1 Esclusa
   * N1_1 Escluso Art. 15 DPR 633/72
   * N2 Non Soggetta
   * N2_1 Escluso Art. 13 5C DPR 633/72
   * N2_2 Fuori campo IVA Art. 2 DPR 633/72
   * N2_3 Fuori campo IVA Art. 3 DPR 633/72
   * N2_4 Fuori campo IVA Art. 4 DPR 633/72
   * N2_5 Fuori campo IVA Art. 5 DPR 633/72
   * N2_6 Fuori campo IVA Art. 7 DPR 633/72
   * N2_7 Regime dei minimi Art. 1 L. 244/2007
   * N2_8 Regime forfettario Art. 1 L. 190/2014
   * N3 Non Imponibile
   * N3_1 Non Imponibile Art. 41 DL 331/93
   * N3_2 Non Imponibile Art. 74 DPR 633/72
   * N3_3 Non Imponibile Art. 8 DPR 633/72
   * N3_4 Non Imponibile Art. 9 DPR 633/72
   * N4
   * N4_1 Esente Art. 10 DPR 633/72
   * N5 Regime del Margine
   * N5_1 Escluso Art. 74 DPR 633/72
   * N5_2 Regime del margine Art. 36 41/95
   * N6 Operazioni non IVA
   * N6_1 Reverse charge Art. 17 DPR 633/72
   * N6_2 Reverse charge Art. 74 DPR 633/72
   */
  private String rtDescr;

  private String rtTaxCode;

  private String rtShortDesc;

  private String rtFullDesc;

  private String rtType;

  private String rtAtecoNrId;

  public String getIvaId() {
    return ivaId;
  }

  public void setIvaId(String ivaId) {
    this.ivaId = ivaId;
  }

  public String getRtTipoEsenzione() {
    return this.rtTipoEsenzione;
  }

  public void setRtTipoEsenzione(String rtTipoEsenzione) {
    this.rtTipoEsenzione = rtTipoEsenzione;
  }

  public String getRtDescr() {
    return this.rtDescr;
  }

  public void setRtDescr(String rtDescr) {
    this.rtDescr = rtDescr;
  }

  public String getRtTaxCode() {
    return this.rtTaxCode;
  }

  public void setRtTaxCode(String rtTaxCode) {
    this.rtTaxCode = rtTaxCode;
  }

  public String getRtShortDesc() {
    return this.rtShortDesc;
  }

  public void setRtShortDesc(String rtShortDesc) {
    this.rtShortDesc = rtShortDesc;
  }

  public String getRtFullDesc() {
    return this.rtFullDesc;
  }

  public void setRtFullDesc(String rtFullDesc) {
    this.rtFullDesc = rtFullDesc;
  }

  public String getRtType() {
    return this.rtType;
  }

  public void setRtType(String rtType) {
    this.rtType = rtType;
  }

  public String getRtAtecoNrId() {
    return this.rtAtecoNrId;
  }

  public void setRtAtecoNrId(String rtAtecoNrId) {
    this.rtAtecoNrId = rtAtecoNrId;
  }

  @JsonIgnore
  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }

  public static String getName() {
    return "IvaRt";
  }

  public static String getAggregateName() {
    return "IvaRtAggregate";
  }
}
