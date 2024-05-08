package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.AttributoQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AttributoRepository
    extends JpaRepository<AttributoQueryEntity, String>,
        JpaSpecificationExecutor<AttributoQueryEntity> {}
