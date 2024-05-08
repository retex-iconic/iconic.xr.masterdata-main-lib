package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.OperatorePosQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.OperatorePosByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.OperatorePosResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.OperatorePosSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.OperatorePOSQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.OperatorePosQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.OperatorePosRepository;
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
public class OperatorePosQueryServiceImpl implements OperatorePosQueryService {
  @PersistenceContext private EntityManager entityManager;
  OperatorePosRepository operatorePosRepository;

  OperatorePosQueryMapper operatorePosQueryMapper;

  OperatorePosQueryServiceImpl(
      OperatorePosRepository operatorePosRepository,
      OperatorePosQueryMapper operatorePosQueryMapper) {
    this.operatorePosRepository = operatorePosRepository;
    this.operatorePosQueryMapper = operatorePosQueryMapper;
  }

  @Override
  public OperatorePosQueryDTO getOperatorePosById(OperatorePosByIdQuery query) {
    OperatorePOSQueryEntity operatorePosQueryEntity =
        this.operatorePosRepository.findById(query.getOperatoreId()).orElse(null);

    return operatorePosQueryMapper.toDTO(operatorePosQueryEntity);
  }

  @Override
  public Page<OperatorePOSQueryEntity> searchQueryOperatorePos(OperatorePosSearchRequest query) {
    List<Sort.Order> sorts = new ArrayList<>();

    if (query.getSort() != null && query.getSort().size() != 0) {
      for (BaseSort baseSort : query.getSort()) {
        switch (baseSort.getOrderBy()) {
          case "id":
            break;

          case "nome":
            break;

          case "cognome":
            break;

          case "codice":
            break;

          case "mnemonic":
            break;

          case "password":
            break;
          case "gerarchiaId":
            break;

          case "padreId":
            break;

          case "version":
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
                baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "codice"));
      }
    }

    if (sorts.size() == 0) {
      sorts.add(new Sort.Order(Sort.Direction.ASC, "codice"));
    }

    Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

    List<Specification<OperatorePOSQueryEntity>> specifications = new ArrayList<>();

    if (query.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), query.getId()));
    }

    if (query.getCodice() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("codice")), "%" + query.getCodice().toUpperCase() + "%"));
    }
    if (query.getNome() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("nome")), "%" + query.getNome().toUpperCase() + "%"));
    }
    if (query.getCognome() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("cognome")), "%" + query.getCognome().toUpperCase() + "%"));
    }
    if (query.getMnemonic() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("mnemonic")), "%" + query.getMnemonic().toUpperCase() + "%"));
    }
    if (query.getPassword() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("password")), "%" + query.getPassword().toUpperCase() + "%"));
    }
    if (query.getPadreId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("padre").get("id"), query.getPadreId()));
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
            Subquery<OperatorePOSQueryEntity> subquery =
                criteriaQuery.subquery(OperatorePOSQueryEntity.class);
            Root<OperatorePOSQueryEntity> subRoot = subquery.from(OperatorePOSQueryEntity.class);

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

    Specification<OperatorePOSQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<OperatorePOSQueryEntity> page =
        this.operatorePosRepository.findAll(specification, pageable);
    return page;
  }

  @Override
  public OperatorePosResponse searchOperatorePos(OperatorePosSearchRequest query) {

    OperatorePosResponse operatorePosResponse = new OperatorePosResponse();
    Page<OperatorePOSQueryEntity> page = searchQueryOperatorePos(query);
    List<OperatorePosQueryDTO> list =
        page.getContent().stream()
            .map(entity -> operatorePosQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    operatorePosResponse.setRecords(list);

    operatorePosResponse.setPagination(Pagination.buildPagination(page));

    return operatorePosResponse;
  }
}
