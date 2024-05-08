package com.retexspa.xr.ms.masterdata.main.core.searchRequest;

import java.time.LocalDateTime;
import java.util.List;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.masterdata.main.core.queries.BaseSortPagination;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticoloNastroPrezziSearchRequest extends BaseSortPagination {
  private String id;
  private String codice;
  private Double prezzoVendita;
  private LocalDateTime dataOraInizio;
  private LocalDateTime dataOraFine;
  private String padreId;
  private String gerarchiaId;
  private String articoloId;
  private Long version;

  public ArticoloNastroPrezziSearchRequest(
      Integer page,
      Integer limit,
      List<BaseSort> sort,
      String id,
      String codice,
      Double prezzoVendita,
      LocalDateTime dataOraInizio,
      LocalDateTime dataOraFine,
      String padreId,
      String gerarchiaId,
      String articoloId,
      Long version) {
    super(page, limit, sort);
    this.id = id;
    this.codice = codice;
    this.prezzoVendita = prezzoVendita;
    this.dataOraInizio = dataOraInizio;
    this.dataOraFine = dataOraFine;
    this.padreId = padreId;
    this.gerarchiaId = gerarchiaId;
    this.articoloId = articoloId;
    this.version = version;
  }
}
