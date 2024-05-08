package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloTassonomiaQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticoloTassonomiaRepository
    extends JpaRepository<ArticoloTassonomiaQueryEntity, String>,
        JpaSpecificationExecutor<ArticoloTassonomiaQueryEntity> {

  List<ArticoloTassonomiaQueryEntity> findAllByArticoloIdAndTassonomiaId(
      String articoloId, String tassonomiaId);
}
