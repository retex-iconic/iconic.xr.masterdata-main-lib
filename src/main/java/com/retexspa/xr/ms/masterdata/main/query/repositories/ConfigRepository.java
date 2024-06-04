package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.ConfigQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ConfigRepository
    extends JpaRepository<ConfigQueryEntity, String>,
        JpaSpecificationExecutor<ConfigQueryEntity> {
  ConfigQueryEntity findByCodice(String codice);
}
