package com.crudclassdiagram.testjavapt_sirius.app.service;

import com.crudclassdiagram.testjavapt_sirius.app.dto.MobilDTO;
import com.crudclassdiagram.testjavapt_sirius.app.model.Mobil;
public interface MobilService {
    Mobil addMobil(Long RodaId, Mobil mobil);

    Mobil mapToEntity(MobilDTO mobilDTO);
    MobilDTO mapToDto(Mobil mobil);
}
