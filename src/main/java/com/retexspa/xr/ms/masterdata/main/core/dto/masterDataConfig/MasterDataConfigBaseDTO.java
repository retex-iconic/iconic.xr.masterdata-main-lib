package com.retexspa.xr.ms.masterdata.main.core.dto.masterDataConfig;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.config.ConfigBaseDTO;


@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MasterDataConfigBaseDTO extends ConfigBaseDTO{
    public static String getName() {
        return "MasterDataConfig";
    }

    public static String getNameNodo() {
        return "MasterDataConfigNodo";
    }

    public static String getDetailNameMoltiplicatoreConfig() {
        return "MasterDataConfigCodiceMoltiplicatore";
    }

    public static String getDetailNameStatoConfig() {
        return "MasterDataConfigStato";
    }

    public static String getDetailNameTipoEanConfig() {
        return "MasterDataConfigTipoEan";
    }

    public static String getDetailNameTipoVenditaConfig() {
        return "MasterDataConfigTipoArticoloVendita";
    }

    public static String getDetailNameSottoTipoVenditaConfig() {
        return "MasterDataConfigSottotipoArticoloVendita";
    }

    public static String getAggregateName() {
        return "MasterDataConfigAggregate";
    }
}
