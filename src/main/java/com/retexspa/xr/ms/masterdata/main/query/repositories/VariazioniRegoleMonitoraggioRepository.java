package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.VariazioniRegoleMonitoraggioQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VariazioniRegoleMonitoraggioRepository
    extends JpaRepository<VariazioniRegoleMonitoraggioQueryEntity, String>,
        JpaSpecificationExecutor<VariazioniRegoleMonitoraggioQueryEntity> {
  // find by unique keys
  List<VariazioniRegoleMonitoraggioQueryEntity>
      findAllBySchemaAndNomeTabellaAndNomeCampoAndRegolaConfronto(
          String schema, String nomeTabella, String nomeCampo, String regolaConfronto);
    // find by padre id
    List<VariazioniRegoleMonitoraggioQueryEntity> findAllByPadreId(String id);
}
