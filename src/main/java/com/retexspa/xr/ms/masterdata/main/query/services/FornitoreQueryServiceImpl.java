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
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.FornitoreQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.FornitoreByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.queries.FornitoreListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.FornitoriResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.FornitoreSearchRequest;
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
  public Page<FornitoreQueryEntity> searchQueryFornitore(FornitoreSearchRequest query) {
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

    if (query.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), query.getId()));
    }
    if (query.getCodice() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("codice")), "%" + query.getCodice().toUpperCase() + "%"));
    }
    if (query.getDescrizione() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("descrizione")), "%" + query.getDescrizione().toUpperCase() + "%"));
    }
    if (query.getNome() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("nome")), "%" + query.getNome().toUpperCase() + "%"));
    }
    if (query.getNumero() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("numero")), "%" + query.getNumero().toUpperCase() + "%"));
    }
    if (query.getIndirizzo() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("indirizzo")), "%" + query.getIndirizzo().toUpperCase() + "%"));
    }
    if (query.getCitta() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("citta")), "%" + query.getCitta().toUpperCase() + "%"));
    }
    if (query.getCap() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("cap")), "%" + query.getCap().toUpperCase() + "%"));
    }
    if (query.getPiva() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("piva")), "%" + query.getPiva().toUpperCase() + "%"));
    }
    if (query.getMagazzino() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("magazzino")), "%" + query.getMagazzino().toUpperCase() + "%"));
    }
    if (query.getCodiceEsterno() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("codiceEsterno")),
                  "%" + query.getCodiceEsterno().toUpperCase() + "%"));
    }
    if (query.getRagioneSociale() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("ragioneSociale")),
                  "%" + query.getRagioneSociale().toUpperCase() + "%"));
    }
    if (query.getCodiceFiscale() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("codiceFiscale")),
                  "%" + query.getCodiceFiscale().toUpperCase() + "%"));
    }
    if (query.getTelefono() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("telefono")), "%" + query.getTelefono().toUpperCase() + "%"));
    }
    if (query.getRank() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("rank")), "%" + query.getRank().toUpperCase() + "%"));
    }
    if (query.getTipoCod() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("tipoCod")), "%" + query.getTipoCod().toUpperCase() + "%"));
    }
    if (query.getEmail() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("email")), "%" + query.getEmail().toUpperCase() + "%"));
    }
    if (query.getCodiceEsterno2() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("codiceEsterno2")),
                  "%" + query.getCodiceEsterno2().toUpperCase() + "%"));
    }
    if (query.getCodiceContabilita() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("codiceContabilita")),
                  "%" + query.getCodiceContabilita().toUpperCase() + "%"));
    }
    if (query.getCodicePrecedenteBackOffice() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("codicePrecedenteBackOffice")),
                  "%" + query.getCodicePrecedenteBackOffice().toUpperCase() + "%"));
    }
    if (query.getVersion() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("version"), query.getVersion()));
    }
    NativeQueryHelper nativeQueryHelper = new NativeQueryHelper();

    if (query.getGerarchiaId() != null) {
      String gerarchNativeQuery = nativeQueryHelper.gerarchiaNativeQuery();
      Query hierarchiaRoots =
          entityManager
              .createNativeQuery(gerarchNativeQuery)
              .setParameter("gerarchiaid", query.getGerarchiaId());
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
    if (query.getPadreId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("padre").get("id"), query.getPadreId()));
    }

    Specification<FornitoreQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);
    Page<FornitoreQueryEntity> page = this.fornitoreRepository.findAll(specification, pageable);
    return page;
  }

  @Override
  public FornitoriResponse searchFornitore(FornitoreSearchRequest query) {

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
