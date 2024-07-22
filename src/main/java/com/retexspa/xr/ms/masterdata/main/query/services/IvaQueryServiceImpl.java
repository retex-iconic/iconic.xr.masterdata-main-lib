package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.IvaQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.IvaFilter;
import com.retexspa.xr.ms.masterdata.main.core.queries.IvaByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.IvaResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.IvaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.IvaQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.IvaRepository;
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
public class IvaQueryServiceImpl implements IvaQueryService {

  IvaRepository ivaRepository;

  IvaQueryMapper ivaQueryMapper;

  @PersistenceContext
  private EntityManager entityManager;

  IvaQueryServiceImpl(IvaRepository ivaRepository, IvaQueryMapper ivaQueryMapper) {
    this.ivaRepository = ivaRepository;
    this.ivaQueryMapper = ivaQueryMapper;
  }

  @Override
  public IvaQueryDTO getIvaById(IvaByIdQuery query) {
    IvaQueryEntity ivaQueryEntity = this.ivaRepository.findById(query.getIvaId()).orElse(null);

    return ivaQueryMapper.toDTO(ivaQueryEntity);
  }

  @Override
  public Page<IvaQueryEntity> searchQueryIva(GenericSearchRequest<IvaFilter> query) {

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

    List<Specification<IvaQueryEntity>> specifications = new ArrayList<>();

    IvaFilter filter = IvaFilter.createFilterFromMap(query.getFilter());

    if (filter.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
    }
    if (filter.getCodice() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("codice"), filter.getCodice()));
    }
    if (filter.getCodIvaAcquisto() != null) {
      specifications.add(
          (r, q, c) -> c.like(
              c.upper(r.get("codIvaAcquisto")),
              "%" + filter.getCodIvaAcquisto().toUpperCase() + "%"));
    }
    if (filter.getCodiceECommerce() != null) {
      specifications.add(
          (r, q, c) -> c.like(
              c.upper(r.get("codiceECommerce")),
              "%" + filter.getCodiceECommerce().toUpperCase() + "%"));
    }
    if (filter.getCodiceEsterno() != null) {
      specifications.add(
          (r, q, c) -> c.like(
              c.upper(r.get("codiceEsterno")),
              "%" + filter.getCodiceEsterno().toUpperCase() + "%"));
    }
    if (filter.getDescrizione() != null) {
      specifications.add(
          (r, q, c) -> c.like(
              c.upper(r.get("descrizione")), "%" + filter.getDescrizione().toUpperCase() + "%"));
    }
    if (filter.getNaturaEsenzione() != null) {
      specifications.add(
          (r, q, c) -> c.like(
              c.upper(r.get("naturaEsenzione")),
              "%" + filter.getNaturaEsenzione().toUpperCase() + "%"));
    }
    if (filter.getNome() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("nome")), "%" + filter.getNome().toUpperCase() + "%"));
    }
    if (filter.getNormaEsenzione() != null) {
      specifications.add(
          (r, q, c) -> c.like(
              c.upper(r.get("normaEsenzione")),
              "%" + filter.getNormaEsenzione().toUpperCase() + "%"));
    }
    if (filter.getPercentuale() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("percentuale"), filter.getPercentuale()));
    }
    if (filter.getTipoIva() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("tipoIva")), "%" + filter.getTipoIva().toUpperCase() + "%"));
    }
    if (filter.getVersion() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
    }
    NativeQueryHelper nativeQueryHelper = new NativeQueryHelper();

    if (filter.getGerarchiaId() != null) {
      String gerarchNativeQuery = nativeQueryHelper.gerarchiaNativeQuery();
      Query hierarchiaRoots = entityManager
          .createNativeQuery(gerarchNativeQuery)
          .setParameter("gerarchiaid", filter.getGerarchiaId());
      List<String> hierarchiaRootsIds = hierarchiaRoots.getResultList();

      specifications.add(
          (root, criteriaQuery, criteriaBuilder) -> {
            // Define the subquery
            Subquery<IvaQueryEntity> subquery = criteriaQuery.subquery(IvaQueryEntity.class);
            Root<IvaQueryEntity> subRoot = subquery.from(IvaQueryEntity.class);

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
    if (filter.getPadreId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("padre").get("id"), filter.getPadreId()));
    }

    Specification<IvaQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);

    Page<IvaQueryEntity> page = this.ivaRepository.findAll(specification, pageable);

    IvaResponse ivaResponse = new IvaResponse();
    List<IvaQueryDTO> list = page.getContent().stream()
        .map(entity -> ivaQueryMapper.toDTO(entity))
        .collect(Collectors.toList());
    ivaResponse.setRecords(list);

    ivaResponse.setPagination(Pagination.buildPagination(page));

    return page;
  }

  @Override
  public IvaResponse searchIva(GenericSearchRequest<IvaFilter> query) {
    Page<IvaQueryEntity> page = searchQueryIva(query);
    IvaResponse ivaResponse = new IvaResponse();
    List<IvaQueryDTO> list = page.getContent().stream()
        .map(entity -> ivaQueryMapper.toDTO(entity))
        .collect(Collectors.toList());
    ivaResponse.setRecords(list);
    ivaResponse.setPagination(Pagination.buildPagination(page));
    return ivaResponse;
  }
}
