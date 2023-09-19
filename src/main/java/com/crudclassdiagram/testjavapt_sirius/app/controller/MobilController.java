package com.crudclassdiagram.testjavapt_sirius.app.controller;

import com.crudclassdiagram.testjavapt_sirius.app.dto.MobilDTO;
import com.crudclassdiagram.testjavapt_sirius.app.service.MobilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.crudclassdiagram.testjavapt_sirius.app.model.Mobil;



@RestController
@RequestMapping("/mobil")
public class MobilController {

    @Autowired
    MobilService mobilService;

    @PostMapping("/add/{rodaId}")
    public MobilDTO addMobilToRoda(@PathVariable Long rodaId, @RequestBody MobilDTO request){
        final Mobil mobil = mobilService.mapToEntity(request);
        final Mobil result = mobilService.addMobil(rodaId, mobil);

        return  mobilService.mapToDto(result);
    }
}
