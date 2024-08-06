package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloNastroPrezziQueryEntity;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticoloNastroPrezziRepository
    extends JpaRepository<ArticoloNastroPrezziQueryEntity, String>,
        JpaSpecificationExecutor<ArticoloNastroPrezziQueryEntity> {

  void deleteByArticoloNastroPrezziId(String articoloNastroPrezziId);
  List<ArticoloNastroPrezziQueryEntity> findAllByPadreId(String id);
  List<ArticoloNastroPrezziQueryEntity> findAllByArticoloIdAndDataOraInizio(
      String articoloId, LocalDateTime localDateTime);
}
