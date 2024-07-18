package com.retexspa.xr.ms.masterdata.main.query.services;


import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.entities.VariazioniCausaliOperazioniQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.responses.VariazioniCausaliOperazioniResponse;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.VariazioniCausaliOperazioniFilter;
import com.retexspa.xr.ms.masterdata.main.query.entities.VariazioniCausaliOperazioniQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.VariazioniCausaliOperazioniQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.VariazioniCausaliOperazioniRepository;
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
public class VariazioniCausaliOperazioniQueryServiceImpl
    implements VariazioniCausaliOperazioniQueryService {
  VariazioniCausaliOperazioniRepository variazioniCausaliOperazioniRepository;
  VariazioniCausaliOperazioniQueryMapper variazioniCausaliOperazioniQueryMapper;
  @PersistenceContext private EntityManager entityManager;

  public VariazioniCausaliOperazioniQueryServiceImpl(
      VariazioniCausaliOperazioniRepository variazioniCausaliOperazioniRepository,
      VariazioniCausaliOperazioniQueryMapper variazioniCausaliOperazioniQueryMapper) {
    this.variazioniCausaliOperazioniRepository = variazioniCausaliOperazioniRepository;
    this.variazioniCausaliOperazioniQueryMapper = variazioniCausaliOperazioniQueryMapper;
  }

  @Override
  public Page<VariazioniCausaliOperazioniQueryEntity> searchQueryVariazioniCausaliOperazioni(
    GenericSearchRequest<VariazioniCausaliOperazioniFilter> query) {
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

    List<Specification<VariazioniCausaliOperazioniQueryEntity>> specifications = new ArrayList<>();

    VariazioniCausaliOperazioniFilter filter =  VariazioniCausaliOperazioniFilter.createFilterFromMap(query.getFilter()) .createFilterFromMap(query.getFilter());

    if (filter.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
    }
    if (filter.getCodice() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("codice"), filter.getCodice()));
    }
    if (filter.getNome() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("nome")), "%" + filter.getNome().toUpperCase() + "%"));
    }

    if (filter.getDescrizione() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("descrizione")), "%" + filter.getDescrizione().toUpperCase() + "%"));
    }
    if (filter.getVariazioniCausaliId() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("variazioniCausali").get("id")),
                  "%" + filter.getVariazioniCausaliId().toUpperCase() + "%"));
    }
    if (filter.getOperazione() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("operazione")), "%" + filter.getOperazione().toUpperCase() + "%"));
    }
    if (filter.getPriorita() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("priorita"), filter.getPriorita()));
    }
    if (filter.getFlgEsecuzioneImmediata() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("flgEsecuzioneImmediata")),
                  "%" + filter.getFlgEsecuzioneImmediata().toUpperCase() + "%"));
    }
    if (filter.getFlgAttivo() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("flgAttivo")), "%" + filter.getFlgAttivo().toUpperCase() + "%"));
    }
    if (filter.getVersion() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
    }

    if (filter.getPadreId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("padre").get("id"), filter.getPadreId()));
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
            Subquery<VariazioniCausaliOperazioniQueryEntity> subquery = criteriaQuery.subquery(VariazioniCausaliOperazioniQueryEntity.class);
            Root<VariazioniCausaliOperazioniQueryEntity> subRoot = subquery.from(VariazioniCausaliOperazioniQueryEntity.class);

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

    Specification<VariazioniCausaliOperazioniQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<VariazioniCausaliOperazioniQueryEntity> page =
        this.variazioniCausaliOperazioniRepository.findAll(specification, pageable);

    VariazioniCausaliOperazioniResponse variazioniCausaliOperazioniResponse =
        new VariazioniCausaliOperazioniResponse();
    List<VariazioniCausaliOperazioniQueryDTO> list =
        page.getContent().stream()
            .map(entity -> variazioniCausaliOperazioniQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    variazioniCausaliOperazioniResponse.setRecords(list);

    variazioniCausaliOperazioniResponse.setPagination(Pagination.buildPagination(page));

    return page;
  }

  @Override
  public VariazioniCausaliOperazioniResponse searchVariazioniCausaliOperazioni(
    GenericSearchRequest<VariazioniCausaliOperazioniFilter> query) {

    VariazioniCausaliOperazioniResponse VariazioniCausaliOperazioniResponse =
        new VariazioniCausaliOperazioniResponse();
    Page<VariazioniCausaliOperazioniQueryEntity> page =
        searchQueryVariazioniCausaliOperazioni(query);
    List<VariazioniCausaliOperazioniQueryDTO> list =
        page.getContent().stream()
            .map(entity -> variazioniCausaliOperazioniQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    VariazioniCausaliOperazioniResponse.setRecords(list);
    VariazioniCausaliOperazioniResponse.setPagination(Pagination.buildPagination(page));
    return VariazioniCausaliOperazioniResponse;
  }
}
