package com.retexspa.xr.ms.masterdata.main.query.repositories;


import com.retexspa.xr.ms.masterdata.main.query.entities.TipiCassaQueryEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TipiCassaRepository extends JpaRepository<TipiCassaQueryEntity, String>, JpaSpecificationExecutor<TipiCassaQueryEntity> {

    List<TipiCassaQueryEntity> findAllById(String id);
    
}
