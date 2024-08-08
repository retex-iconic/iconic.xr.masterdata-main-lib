package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.EsclusioniFpServizioQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EsclusioniFpServizioRepository
    extends JpaRepository<EsclusioniFpServizioQueryEntity, String>,
    JpaSpecificationExecutor<EsclusioniFpServizioQueryEntity> {
  List<EsclusioniFpServizioQueryEntity> findAllByCodice(String codice);

  List<EsclusioniFpServizioQueryEntity> findAllByServizioId(String Id);
}
