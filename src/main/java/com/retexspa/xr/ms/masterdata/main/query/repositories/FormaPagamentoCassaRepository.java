package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.FormaPagamentoCassaQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FormaPagamentoCassaRepository
    extends JpaRepository<FormaPagamentoCassaQueryEntity, String>,
        JpaSpecificationExecutor<FormaPagamentoCassaQueryEntity> {
  List<FormaPagamentoCassaQueryEntity> findAllByXx1mtyAndXx1mnr(Integer xx1mty, Integer xx1mnr);
}
