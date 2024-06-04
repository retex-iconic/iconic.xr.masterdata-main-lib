package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.ConfigContextQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ConfigContextRepository
    extends JpaRepository<ConfigContextQueryEntity, String>,
        JpaSpecificationExecutor<ConfigContextQueryEntity> {
  ConfigContextQueryEntity findByCodice(String codice);
}
