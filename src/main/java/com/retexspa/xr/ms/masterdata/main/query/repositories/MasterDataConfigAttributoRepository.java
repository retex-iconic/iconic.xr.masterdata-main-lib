package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.MasterDataConfigAttributoQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MasterDataConfigAttributoRepository
    extends JpaRepository<MasterDataConfigAttributoQueryEntity, String>,
        JpaSpecificationExecutor<MasterDataConfigAttributoQueryEntity> {

  List<MasterDataConfigAttributoQueryEntity> findByMasterDataConfigId(String articoloVenditaId);

  void deleteByMasterDataConfigId(String articoloVenditaId);

  List<MasterDataConfigAttributoQueryEntity> findByMasterDataConfigIdAndAttributoId(
      String id, String attributoId);

  void deleteByMasterDataConfigIdAndAttributoId(String id, String attributoId);
}
