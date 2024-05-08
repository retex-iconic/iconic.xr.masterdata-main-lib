package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloExtraQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticoloExtraRepository
    extends JpaRepository<ArticoloExtraQueryEntity, String>,
        JpaSpecificationExecutor<ArticoloExtraQueryEntity> {}
