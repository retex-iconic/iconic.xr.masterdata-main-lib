package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloInfoServizioQueryEntity;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticoloInfoServizioRepository
    extends JpaRepository<ArticoloInfoServizioQueryEntity, String>,
        JpaSpecificationExecutor<ArticoloInfoServizioQueryEntity> {

  List<ArticoloInfoServizioQueryEntity> findAllByArticoloId(String articoloId);
}
