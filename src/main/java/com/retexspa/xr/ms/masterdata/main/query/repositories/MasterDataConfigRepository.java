package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.MasterDataConfigQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MasterDataConfigRepository
    extends JpaRepository<MasterDataConfigQueryEntity, String>,
        JpaSpecificationExecutor<MasterDataConfigQueryEntity> {
  MasterDataConfigQueryEntity findByCodice(String codice);
}
