package com.retexspa.xr.ms.masterdata.main.core.searchRequest;

import java.time.LocalDateTime;
import java.util.List;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.masterdata.main.core.queries.BaseSortPagination;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticoloVenditaSearchRequest extends BaseSortPagination {

  private String id;
  private String nome;
  private String codice;
  private String descrizione;
  private String articoloId;
  private String gerarchiaId;
  private String padreId;
  private String statoId;
  private String tipoArticoloVenditaId;
  private String sottotipoArticoloVenditaId;
  private String repartoId;
  private String ivaId;
  private Double costo;
  private Integer tara;
  private Integer maxArt;
  private LocalDateTime dataOraInizio;
  private LocalDateTime dataOraFine;
  private String oraFine;
  private String oraInizio;
  private Integer aa3;
  private Integer aa4;
  private String flgCancellato;
  private LocalDateTime dataCancellazione;
  private Long version;

  public ArticoloVenditaSearchRequest(
      Integer page,
      Integer limit,
      List<BaseSort> sort,
      String id,
      String nome,
      String codice,
      String descrizione,
      String articoloId,
      String gerarchiaId,
      String padreId,
      String statoId,
      String tipoArticoloVenditaId,
      String sottotipoArticoloVenditaId,
      String repartoId,
      String ivaId,
      Double costo,
      Integer tara,
      Integer maxArt,
      LocalDateTime dataOraInizio,
      LocalDateTime dataOraFine,
      String oraFine,
      String oraInizio,
      Integer aa3,
      Integer aa4,
      String flgCancellato,
      LocalDateTime dataCancellazione,
      Long version) {
    super(page, limit, sort);
    this.id = id;
    this.nome = nome;
    this.codice = codice;
    this.descrizione = descrizione;
    this.articoloId = articoloId;
    this.gerarchiaId = gerarchiaId;
    this.padreId = padreId;
    this.statoId = statoId;
    this.tipoArticoloVenditaId = tipoArticoloVenditaId;
    this.sottotipoArticoloVenditaId = sottotipoArticoloVenditaId;
    this.repartoId = repartoId;
    this.ivaId = ivaId;
    this.costo = costo;
    this.tara = tara;
    this.maxArt = maxArt;
    this.dataOraInizio = dataOraInizio;
    this.dataOraFine = dataOraFine;
    this.oraFine = oraFine;
    this.oraInizio = oraInizio;
    this.aa3 = aa3;
    this.aa4 = aa4;
    this.flgCancellato = flgCancellato;
    this.dataCancellazione = dataCancellazione;
    this.version = version;
  }
}
