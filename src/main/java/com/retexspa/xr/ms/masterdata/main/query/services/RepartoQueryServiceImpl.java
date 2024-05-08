package com.retexspa.xr.ms.masterdata.main.query.services;


import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.RepartoQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.responses.RepartoResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.RepartoSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.RepartoQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.RepartoQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.RepartoRepository;
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
public class RepartoQueryServiceImpl implements RepartoQueryService {

  RepartoRepository repartoRepository;

  @Autowired RepartoQueryMapper repartoQueryMapper;

  @PersistenceContext private EntityManager entityManager;

  RepartoQueryServiceImpl(RepartoRepository repartoRepository) {
    this.repartoRepository = repartoRepository;
  }

  @Override
  public Page<RepartoQueryEntity> searchQueryReparto(RepartoSearchRequest query) {
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

    List<Specification<RepartoQueryEntity>> specifications = new ArrayList<>();

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

    if (query.getDescrizione() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("descrizione")), "%" + query.getDescrizione().toUpperCase() + "%"));
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
            Subquery<RepartoQueryEntity> subquery =
                criteriaQuery.subquery(RepartoQueryEntity.class);
            Root<RepartoQueryEntity> subRoot = subquery.from(RepartoQueryEntity.class);

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
    // }

    if (query.getIvaId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("iva").get("id"), query.getIvaId()));
    }

    if (query.getScontoPercentuale() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("scontoPercentuale"), query.getScontoPercentuale()));
    }
    if (query.getMargineFisso() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("margineFisso"), query.getMargineFisso()));
    }
    if (query.getAccettaPagamentoTicketRestaurant() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("accettaPagamentoTicketRestaurant")),
                  "%" + query.getAccettaPagamentoTicketRestaurant().toUpperCase() + "%"));
    }
    if (query.getErogaPunti() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("erogaPunti")), "%" + query.getErogaPunti().toUpperCase() + "%"));
    }
    if (query.getErogaBuoni() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("erogaBuoni")), "%" + query.getErogaBuoni().toUpperCase() + "%"));
    }
    if (query.getErogaSconti() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("erogaSconti")), "%" + query.getErogaSconti().toUpperCase() + "%"));
    }
    if (query.getTracciabilitaOrtofrutta() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("tracciabilitaOrtofrutta")),
                  "%" + query.getTracciabilitaOrtofrutta().toUpperCase() + "%"));
    }
    if (query.getTracciabilitaMacelleria() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("tracciabilitaMacelleria")),
                  "%" + query.getTracciabilitaMacelleria().toUpperCase() + "%"));
    }
    if (query.getTracciabilitaPescheria() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("tracciabilitaPescheria")),
                  "%" + query.getTracciabilitaPescheria().toUpperCase() + "%"));
    }
    if (query.getTracciabilitaGastronomia() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("tracciabilitaGastronomia")),
                  "%" + query.getTracciabilitaGastronomia().toUpperCase() + "%"));
    }
    if (query.getSconto() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("sconto"), query.getSconto()));
    }
    if (query.getRepEcr() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("repEcr")), "%" + query.getRepEcr().toUpperCase() + "%"));
    }
    if (query.getRepLoc() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("repLoc")), "%" + query.getRepLoc().toUpperCase() + "%"));
    }
    if (query.getRepCedi() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("repCedi")), "%" + query.getRepCedi().toUpperCase() + "%"));
    }
    if (query.getMargine() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("margine"), query.getMargine()));
    }
    if (query.getFlgTicket() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("flgTicket")), "%" + query.getFlgTicket().toUpperCase() + "%"));
    }
    if (query.getFlgPunti() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("flgPunti")), "%" + query.getFlgPunti().toUpperCase() + "%"));
    }
    if (query.getFlgBuoni() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("flgBuoni")), "%" + query.getFlgBuoni().toUpperCase() + "%"));
    }
    if (query.getFlgSconti() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("flgSconti")), "%" + query.getFlgSconti().toUpperCase() + "%"));
    }
    if (query.getDataType() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("dataType")), "%" + query.getDataType().toUpperCase() + "%"));
    }
    if (query.getDataFunc() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("dataFunc")), "%" + query.getDataFunc().toUpperCase() + "%"));
    }
    if (query.getBackClr() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("backClr")), "%" + query.getBackClr().toUpperCase() + "%"));
    }
    if (query.getFlgOrto() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("flgOrto")), "%" + query.getFlgOrto().toUpperCase() + "%"));
    }
    if (query.getFlgMacel() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("flgMacel")), "%" + query.getFlgMacel().toUpperCase() + "%"));
    }
    if (query.getFlgPescheria() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("flgPescheria")),
                  "%" + query.getFlgPescheria().toUpperCase() + "%"));
    }
    if (query.getFlgGastro() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("flgGastro")), "%" + query.getFlgGastro().toUpperCase() + "%"));
    }
    if (query.getRepEkom() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("repEkom")), "%" + query.getRepEkom().toUpperCase() + "%"));
    }
    if (query.getIdSendEcr() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("idSendEcr")), "%" + query.getIdSendEcr().toUpperCase() + "%"));
    }
    if (query.getDataOraUpd() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("dataOraUpd")), "%" + query.getDataOraUpd().toUpperCase() + "%"));
    }
    if (query.getBloccoPre() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("bloccoPre")), "%" + query.getBloccoPre().toUpperCase() + "%"));
    }
    if (query.getVersion() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("version"), query.getVersion()));
    }
    // dataCas
    Specification<RepartoQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<RepartoQueryEntity> page = this.repartoRepository.findAll(specification, pageable);
    return page;
  }

  @Override
  public RepartoResponse searchReparto(RepartoSearchRequest query) {

    RepartoResponse repartoResponse = new RepartoResponse();
    Page<RepartoQueryEntity> page = searchQueryReparto(query);
    repartoResponse.setPagination(Pagination.buildPagination(page));
    List<RepartoQueryDTO> list =
        page.getContent().stream()
            .map(entity -> repartoQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    repartoResponse.setRecords(list);
    return repartoResponse;
  }
}
