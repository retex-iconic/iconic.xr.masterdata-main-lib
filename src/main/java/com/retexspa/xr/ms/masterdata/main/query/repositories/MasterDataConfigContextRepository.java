package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.MasterDataConfigContextQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MasterDataConfigContextRepository
    extends JpaRepository<MasterDataConfigContextQueryEntity, String>,
        JpaSpecificationExecutor<MasterDataConfigContextQueryEntity> {
  MasterDataConfigContextQueryEntity findByCodice(String codice);
}
