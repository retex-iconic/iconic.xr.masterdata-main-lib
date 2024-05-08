package com.retexspa.xr.ms.masterdata.main.query.services;
import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.AnagraficaServizioQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.AnagraficaServizioByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.queries.AnagraficaServizioListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.AnagraficaServizioResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.AnagraficaServizioSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.AnagraficaServizioQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.AnagraficaServizioQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.AnagraficaServizioRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class AnagraficaServizioQueryServiceImpl implements AnagraficaServizioQueryService {

  private AnagraficaServizioRepository anagraficaServizioRepository;

  @Autowired private AnagraficaServizioQueryMapper anagraficaServizioQueryMapper;

  @PersistenceContext EntityManager entityManager;

  QueryGateway queryGateway;

  public AnagraficaServizioQueryServiceImpl(
      QueryGateway queryGateway, AnagraficaServizioRepository anagraficaServizioRepository) {
    this.queryGateway = queryGateway;
    this.anagraficaServizioRepository = anagraficaServizioRepository;
  }

  @Override
  public AnagraficaServizioResponse listAnagraficaServizio(AnagraficaServizioListQuery query) {

    AnagraficaServizioResponse anagraficaServizioResponse = new AnagraficaServizioResponse();

    Page<AnagraficaServizioQueryEntity> page =
        this.anagraficaServizioRepository.findAll(
            PageRequest.of(query.getPage(), query.getLimit()));

    List<AnagraficaServizioQueryDTO> list =
        page.getContent().stream()
            .map(entity -> anagraficaServizioQueryMapper.toDTO(entity))
            .collect(Collectors.toList());

    anagraficaServizioResponse.setRecords(list);

    anagraficaServizioResponse.setPagination(Pagination.buildPagination(page));

    return anagraficaServizioResponse;
  }

  @Override
  public Page<AnagraficaServizioQueryEntity> searchQueryAnagraficaServizio(
      AnagraficaServizioSearchRequest query) {
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

    List<Specification<AnagraficaServizioQueryEntity>> specifications = new ArrayList<>();

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

    if (query.getCollocazione() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("collocazione")),
                  "%" + query.getCollocazione().toUpperCase() + "%"));
    }
    if (query.getProviderId() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("providerId")), "%" + query.getProviderId().toUpperCase() + "%"));
    }
    if (query.getTipologiaServizioId() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("tipologiaServizio").get("id")),
                  "%" + query.getTipologiaServizioId().toUpperCase() + "%"));
    }
    if (query.getFiduciaria() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("fiduciaria")), "%" + query.getFiduciaria().toUpperCase() + "%"));
    }
    if (query.getDesScontrino() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("desScontrino")),
                  "%" + query.getDesScontrino().toUpperCase() + "%"));
    }
    if (query.getServiceType() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("serviceType")), "%" + query.getServiceType().toUpperCase() + "%"));
    }
    // TODO MASTERDATA
    if (query.getConfig() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("config")), "%" + query.getConfig().toUpperCase() + "%"));
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
            Subquery<AnagraficaServizioQueryEntity> subquery =
                criteriaQuery.subquery(AnagraficaServizioQueryEntity.class);
            Root<AnagraficaServizioQueryEntity> subRoot =
                subquery.from(AnagraficaServizioQueryEntity.class);

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

    Specification<AnagraficaServizioQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);
    Page<AnagraficaServizioQueryEntity> page =
        this.anagraficaServizioRepository.findAll(specification, pageable);
    return page;
  }

  @Override
  public AnagraficaServizioResponse searchAnagraficaServizio(
      AnagraficaServizioSearchRequest query) {
    Page<AnagraficaServizioQueryEntity> page = searchQueryAnagraficaServizio(query);
    AnagraficaServizioResponse anagraficaServizioResponse = new AnagraficaServizioResponse();
    List<AnagraficaServizioQueryDTO> list =
        page.getContent().stream()
            .map(entity -> anagraficaServizioQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    anagraficaServizioResponse.setRecords(list);

    anagraficaServizioResponse.setPagination(Pagination.buildPagination(page));

    return anagraficaServizioResponse;
  }

  @Override
  public AnagraficaServizioQueryDTO getAnagraficaServizioById(AnagraficaServizioByIdQuery query) {

    AnagraficaServizioQueryEntity anagraficaServizioQueryEntity =
        this.anagraficaServizioRepository.findById(query.getAnagraficaServizioId()).orElse(null);

    return anagraficaServizioQueryMapper.toDTO(anagraficaServizioQueryEntity);
  }
}
