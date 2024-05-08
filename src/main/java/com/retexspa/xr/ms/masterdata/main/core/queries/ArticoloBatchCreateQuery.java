package com.retexspa.xr.ms.masterdata.main.core.queries;

public class ArticoloBatchCreateQuery {

  public final Integer nbArticles;
  public final Integer maxOverride;

  public ArticoloBatchCreateQuery(Integer nbArticles, Integer maxOverride) {
    this.nbArticles = nbArticles;
    this.maxOverride = maxOverride;
  }

  public Integer getNbArticles() {
    return nbArticles;
  }

  public Integer getMaxOverride() {
    return maxOverride;
  }
}
