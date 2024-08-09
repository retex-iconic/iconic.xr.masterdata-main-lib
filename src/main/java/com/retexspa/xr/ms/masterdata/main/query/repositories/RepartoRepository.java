package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.RepartoQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RepartoRepository
    extends JpaRepository<RepartoQueryEntity, String>,
    JpaSpecificationExecutor<RepartoQueryEntity> {
  List<RepartoQueryEntity> findAllByCodice(String codice);

  List<RepartoQueryEntity> findAllByIvaId(String id);

  List<RepartoQueryEntity> findAllByPadreId(String id);
}
