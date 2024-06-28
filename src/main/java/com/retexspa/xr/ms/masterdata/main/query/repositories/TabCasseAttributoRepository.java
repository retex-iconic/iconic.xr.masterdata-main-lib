package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.TabCasseAttributoQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TabCasseAttributoRepository extends JpaRepository<TabCasseAttributoQueryEntity, String>,
        JpaSpecificationExecutor<TabCasseAttributoQueryEntity> {


    List<TabCasseAttributoQueryEntity> findByTabCasseIdAndAttributoId(
            String id, String attributoId);

    void deleteByTabCasseIdAndAttributoId(String id, String attributoId);
}

