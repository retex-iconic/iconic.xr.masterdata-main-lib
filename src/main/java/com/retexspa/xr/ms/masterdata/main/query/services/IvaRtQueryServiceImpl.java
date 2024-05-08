package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.IvaRtQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.IvaRtByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.IvaRtResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.IvaRtSearchRequest;
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
  public Page<IvaRtQueryEntity> searchQueryIvaRt(IvaRtSearchRequest query) {
    // TODO Auto-generated method stub
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

    if (query.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), query.getId()));
    }
    if (query.getCodice() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("codice"), query.getCodice()));
    }
    if (query.getDescrizione() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("descrizione"), query.getDescrizione()));
    }
    if (query.getNome() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("nome"), query.getNome()));
    }
    if (query.getRtTipoEsenzione() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("rtTipoEsenzione"), query.getRtTipoEsenzione()));
    }
    if (query.getRtTaxCode() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("rtTaxCode"), query.getRtTaxCode()));
    }
    if (query.getRtShortDesc() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("rtShortDesc"), query.getRtShortDesc()));
    }
    if (query.getRtFullDesc() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("rtFullDesc"), query.getRtFullDesc()));
    }
    if (query.getRtType() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("rtType"), query.getRtType()));
    }
    if (query.getRtDescr() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("rtDescr"), query.getRtDescr()));
    }
    if (query.getDataCancellazione() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("dataCancellazione"), query.getDataCancellazione()));
    }
    if (query.getFlgCancellato() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("flgCancellato")),
                  "%" + query.getFlgCancellato().toUpperCase() + "%"));
    }
    if (query.getVersion() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("version"), query.getVersion()));
    }
    NativeQueryHelper NativeQueryHelper = new NativeQueryHelper();
    if (query.getGerarchiaId() != null) {
      String gerarchNativeQuery = NativeQueryHelper.gerarchiaNativeQuery();
      Query hierarchiaRoots =
          entityManager
              .createNativeQuery(gerarchNativeQuery)
              .setParameter("gerarchiaid", query.getGerarchiaId());
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
    if (query.getAtecoId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("ateco").get("id"), query.getAtecoId()));
    }
    if (query.getIvaId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("iva").get("id"), query.getIvaId()));
    }
    if (query.getPadreId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("padre").get("id"), query.getPadreId()));
    }

    Specification<IvaRtQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<IvaRtQueryEntity> page = this.ivaRtRepository.findAll(specification, pageable);
    return page;
  }

  @Override
  public IvaRtResponse searchIvaRt(IvaRtSearchRequest query) {
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
