package com.retexspa.xr.ms.masterdata.main.query.services;


import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.ArticoloVenditaQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.ArticoloVenditaFilter;
import com.retexspa.xr.ms.masterdata.main.core.queries.ArticoloVenditaListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.ArticoliVenditaResponse;
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
  public ArticoliVenditaResponse searchArticoloVendita(GenericSearchRequest<ArticoloVenditaFilter> query) {
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
          GenericSearchRequest<ArticoloVenditaFilter> query) {

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

    ArticoloVenditaFilter filter = ArticoloVenditaFilter.createFilterFromMap(query.getFilter());

    if (filter.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
    }
    if (filter.getNome() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("nome")), "%" + filter.getNome().toUpperCase() + "%"));
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
    if (filter.getArticoloId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("articolo").get("id"), filter.getArticoloId()));
    }
    if (filter.getStatoId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("stato").get("id"), filter.getStatoId()));
    }
    if (filter.getTipoArticoloVenditaId() != null) {
      specifications.add(
          (r, q, c) ->
              c.equal(r.get("tipoArticoloVendita").get("id"), filter.getTipoArticoloVenditaId()));
    }
    if (filter.getSottotipoArticoloVenditaId() != null) {
      specifications.add(
          (r, q, c) ->
              c.equal(
                  r.get("sottotipoArticoloVendita").get("id"),
                  filter.getSottotipoArticoloVenditaId()));
    }
    if (filter.getRepartoId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("reparto").get("id"), filter.getRepartoId()));
    }
    if (filter.getIvaId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("iva").get("id"), filter.getIvaId()));
    }
    if (filter.getCosto() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("costo"), filter.getCosto()));
    }
    if (filter.getTara() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("tara"), filter.getTara()));
    }
    if (filter.getMaxArt() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("maxArt"), filter.getMaxArt()));
    }
    if (filter.getDataOraInizio() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("dataOraInizio"), filter.getDataOraInizio()));
    }
    if (filter.getDataOraFine() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("dataOraFine"), filter.getDataOraFine()));
    }
    if (filter.getOraFine() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("oraFine"), filter.getOraFine()));
    }
    if (filter.getOraInizio() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("oraInizio"), filter.getOraInizio()));
    }
    if (filter.getAa3() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("aa3"), filter.getAa3()));
    }
    if (filter.getAa4() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("aa4"), filter.getAa4()));
    }
    if (filter.getFlgCancellato() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("flgCancellato")),
                  "%" + filter.getFlgCancellato().toUpperCase() + "%"));
    }
    if (filter.getDataCancellazione() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("dataCancellazione"), filter.getDataCancellazione()));
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
    if (filter.getPadreId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("padre").get("id"), filter.getPadreId()));
    }

    Specification<ArticoloVenditaQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<ArticoloVenditaQueryEntity> page =
        this.articoloVenditaRepository.findAll(specification, pageable);

    return page;
  }
}
