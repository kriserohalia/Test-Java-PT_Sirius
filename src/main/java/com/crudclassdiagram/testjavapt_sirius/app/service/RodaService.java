package com.crudclassdiagram.testjavapt_sirius.app.service;
import com.crudclassdiagram.testjavapt_sirius.app.dto.RodaDTO;
import com.crudclassdiagram.testjavapt_sirius.app.model.Roda;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface RodaService {

    Roda create(Roda roda);
    Roda update(Long id, Roda roda);
    Boolean delete(Long id);
    List<Roda> findAll();

    Page<Roda> findAll(Pageable  pageable);
    Roda findByID(Long id);

    Roda findById(Long id);

    RodaDTO mapToDto(Roda roda);
    Roda mapToEntity(RodaDTO rodaDTO);

}
