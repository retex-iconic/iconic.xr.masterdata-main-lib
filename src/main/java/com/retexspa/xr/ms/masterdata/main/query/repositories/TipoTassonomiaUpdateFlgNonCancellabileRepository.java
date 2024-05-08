package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.TipoTassonomiaUpdateFlgNonCancellabileQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TipoTassonomiaUpdateFlgNonCancellabileRepository
    extends JpaRepository<TipoTassonomiaUpdateFlgNonCancellabileQueryEntity, String>,
        JpaSpecificationExecutor<TipoTassonomiaUpdateFlgNonCancellabileQueryEntity> {}
