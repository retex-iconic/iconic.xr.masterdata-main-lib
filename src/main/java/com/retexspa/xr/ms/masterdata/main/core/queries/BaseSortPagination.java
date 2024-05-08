package com.retexspa.xr.ms.masterdata.main.core.queries;

import java.util.ArrayList;
import java.util.List;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class BaseSortPagination extends BasePagination {

  private List<BaseSort> sort;

  public BaseSortPagination(Integer page, Integer limit, List<BaseSort> sort) {
    super(page, limit);
    this.sort = sort;
  }

  public List<BaseSort> getSort() {
    return sort;
  }

  public void setSort(List<BaseSort> sort) {
    this.sort = sort;
  }

}
