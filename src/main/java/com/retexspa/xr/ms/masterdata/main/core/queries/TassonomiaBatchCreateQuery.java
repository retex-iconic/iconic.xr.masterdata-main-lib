package com.retexspa.xr.ms.masterdata.main.core.queries;

public class TassonomiaBatchCreateQuery {

  public final Integer nbTassonomie;
  public final Integer maxDepth;
  public final Integer maxChildren;

  public TassonomiaBatchCreateQuery(Integer nbTassonomie, Integer maxDepth, Integer maxChildren) {
    this.nbTassonomie = nbTassonomie;
    this.maxDepth = maxDepth;
    this.maxChildren = maxChildren;
  }

  public Integer getNbTassonomie() {
    return nbTassonomie;
  }

  public Integer getMaxDepth() {
    return maxDepth;
  }

  public Integer getMaxChildren() {
    return maxChildren;
  }
}
