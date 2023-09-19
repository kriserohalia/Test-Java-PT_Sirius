package com.crudclassdiagram.testjavapt_sirius.app.dto;

import java.util.List;

public record RodaDTO(Long id, int diameter, List<MobilDTO> mobilDTOS) {
}
