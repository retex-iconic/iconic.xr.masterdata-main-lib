package com.retexspa.xr.ms.masterdata.main.query.services;


import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.ArticoloVenditaQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.ArticoloVenditaListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.ArticoliVenditaResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.ArticoloVenditaSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloVenditaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.ArticoloVenditaQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.ArticoloVenditaRepository;
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

@Service
public class ArticoloVenditaQueryServiceImpl implements ArticoloVenditaQueryService {

  @Autowired private ArticoloVenditaRepository articoloVenditaRepository;

  @Autowired ArticoloVenditaQueryMapper articoloVenditaQueryMapper;

  @PersistenceContext private EntityManager entityManager;

  public ArticoloVenditaQueryServiceImpl( ArticoloVenditaRepository articoloVenditaRepository) {
    this.articoloVenditaRepository = articoloVenditaRepository;
  }

  @Override
  public ArticoliVenditaResponse listArticoloVendita(ArticoloVenditaListQuery query) {
    ArticoliVenditaResponse articoliVenditaResponse = new ArticoliVenditaResponse();
    Page<ArticoloVenditaQueryEntity> page =
        this.articoloVenditaRepository.findAll(PageRequest.of(query.getPage(), query.getLimit()));
    List<ArticoloVenditaQueryDTO> list =
        page.getContent().stream()
            .map(entity -> articoloVenditaQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    articoliVenditaResponse.setRecords(list);
    articoliVenditaResponse.setPagination(Pagination.buildPagination(page));
    return articoliVenditaResponse;
  }

  /* @Override
  public ArticoloVenditaQueryDTO getArticoloVenditaById(ArticoloVenditaByIdQuery query) {
    ArticoloVenditaQueryEntity articoloVenditaQueryEntity =
        this.articoloVenditaRepository.findById(query.getArticoloVenditaId()).get();
    // ArticoloVenditaQueryDTO articoloVenditaQueryDTO =
    //     modelMapper.map(articoloVenditaQueryEntity, ArticoloVenditaQueryDTO.class);
    ArticoloVenditaQueryDTO articoloVenditaQueryDTO =
        articoloVenditaQueryMapper.toDTO(articoloVenditaQueryEntity);
    return articoloVenditaQueryDTO;
  }*/

  @Override
  public ArticoliVenditaResponse searchArticoloVendita(ArticoloVenditaSearchRequest query) {
    Page<ArticoloVenditaQueryEntity> page = searchQueryArticoloVendita(query);
    ArticoliVenditaResponse ArticoliVenditaResponse = new ArticoliVenditaResponse();
    List<ArticoloVenditaQueryDTO> list =
        page.getContent().stream()
            .map(entity -> articoloVenditaQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    ArticoliVenditaResponse.setRecords(list);

    ArticoliVenditaResponse.setPagination(Pagination.buildPagination(page));

    return ArticoliVenditaResponse;
  }

  @Override
  public Page<ArticoloVenditaQueryEntity> searchQueryArticoloVendita(
      ArticoloVenditaSearchRequest query) {

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

    List<Specification<ArticoloVenditaQueryEntity>> specifications = new ArrayList<>();

    if (query.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), query.getId()));
    }
    if (query.getNome() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("nome")), "%" + query.getNome().toUpperCase() + "%"));
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
    if (query.getArticoloId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("articolo").get("id"), query.getArticoloId()));
    }
    if (query.getStatoId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("stato").get("id"), query.getStatoId()));
    }
    if (query.getTipoArticoloVenditaId() != null) {
      specifications.add(
          (r, q, c) ->
              c.equal(r.get("tipoArticoloVendita").get("id"), query.getTipoArticoloVenditaId()));
    }
    if (query.getSottotipoArticoloVenditaId() != null) {
      specifications.add(
          (r, q, c) ->
              c.equal(
                  r.get("sottotipoArticoloVendita").get("id"),
                  query.getSottotipoArticoloVenditaId()));
    }
    if (query.getRepartoId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("reparto").get("id"), query.getRepartoId()));
    }
    if (query.getIvaId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("iva").get("id"), query.getIvaId()));
    }
    if (query.getCosto() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("costo"), query.getCosto()));
    }
    if (query.getTara() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("tara"), query.getTara()));
    }
    if (query.getMaxArt() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("maxArt"), query.getMaxArt()));
    }
    if (query.getDataOraInizio() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("dataOraInizio"), query.getDataOraInizio()));
    }
    if (query.getDataOraFine() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("dataOraFine"), query.getDataOraFine()));
    }
    if (query.getOraFine() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("oraFine"), query.getOraFine()));
    }
    if (query.getOraInizio() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("oraInizio"), query.getOraInizio()));
    }
    if (query.getAa3() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("aa3"), query.getAa3()));
    }
    if (query.getAa4() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("aa4"), query.getAa4()));
    }
    if (query.getFlgCancellato() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("flgCancellato")),
                  "%" + query.getFlgCancellato().toUpperCase() + "%"));
    }
    if (query.getDataCancellazione() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("dataCancellazione"), query.getDataCancellazione()));
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
            Subquery<ArticoloVenditaQueryEntity> subquery =
                criteriaQuery.subquery(ArticoloVenditaQueryEntity.class);
            Root<ArticoloVenditaQueryEntity> subRoot =
                subquery.from(ArticoloVenditaQueryEntity.class);

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

    Specification<ArticoloVenditaQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<ArticoloVenditaQueryEntity> page =
        this.articoloVenditaRepository.findAll(specification, pageable);

    return page;
  }
}
