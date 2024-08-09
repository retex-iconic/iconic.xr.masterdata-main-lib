package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.TipologiaServizioQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TipologiaServizioRepository
    extends JpaRepository<TipologiaServizioQueryEntity, String>,
    JpaSpecificationExecutor<TipologiaServizioQueryEntity> {
  List<TipologiaServizioQueryEntity> findAllByCodice(String codice);

  List<TipologiaServizioQueryEntity> findAllByPadreId(String id);

}
