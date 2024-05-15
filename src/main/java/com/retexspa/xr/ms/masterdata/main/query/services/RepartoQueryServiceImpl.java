package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.RepartoQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.responses.RepartoResponse;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.RepartoFilter;
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

  @Autowired
  RepartoQueryMapper repartoQueryMapper;

  @PersistenceContext
  private EntityManager entityManager;

  RepartoQueryServiceImpl(RepartoRepository repartoRepository) {
    this.repartoRepository = repartoRepository;
  }

  @Override
  public Page<RepartoQueryEntity> searchQueryReparto(GenericSearchRequest<RepartoFilter> query) {
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

    RepartoFilter filter = RepartoFilter.createFilterFromMap(query.getFilter());

    if (filter.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
    }

    if (filter.getCodice() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("codice")), "%" + filter.getCodice().toUpperCase() + "%"));
    }

    if (filter.getNome() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("nome")), "%" + filter.getNome().toUpperCase() + "%"));
    }

    if (filter.getDescrizione() != null) {
      specifications.add(
          (r, q, c) -> c.like(
              c.upper(r.get("descrizione")), "%" + filter.getDescrizione().toUpperCase() + "%"));
    }

    NativeQueryHelper NativeQueryHelper = new NativeQueryHelper();
    if (filter.getGerarchiaId() != null) {
      String gerarchNativeQuery = NativeQueryHelper.gerarchiaNativeQuery();
      Query hierarchiaRoots = entityManager
          .createNativeQuery(gerarchNativeQuery)
          .setParameter("gerarchiaid", filter.getGerarchiaId());
      List<String> hierarchiaRootsIds = hierarchiaRoots.getResultList();

      specifications.add(
          (root, criteriaQuery, criteriaBuilder) -> {
            // Define the subquery
            Subquery<RepartoQueryEntity> subquery = criteriaQuery.subquery(RepartoQueryEntity.class);
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

    if (filter.getIvaId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("iva").get("id"), filter.getIvaId()));
    }

    if (filter.getScontoPercentuale() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("scontoPercentuale"), filter.getScontoPercentuale()));
    }
    if (filter.getMargineFisso() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("margineFisso"), filter.getMargineFisso()));
    }
    if (filter.getAccettaPagamentoTicketRestaurant() != null) {
      specifications.add(
          (r, q, c) -> c.like(
              c.upper(r.get("accettaPagamentoTicketRestaurant")),
              "%" + filter.getAccettaPagamentoTicketRestaurant().toUpperCase() + "%"));
    }
    if (filter.getErogaPunti() != null) {
      specifications.add(
          (r, q, c) -> c.like(
              c.upper(r.get("erogaPunti")), "%" + filter.getErogaPunti().toUpperCase() + "%"));
    }
    if (filter.getErogaBuoni() != null) {
      specifications.add(
          (r, q, c) -> c.like(
              c.upper(r.get("erogaBuoni")), "%" + filter.getErogaBuoni().toUpperCase() + "%"));
    }
    if (filter.getErogaSconti() != null) {
      specifications.add(
          (r, q, c) -> c.like(
              c.upper(r.get("erogaSconti")), "%" + filter.getErogaSconti().toUpperCase() + "%"));
    }
    if (filter.getTracciabilitaOrtofrutta() != null) {
      specifications.add(
          (r, q, c) -> c.like(
              c.upper(r.get("tracciabilitaOrtofrutta")),
              "%" + filter.getTracciabilitaOrtofrutta().toUpperCase() + "%"));
    }
    if (filter.getTracciabilitaMacelleria() != null) {
      specifications.add(
          (r, q, c) -> c.like(
              c.upper(r.get("tracciabilitaMacelleria")),
              "%" + filter.getTracciabilitaMacelleria().toUpperCase() + "%"));
    }
    if (filter.getTracciabilitaPescheria() != null) {
      specifications.add(
          (r, q, c) -> c.like(
              c.upper(r.get("tracciabilitaPescheria")),
              "%" + filter.getTracciabilitaPescheria().toUpperCase() + "%"));
    }
    if (filter.getTracciabilitaGastronomia() != null) {
      specifications.add(
          (r, q, c) -> c.like(
              c.upper(r.get("tracciabilitaGastronomia")),
              "%" + filter.getTracciabilitaGastronomia().toUpperCase() + "%"));
    }
    if (filter.getSconto() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("sconto"), filter.getSconto()));
    }
    if (filter.getRepEcr() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("repEcr")), "%" + filter.getRepEcr().toUpperCase() + "%"));
    }
    if (filter.getRepLoc() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("repLoc")), "%" + filter.getRepLoc().toUpperCase() + "%"));
    }
    if (filter.getRepCedi() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("repCedi")), "%" + filter.getRepCedi().toUpperCase() + "%"));
    }
    if (filter.getMargine() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("margine"), filter.getMargine()));
    }
    if (filter.getFlgTicket() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("flgTicket")), "%" + filter.getFlgTicket().toUpperCase() + "%"));
    }
    if (filter.getFlgPunti() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("flgPunti")), "%" + filter.getFlgPunti().toUpperCase() + "%"));
    }
    if (filter.getFlgBuoni() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("flgBuoni")), "%" + filter.getFlgBuoni().toUpperCase() + "%"));
    }
    if (filter.getFlgSconti() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("flgSconti")), "%" + filter.getFlgSconti().toUpperCase() + "%"));
    }
    if (filter.getDataType() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("dataType")), "%" + filter.getDataType().toUpperCase() + "%"));
    }
    if (filter.getDataFunc() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("dataFunc")), "%" + filter.getDataFunc().toUpperCase() + "%"));
    }
    if (filter.getBackClr() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("backClr")), "%" + filter.getBackClr().toUpperCase() + "%"));
    }
    if (filter.getFlgOrto() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("flgOrto")), "%" + filter.getFlgOrto().toUpperCase() + "%"));
    }
    if (filter.getFlgMacel() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("flgMacel")), "%" + filter.getFlgMacel().toUpperCase() + "%"));
    }
    if (filter.getFlgPescheria() != null) {
      specifications.add(
          (r, q, c) -> c.like(
              c.upper(r.get("flgPescheria")),
              "%" + filter.getFlgPescheria().toUpperCase() + "%"));
    }
    if (filter.getFlgGastro() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("flgGastro")), "%" + filter.getFlgGastro().toUpperCase() + "%"));
    }
    if (filter.getRepEkom() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("repEkom")), "%" + filter.getRepEkom().toUpperCase() + "%"));
    }
    if (filter.getIdSendEcr() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("idSendEcr")), "%" + filter.getIdSendEcr().toUpperCase() + "%"));
    }
    if (filter.getDataOraUpd() != null) {
      specifications.add(
          (r, q, c) -> c.like(
              c.upper(r.get("dataOraUpd")), "%" + filter.getDataOraUpd().toUpperCase() + "%"));
    }
    if (filter.getBloccoPre() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("bloccoPre")), "%" + filter.getBloccoPre().toUpperCase() + "%"));
    }
    if (filter.getVersion() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
    }
    // dataCas
    Specification<RepartoQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);

    Page<RepartoQueryEntity> page = this.repartoRepository.findAll(specification, pageable);
    return page;
  }

  @Override
  public RepartoResponse searchReparto(GenericSearchRequest<RepartoFilter> query) {

    RepartoResponse repartoResponse = new RepartoResponse();
    Page<RepartoQueryEntity> page = searchQueryReparto(query);
    repartoResponse.setPagination(Pagination.buildPagination(page));
    List<RepartoQueryDTO> list = page.getContent().stream()
        .map(entity -> repartoQueryMapper.toDTO(entity))
        .collect(Collectors.toList());
    repartoResponse.setRecords(list);
    return repartoResponse;
  }
}
