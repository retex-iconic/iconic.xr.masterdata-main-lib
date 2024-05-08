package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloAcquistoQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticoloAcquistoRepository
    extends JpaRepository<ArticoloAcquistoQueryEntity, String> {}
