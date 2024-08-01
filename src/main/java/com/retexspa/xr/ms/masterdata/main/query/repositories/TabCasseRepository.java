package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.TabCasseQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TabCasseRepository extends JpaRepository<TabCasseQueryEntity, String>, JpaSpecificationExecutor<TabCasseQueryEntity> {
    TabCasseQueryEntity findByCodice(String codice);

    List<TabCasseQueryEntity> findAllByCodice(String codice);

    List<TabCasseQueryEntity> findAllByTipoCassa(String id);

}
