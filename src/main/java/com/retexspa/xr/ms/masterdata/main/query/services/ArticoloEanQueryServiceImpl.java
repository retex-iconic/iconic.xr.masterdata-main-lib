package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.ArticoloEanQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.responses.ArticoloEanResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.ArticoloEanSearchRequest;
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
  public ArticoloEanResponse searchArticoloEan(ArticoloEanSearchRequest query) {
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
  public Page<ArticoloEanQueryEntity> searchQueryArticoloEan(ArticoloEanSearchRequest query) {

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

    if (query.getMoltiplicatore() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("moltiplicatore"), query.getMoltiplicatore()));
    }

    if (query.getCodiceVenditaLocale() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("codiceVenditaLocale")),
                  "%" + query.getCodiceVenditaLocale().toUpperCase() + "%"));
    }

    if (query.getDescrizioneCodiceVendita() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("descrizioneCodiceVendita")),
                  "%" + query.getDescrizioneCodiceVendita().toUpperCase() + "%"));
    }

    if (query.getQuantitaCodiceVendita() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("quantitaCodiceVendita"), query.getQuantitaCodiceVendita()));
    }

    if (query.getScontoCodiceVendita() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("scontoCodiceVendita"), query.getScontoCodiceVendita()));
    }

    if (query.getPrezzoCodiceVendita() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("prezzoCodiceVendita"), query.getPrezzoCodiceVendita()));
    }

    if (query.getAnagBil() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("anagBil")), "%" + query.getAnagBil().toUpperCase() + "%"));
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

    if (query.getArticoloId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("articolo").get("id"), query.getArticoloId()));
    }

    if (query.getCodiceMoltiplicatoreId() != null) {
      specifications.add(
          (r, q, c) ->
              c.equal(r.get("codiceMoltiplicatore").get("id"), query.getCodiceMoltiplicatoreId()));
    }

    if (query.getStatoId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("stato").get("id"), query.getStatoId()));
    }

    if (query.getTipoEanId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("tipoEan").get("id"), query.getTipoEanId()));
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
