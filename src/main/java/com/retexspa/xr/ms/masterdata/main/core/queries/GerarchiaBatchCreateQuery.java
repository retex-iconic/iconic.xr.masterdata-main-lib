package com.retexspa.xr.ms.masterdata.main.core.queries;

public class GerarchiaBatchCreateQuery {

  public final Integer nbHierarchies;
  public final Integer maxDepth;
  public final Integer maxChildren;

  public GerarchiaBatchCreateQuery(Integer nbHierarchies, Integer maxDepth, Integer maxChildren) {
    this.nbHierarchies = nbHierarchies;
    this.maxDepth = maxDepth;
    this.maxChildren = maxChildren;
  }

  public Integer getNbHierarchies() {
    return nbHierarchies;
  }

  public Integer getMaxDepth() {
    return maxDepth;
  }

  public Integer getMaxChildren() {
    return maxChildren;
  }
}
