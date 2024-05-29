package com.retexspa.xr.ms.masterdata.main.core.dto;

public class Enums extends com.retexspa.xr.ms.main.core.dto.Enums  {

  public enum Collocazione {
    F, // Fiscale
    N // Non fiscale
  }

  public enum TipoOperazioneVariazione {
    BARRIERA,
    BILANCIA,
    ECOMMERCE,
    ETICHETTA
  }

  public enum TipologiaVariazione {
    ARTICOLO,
    FORNITORE
  }
  public enum TipoIva {
    AV, // iva acquisto vendita
    V, // iva vendita
    A; // iva acquisto
  }

  public enum GruppoTassonomia {
    NEGOZIO,
    ARTICOLO,
    FORNITORE;
  }

}
