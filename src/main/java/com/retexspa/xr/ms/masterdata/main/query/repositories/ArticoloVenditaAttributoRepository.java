package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloVenditaAttributoQueryEntity;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticoloVenditaAttributoRepository
    extends JpaRepository<ArticoloVenditaAttributoQueryEntity, String>,
        JpaSpecificationExecutor<ArticoloVenditaAttributoQueryEntity> {

  List<ArticoloVenditaAttributoQueryEntity> findByArticoloVenditaId(String articoloVenditaId);

  void deleteByArticoloVenditaId(String articoloVenditaId);

  Optional<ArticoloVenditaAttributoQueryEntity> findByArticoloVenditaIdAndAttributoId(
      String id, String attributoId);

  void deleteByArticoloVenditaIdAndAttributoId(String id, String attributoId);
}
