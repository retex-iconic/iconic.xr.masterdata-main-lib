package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.IvaRtQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.IvaRtFilter;
import com.retexspa.xr.ms.masterdata.main.core.queries.IvaRtByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.IvaRtResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.AtecoQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.entities.IvaRtQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.IvaRtQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.IvaRtRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class IvaRtQueryServiceImpl implements IvaRtQueryService {

  IvaRtRepository ivaRtRepository;

  IvaRtQueryMapper ivaRtQueryMapper;

  IvaRtQueryServiceImpl(IvaRtRepository ivaRtRepository, IvaRtQueryMapper ivaRtQueryMapper) {
    this.ivaRtRepository = ivaRtRepository;
    this.ivaRtQueryMapper = ivaRtQueryMapper;
  }

  @PersistenceContext private EntityManager entityManager;

  @Override
  public IvaRtQueryDTO getIvaRtById(IvaRtByIdQuery query) {
    IvaRtQueryEntity ivaRtQueryEntity =
        this.ivaRtRepository.findById(query.getIvaRtId()).orElse(null);

    return ivaRtQueryMapper.toDTO(ivaRtQueryEntity);
  }

  @Override
  public Page<IvaRtQueryEntity> searchQueryIvaRt(GenericSearchRequest<IvaRtFilter> query) {
    List<Sort.Order> sorts = new ArrayList<>();

    if (query.getSort() != null && query.getSort().size() != 0) {
      for (BaseSort baseSort : query.getSort()) {
        sorts.add(
            new Sort.Order(
                baseSort.getOrderType() != null
                    ? baseSort.getOrderType().equalsIgnoreCase("ASC")
                        ? Sort.Direction.ASC
                        : Sort.Direction.DESC
                    : Sort.Direction.ASC,
                baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "codice"));
      }
    }

    if (sorts.size() == 0) {
      sorts.add(new Sort.Order(Sort.Direction.ASC, "codice"));
    }

    Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

    List<Specification<IvaRtQueryEntity>> specifications = new ArrayList<>();

    IvaRtFilter filter = IvaRtFilter.createFilterFromMap(query.getFilter());

    if (filter.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
    }
    if (filter.getCodice() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("codice"), filter.getCodice()));
    }
    if (filter.getNome() != null) {
      specifications.add(
              (r, q, c) -> c.equal(r.get("nome"), filter.getNome()));
    }
    if (filter.getDescrizione() != null) {
      specifications.add(
              (r, q, c) -> c.equal(r.get("descrizione"), filter.getDescrizione()));
    }
    if (filter.getRtTipoEsenzione() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("rtTipoEsenzione"), filter.getRtTipoEsenzione()));
    }
    if (filter.getRtTaxCode() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("rtTaxCode"), filter.getRtTaxCode()));
    }
    if (filter.getRtShortDesc() != null) {
      specifications.add(
              (r, q, c) -> c.equal(r.get("rtShortDesc"), filter.getRtShortDesc()));
    }
    if (filter.getRtFullDesc() != null) {
      specifications.add(
              (r, q, c) -> c.equal(r.get("rtFullDesc"), filter.getRtFullDesc()));
    }
    if (filter.getRtType() != null) {
      specifications.add(
              (r, q, c) -> c.equal(r.get("rtType"), filter.getRtType()));
    }
    if (filter.getRtDescr() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("rtDescr"), filter.getRtDescr()));
    }
    if (filter.getDataCancellazione() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("dataCancellazione"), filter.getDataCancellazione()));
    }
    if (filter.getFlgCancellato() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("flgCancellato"), filter.getFlgCancellato()));
    }
    if (filter.getVersion() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
    }
    NativeQueryHelper NativeQueryHelper = new NativeQueryHelper();
    if (filter.getGerarchiaId() != null) {
      String gerarchNativeQuery = NativeQueryHelper.gerarchiaNativeQuery();
      Query hierarchiaRoots =
          entityManager
              .createNativeQuery(gerarchNativeQuery)
              .setParameter("gerarchiaid", filter.getGerarchiaId());
      List<String> hierarchiaRootsIds = hierarchiaRoots.getResultList();

      specifications.add(
          (root, criteriaQuery, criteriaBuilder) -> {
            // Define the subquery
            Subquery<AtecoQueryEntity> subquery = criteriaQuery.subquery(AtecoQueryEntity.class);
            Root<AtecoQueryEntity> subRoot = subquery.from(AtecoQueryEntity.class);

            subquery.select(subRoot);
            subquery.where(
                criteriaBuilder.and(
                    criteriaBuilder.equal(subRoot.get("padre").get("id"), root.get("id")),
                    subRoot.get("gerarchia").get("id").in(hierarchiaRootsIds)));
            // Integrate the subquery into the main query using criteriaBuilder
            return criteriaBuilder.and(
                criteriaBuilder.not(criteriaBuilder.exists(subquery)),
                root.get("gerarchia").get("id").in(hierarchiaRootsIds));
          });
    }
    if (filter.getAtecoId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("ateco").get("id"), filter.getAtecoId()));
    }
    if (filter.getIvaId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("iva").get("id"), filter.getIvaId()));
    }
    if (filter.getPadreId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("padre").get("id"), filter.getPadreId()));
    }

    Specification<IvaRtQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<IvaRtQueryEntity> page = this.ivaRtRepository.findAll(specification, pageable);
    return page;
  }

  @Override
  public IvaRtResponse searchIvaRt(GenericSearchRequest<IvaRtFilter> query) {
    Page<IvaRtQueryEntity> page = searchQueryIvaRt(query);
    IvaRtResponse ivaRtResponse = new IvaRtResponse();
    List<IvaRtQueryDTO> list =
        page.getContent().stream()
            .map(entity -> ivaRtQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    ivaRtResponse.setRecords(list);

    ivaRtResponse.setPagination(Pagination.buildPagination(page));

    return ivaRtResponse;
  }
}
