package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.TabCasseEstesaQueryEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TabCasseEstesaRepository extends JpaRepository<TabCasseEstesaQueryEntity, String>, JpaSpecificationExecutor<TabCasseEstesaQueryEntity> {

    List<TabCasseEstesaQueryEntity> findAllByTabCasseId(String id);
}
