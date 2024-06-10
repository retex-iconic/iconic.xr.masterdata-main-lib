package com.retexspa.xr.ms.masterdata.main.query.services;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.FornitoreQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.FornitoreByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.queries.FornitoreListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.FornitoriResponse;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.FornitoreFilter;
import com.retexspa.xr.ms.masterdata.main.query.entities.FornitoreQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.FornitoreQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.FornitoreRepository;

@Service
public class FornitoreQueryServiceImpl implements FornitoreQueryService {

  @Autowired private FornitoreRepository fornitoreRepository;

  @Autowired FornitoreQueryMapper fornitoreQueryMapper;

  @PersistenceContext EntityManager entityManager;


  public FornitoreQueryServiceImpl(FornitoreRepository fornitoreRepository) {
  
    this.fornitoreRepository = fornitoreRepository;
  }

  @Override
  public FornitoriResponse listFornitore(FornitoreListQuery query) {

    FornitoriResponse fornitoriResponse = new FornitoriResponse();

    Page<FornitoreQueryEntity> page =
        this.fornitoreRepository.findAll(PageRequest.of(query.getPage(), query.getLimit()));

    List<FornitoreQueryDTO> list =
        page.getContent().stream()
            .map(entity -> fornitoreQueryMapper.toDTO(entity))
            .collect(Collectors.toList());

    fornitoriResponse.setRecords(list);

    fornitoriResponse.setPagination(Pagination.buildPagination(page));

    return fornitoriResponse;
  }

  @Override
  public Page<FornitoreQueryEntity> searchQueryFornitore(GenericSearchRequest<FornitoreFilter> query) {
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

    List<Specification<FornitoreQueryEntity>> specifications = new ArrayList<>();

    FornitoreFilter filter = FornitoreFilter.createFilterFromMap(query.getFilter());

    if (filter.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
    }
    if (filter.getCodice() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("codice")), "%" + filter.getCodice().toUpperCase() + "%"));
    }
    if (filter.getDescrizione() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("descrizione")), "%" + filter.getDescrizione().toUpperCase() + "%"));
    }
    if (filter.getNome() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("nome")), "%" + filter.getNome().toUpperCase() + "%"));
    }
    if (filter.getNumero() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("numero")), "%" + filter.getNumero().toUpperCase() + "%"));
    }
    if (filter.getIndirizzo() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("indirizzo")), "%" + filter.getIndirizzo().toUpperCase() + "%"));
    }
    if (filter.getCitta() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("citta")), "%" + filter.getCitta().toUpperCase() + "%"));
    }
    if (filter.getCap() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("cap")), "%" + filter.getCap().toUpperCase() + "%"));
    }
    if (filter.getPiva() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("piva")), "%" + filter.getPiva().toUpperCase() + "%"));
    }
    if (filter.getMagazzino() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("magazzino")), "%" + filter.getMagazzino().toUpperCase() + "%"));
    }
    if (filter.getCodiceEsterno() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("codiceEsterno")),
                  "%" + filter.getCodiceEsterno().toUpperCase() + "%"));
    }
    if (filter.getRagioneSociale() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("ragioneSociale")),
                  "%" + filter.getRagioneSociale().toUpperCase() + "%"));
    }
    if (filter.getCodiceFiscale() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("codiceFiscale")),
                  "%" + filter.getCodiceFiscale().toUpperCase() + "%"));
    }
    if (filter.getTelefono() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("telefono")), "%" + filter.getTelefono().toUpperCase() + "%"));
    }
    if (filter.getRank() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("rank")), "%" + filter.getRank().toUpperCase() + "%"));
    }
    if (filter.getTipoCod() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("tipoCod")), "%" + filter.getTipoCod().toUpperCase() + "%"));
    }
    if (filter.getEmail() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("email")), "%" + filter.getEmail().toUpperCase() + "%"));
    }
    if (filter.getCodiceEsterno2() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("codiceEsterno2")),
                  "%" + filter.getCodiceEsterno2().toUpperCase() + "%"));
    }
    if (filter.getCodiceContabilita() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("codiceContabilita")),
                  "%" + filter.getCodiceContabilita().toUpperCase() + "%"));
    }
    if (filter.getCodicePrecedenteBackOffice() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("codicePrecedenteBackOffice")),
                  "%" + filter.getCodicePrecedenteBackOffice().toUpperCase() + "%"));
    }
    if (filter.getVersion() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
    }
    NativeQueryHelper nativeQueryHelper = new NativeQueryHelper();

    if (filter.getGerarchiaId() != null) {
      String gerarchNativeQuery = nativeQueryHelper.gerarchiaNativeQuery();
      Query hierarchiaRoots =
          entityManager
              .createNativeQuery(gerarchNativeQuery)
              .setParameter("gerarchiaid", filter.getGerarchiaId());
      List<String> hierarchiaRootsIds = hierarchiaRoots.getResultList();

      specifications.add(
          (root, criteriaQuery, criteriaBuilder) -> {
            // Define the subquery
            Subquery<FornitoreQueryEntity> subquery =
                criteriaQuery.subquery(FornitoreQueryEntity.class);
            Root<FornitoreQueryEntity> subRoot = subquery.from(FornitoreQueryEntity.class);

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

    Specification<FornitoreQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);
    Page<FornitoreQueryEntity> page = this.fornitoreRepository.findAll(specification, pageable);
    return page;
  }

  @Override
  public FornitoriResponse searchFornitore(GenericSearchRequest<FornitoreFilter> query) {

    FornitoriResponse FornitoriResponse = new FornitoriResponse();
    Page<FornitoreQueryEntity> page = searchQueryFornitore(query);
    List<FornitoreQueryDTO> list =
        page.getContent().stream()
            // .map(entity -> modelMapper.map(entity, FornitoreQueryDTO.class))
            .map(entity -> fornitoreQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    FornitoriResponse.setRecords(list);
    FornitoriResponse.setPagination(Pagination.buildPagination(page));
    return FornitoriResponse;
  }

  @Override
  public FornitoreQueryDTO getFornitoreById(FornitoreByIdQuery query) {

    FornitoreQueryEntity fornitoreQueryEntity =
        this.fornitoreRepository.findById(query.getFornitoreId()).orElse(null);

    return fornitoreQueryMapper.toDTO(fornitoreQueryEntity);
  }
}
