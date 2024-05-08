package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.TipoPagamentoQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TipoPagamentoRepository
    extends JpaRepository<TipoPagamentoQueryEntity, String>,
        JpaSpecificationExecutor<TipoPagamentoQueryEntity> {
  List<TipoPagamentoQueryEntity> findAllByCodice(String codice);
}
