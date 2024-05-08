package com.retexspa.xr.ms.masterdata.main.core.searchRequest;

import java.time.LocalDateTime;
import java.util.List;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.masterdata.main.core.queries.BaseSortPagination;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticoloEanSearchRequest extends BaseSortPagination {
  private String id;
  private String codice;
  private String descrizione;
  private Integer moltiplicatore;
  private String codiceVenditaLocale;
  private String descrizioneCodiceVendita;
  private Double quantitaCodiceVendita;
  private Double scontoCodiceVendita;
  private Double prezzoCodiceVendita;
  private String anagBil;
  private String flgCancellato;
  private LocalDateTime dataCancellazione;

  private String padreId;
  private String gerarchiaId;
  private String articoloId;
  private String codiceMoltiplicatoreId;
  private String statoId;
  private String tipoEanId;
  private Long version;

  public ArticoloEanSearchRequest(
      Integer page,
      Integer limit,
      List<BaseSort> sort,
      String id,
      String codice,
      String descrizione,
      Integer moltiplicatore,
      String codiceVenditaLocale,
      String descrizioneCodiceVendita,
      Double quantitaCodiceVendita,
      Double scontoCodiceVendita,
      Double prezzoCodiceVendita,
      String anagBil,
      String flgCancellato,
      LocalDateTime dataCancellazione,
      String padreId,
      String gerarchiaId,
      String articoloId,
      String codiceMoltiplicatoreId,
      String statoId,
      String tipoEanId,
      Long version) {
    super(page, limit, sort);
    this.id = id;
    this.codice = codice;
    this.descrizione = descrizione;
    this.moltiplicatore = moltiplicatore;
    this.codiceVenditaLocale = codiceVenditaLocale;
    this.descrizioneCodiceVendita = descrizioneCodiceVendita;
    this.quantitaCodiceVendita = quantitaCodiceVendita;
    this.scontoCodiceVendita = scontoCodiceVendita;
    this.prezzoCodiceVendita = prezzoCodiceVendita;
    this.anagBil = anagBil;
    this.flgCancellato = flgCancellato;
    this.dataCancellazione = dataCancellazione;
    this.padreId = padreId;
    this.gerarchiaId = gerarchiaId;
    this.articoloId = articoloId;
    this.codiceMoltiplicatoreId = codiceMoltiplicatoreId;
    this.statoId = statoId;
    this.tipoEanId = tipoEanId;
    this.version = version;
  }
}
