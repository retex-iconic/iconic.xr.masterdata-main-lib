package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.ConfigAttributoQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ConfigAttributoRepository
    extends JpaRepository<ConfigAttributoQueryEntity, String>,
        JpaSpecificationExecutor<ConfigAttributoQueryEntity> {

  List<ConfigAttributoQueryEntity> findByConfigId(String articoloVenditaId);

  void deleteByConfigId(String articoloVenditaId);

  List<ConfigAttributoQueryEntity> findByConfigIdAndAttributoId(
      String id, String attributoId);

  void deleteByConfigIdAndAttributoId(String id, String attributoId);
}
