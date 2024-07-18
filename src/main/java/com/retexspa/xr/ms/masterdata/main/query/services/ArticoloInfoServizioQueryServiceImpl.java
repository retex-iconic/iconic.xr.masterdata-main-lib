package com.retexspa.xr.ms.masterdata.main.query.services;


import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.ArticoloInfoServizioQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.ArticoloInfoServizioFilter;
import com.retexspa.xr.ms.masterdata.main.core.queries.ArticoloInfoServizioByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.ArticoloInfoServizioResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloInfoServizioQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.ArticoloInfoServizioQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.ArticoloInfoServizioRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ArticoloInfoServizioQueryServiceImpl implements ArticoloInfoServizioQueryService {

  @Autowired private ArticoloInfoServizioRepository articoloInfoServizioRepository;

  @Autowired ArticoloInfoServizioQueryMapper articoloInfoServizioQueryMapper;

  @PersistenceContext private EntityManager entityManager;

  @Override
  public ArticoloInfoServizioQueryDTO getArticoloInfoServizioById(
      ArticoloInfoServizioByIdQuery query) {
    ArticoloInfoServizioQueryEntity articoloInfoServizioQueryEntity =
        this.articoloInfoServizioRepository.findById(query.getArticoloInfoServizoId()).get();
    ArticoloInfoServizioQueryDTO articoloInfoServizioQueryDTO =
        articoloInfoServizioQueryMapper.toDTO(articoloInfoServizioQueryEntity);
    return articoloInfoServizioQueryDTO;
  }

  @Override
  public Page<ArticoloInfoServizioQueryEntity> searchQueryArticoloInfoServizio(
          GenericSearchRequest <ArticoloInfoServizioFilter> query) {
    List<Sort.Order> sorts = new ArrayList<>();

    if (query.getSort() != null && query.getSort().size() != 0) {
      for (BaseSort baseSort : query.getSort()) {

        switch (baseSort.getOrderBy()) {
          case "id":
            break;

          case "gerarchiaId":
            break;

          case "articoloId":
            break;

          case "servizioId":
            break;

          case "flgCancellato":
            break;
          case "version":
            break;
          case "dataCancellazione":
            break;
          default:
            throw new IllegalArgumentException("Order by is not correct");
        }

        sorts.add(
            new Sort.Order(
                baseSort.getOrderType() != null
                    ? baseSort.getOrderType().equalsIgnoreCase("ASC")
                        ? Sort.Direction.ASC
                        : Sort.Direction.DESC
                    : Sort.Direction.ASC,
                baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "articoloId"));
      }
    }

    if (sorts.size() == 0) {
      sorts.add(new Sort.Order(Sort.Direction.ASC, "articoloId"));
    }

    Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

    List<Specification<ArticoloInfoServizioQueryEntity>> specifications = new ArrayList<>();
    ArticoloInfoServizioFilter filter = ArticoloInfoServizioFilter.createFilterFromMap(query.getFilter());
    if (filter.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
    }

    if (filter.getGerarchiaId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("gerarchia").get("id"), filter.getGerarchiaId()));
    }

    if (filter.getArticoloId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("articolo").get("id"), filter.getArticoloId()));
    }
    if (filter.getServizioId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("servizio").get("id"), filter.getServizioId()));
    }

    if (filter.getFlgCancellato() != null) {
      specifications.add(
              (r, q, c) ->
                      c.like(
                              c.upper(r.get("flgCancellato")),
                              "%" + filter.getFlgCancellato().toUpperCase() + "%"));
    }
    if (filter.getDataCancellazione() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("dataCancellazione"), filter.getDataCancellazione()));
    }
    if (filter.getVersion() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
    }

    Specification<ArticoloInfoServizioQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<ArticoloInfoServizioQueryEntity> page =
        this.articoloInfoServizioRepository.findAll(specification, pageable);
    return page;
  }

  @Override
  public ArticoloInfoServizioResponse searchArticoloInfoServizio(
          GenericSearchRequest <ArticoloInfoServizioFilter> query) {
    ArticoloInfoServizioResponse articoloInfoServizioResponse = new ArticoloInfoServizioResponse();
    Page<ArticoloInfoServizioQueryEntity> page = searchQueryArticoloInfoServizio(query);
    articoloInfoServizioResponse.setPagination(Pagination.buildPagination(page));
    List<ArticoloInfoServizioQueryDTO> list =
        page.getContent().stream()
            .map(entity -> articoloInfoServizioQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    articoloInfoServizioResponse.setRecords(list);
    return articoloInfoServizioResponse;
  }
}
