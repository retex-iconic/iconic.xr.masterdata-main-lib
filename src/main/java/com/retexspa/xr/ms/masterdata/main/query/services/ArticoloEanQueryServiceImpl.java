package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.ArticoloEanQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.ArticoloEanFilter;
import com.retexspa.xr.ms.masterdata.main.core.responses.ArticoloEanResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloEanQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.ArticoloEanQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.ArticoloEanRepository;
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
public class ArticoloEanQueryServiceImpl implements ArticoloEanQueryService {

  @Autowired private ArticoloEanRepository articoloEanRepository;

  @Autowired ArticoloEanQueryMapper articoloEanQueryMapper;

  @PersistenceContext private EntityManager entityManager;

  @Override
  public ArticoloEanResponse searchArticoloEan(GenericSearchRequest<ArticoloEanFilter> query) {
    Page<ArticoloEanQueryEntity> page = searchQueryArticoloEan(query);
    ArticoloEanResponse articoloEanResponse = new ArticoloEanResponse();
    List<ArticoloEanQueryDTO> list =
        page.getContent().stream()
            .map(entity -> articoloEanQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    articoloEanResponse.setRecords(list);

    articoloEanResponse.setPagination(Pagination.buildPagination(page));

    return articoloEanResponse;
  }

  @Override
  public Page<ArticoloEanQueryEntity> searchQueryArticoloEan(GenericSearchRequest<ArticoloEanFilter> query) {

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

    List<Specification<ArticoloEanQueryEntity>> specifications = new ArrayList<>();

    ArticoloEanFilter filter = ArticoloEanFilter.createFilterFromMap(query.getFilter());

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

    if (filter.getMoltiplicatore() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("moltiplicatore"), filter.getMoltiplicatore()));
    }

    if (filter.getCodiceVenditaLocale() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("codiceVenditaLocale")),
                  "%" + filter.getCodiceVenditaLocale().toUpperCase() + "%"));
    }

    if (filter.getDescrizioneCodiceVendita() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("descrizioneCodiceVendita")),
                  "%" + filter.getDescrizioneCodiceVendita().toUpperCase() + "%"));
    }

    if (filter.getQuantitaCodiceVendita() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("quantitaCodiceVendita"), filter.getQuantitaCodiceVendita()));
    }

    if (filter.getScontoCodiceVendita() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("scontoCodiceVendita"), filter.getScontoCodiceVendita()));
    }

    if (filter.getPrezzoCodiceVendita() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("prezzoCodiceVendita"), filter.getPrezzoCodiceVendita()));
    }

    if (filter.getAnagBil() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("anagBil")), "%" + filter.getAnagBil().toUpperCase() + "%"));
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

    if (filter.getArticoloId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("articolo").get("id"), filter.getArticoloId()));
    }

    if (filter.getCodiceMoltiplicatoreId() != null) {
      specifications.add(
          (r, q, c) ->
              c.equal(r.get("codiceMoltiplicatore").get("id"), filter.getCodiceMoltiplicatoreId()));
    }

    if (filter.getStatoId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("stato").get("id"), filter.getStatoId()));
    }

    if (filter.getTipoEanId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("tipoEan").get("id"), filter.getTipoEanId()));
    }

    if (filter.getPadreId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("padre").get("id"), filter.getPadreId()));
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
            Subquery<ArticoloEanQueryEntity> subquery =
                criteriaQuery.subquery(ArticoloEanQueryEntity.class);
            Root<ArticoloEanQueryEntity> subRoot = subquery.from(ArticoloEanQueryEntity.class);

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

    Specification<ArticoloEanQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<ArticoloEanQueryEntity> page = this.articoloEanRepository.findAll(specification, pageable);

    return page;
  }
}
