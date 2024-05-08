package com.retexspa.xr.ms.masterdata.main.query.services;


import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.ArticoloExtraQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.ArticoloExtraByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.queries.ArticoloExtraListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.ArticoliExtraResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.ArticoloExtraSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloExtraQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.entities.AtecoQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.ArticoloExtraQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.ArticoloExtraRepository;
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
public class ArticoloExtraQueryServiceImpl implements ArticoloExtraQueryService {

  @Autowired private ArticoloExtraRepository articoloExtraRepository;

  @Autowired ArticoloExtraQueryMapper articoloExtraQueryMapper;
  @PersistenceContext private EntityManager entityManager;

  public ArticoloExtraQueryServiceImpl(
      QueryGateway queryGateway, ArticoloExtraRepository articoloExtraRepository) {
    this.articoloExtraRepository = articoloExtraRepository;
  }

  @Override
  public ArticoliExtraResponse listArticoloExtra(ArticoloExtraListQuery query) {
    ArticoliExtraResponse articoliResponse = new ArticoliExtraResponse();
    Page<ArticoloExtraQueryEntity> page =
        this.articoloExtraRepository.findAll(PageRequest.of(query.getPage(), query.getLimit()));
    List<ArticoloExtraQueryDTO> list =
        page.getContent().stream()
            .map(entity -> articoloExtraQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    articoliResponse.setRecords(list);
    articoliResponse.setPagination(Pagination.buildPagination(page));
    return articoliResponse;
  }

  @Override
  public ArticoloExtraQueryDTO getArticoloExtraById(ArticoloExtraByIdQuery query) {
    ArticoloExtraQueryEntity articoloExtraQueryEntity =
        this.articoloExtraRepository.findById(query.getArticoloExtraId()).get();
    // ArticoloExtraQueryDTO articoloExtraQueryDTO =
    //     modelMapper.map(articoloExtraQueryEntity, ArticoloExtraQueryDTO.class);
    ArticoloExtraQueryDTO articoloExtraQueryDTO =
        articoloExtraQueryMapper.toDTO(articoloExtraQueryEntity);
    return articoloExtraQueryDTO;
  }

  @Override
  public ArticoliExtraResponse searchArticoloExtra(ArticoloExtraSearchRequest query) {

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

    List<Specification<ArticoloExtraQueryEntity>> specifications = new ArrayList<>();

    if (query.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), query.getId()));
    }

    if (query.getArticoloId() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("articolo").get("id")),
                  "%" + query.getArticoloId().toUpperCase() + "%"));
    }
    if (query.getPadreId() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("padre").get("id")), "%" + query.getPadreId().toUpperCase() + "%"));
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

    if (query.getLayoutesl() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("layoutesl")), "%" + query.getLayoutesl().toUpperCase() + "%"));
    }
    if (query.getGruppo() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("gruppo")), "%" + query.getGruppo().toUpperCase() + "%"));
    }
    if (query.getDescrizioneBreve() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("descrizioneBreve")),
                  "%" + query.getDescrizioneBreve().toUpperCase() + "%"));
    }
    if (query.getUnitaDiMisura() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("unitaDiMisura")),
                  "%" + query.getUnitaDiMisura().toUpperCase() + "%"));
    }
    if (query.getQuantita() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("quantita")), "%" + query.getQuantita().toUpperCase() + "%"));
    }
    if (query.getScortaMinima() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("scortaMinima")),
                  "%" + query.getScortaMinima().toUpperCase() + "%"));
    }

    if (query.getDeposito() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("deposito")), "%" + query.getDeposito().toUpperCase() + "%"));
    }
    if (query.getScaffale() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("scaffale")), "%" + query.getScaffale().toUpperCase() + "%"));
    }
    if (query.getSuperficieEspositiva() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("superficieEspositiva"), query.getSuperficieEspositiva()));
    }
    if (query.getQuantitaImpegnata() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("quantitaImpegnata"), query.getQuantitaImpegnata()));
    }
    if (query.getScortaMassima() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("scortaMassima")),
                  "%" + query.getScortaMassima().toUpperCase() + "%"));
    }
    if (query.getLayoutEtichetta() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("layoutEtichetta"), query.getLayoutEtichetta()));
    }
    if (query.getTipoProdotto() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("tipoProdotto")),
                  "%" + query.getTipoProdotto().toUpperCase() + "%"));
    }
    if (query.getNumeroEtichette() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("numeroEtichette"), query.getNumeroEtichette()));
    }
    if (query.getTipoScaricoVenduto() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("tipoScaricoVenduto")),
                  "%" + query.getTipoScaricoVenduto().toUpperCase() + "%"));
    }
    if (query.getFornitorePrimario() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("fornitorePrimario")),
                  "%" + query.getFornitorePrimario().toUpperCase() + "%"));
    }
    if (query.getFornitoreEtichetta() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("fornitoreEtichetta")),
                  "%" + query.getFornitoreEtichetta().toUpperCase() + "%"));
    }
    if (query.getPosizionamento() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("posizionamento"), query.getPosizionamento()));
    }
    if (query.getStagionalita() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("stagionalita"), query.getStagionalita()));
    }
    if (query.getTipoProdotto2() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("tipoProdotto2"), query.getTipoProdotto2()));
    }
    if (query.getSvalorizzazione() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("svalorizzazione")),
                  "%" + query.getSvalorizzazione().toUpperCase() + "%"));
    }
    if (query.getCluster() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("cluster")), "%" + query.getCluster().toUpperCase() + "%"));
    }
    if (query.getAssortimentoPuntoVendita() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("assortimentoPuntoVendita")),
                  "%" + query.getAssortimentoPuntoVendita().toUpperCase() + "%"));
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
            Subquery<AtecoQueryEntity> subquery = criteriaQuery.subquery(AtecoQueryEntity.class);
            Root<AtecoQueryEntity> subRoot = subquery.from(AtecoQueryEntity.class);

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

    Specification<ArticoloExtraQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<ArticoloExtraQueryEntity> page =
        this.articoloExtraRepository.findAll(specification, pageable);

    ArticoliExtraResponse ArticoliExtraResponse = new ArticoliExtraResponse();
    List<ArticoloExtraQueryDTO> list =
        page.getContent().stream()
            // .map(entity -> modelMapper.map(entity, ArticoloExtraQueryDTO.class))
            .map(entity -> articoloExtraQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    ArticoliExtraResponse.setRecords(list);

    ArticoliExtraResponse.setPagination(Pagination.buildPagination(page));

    return ArticoliExtraResponse;
  }
}
