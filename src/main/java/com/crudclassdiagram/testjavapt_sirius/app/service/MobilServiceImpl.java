package com.crudclassdiagram.testjavapt_sirius.app.service;

import com.crudclassdiagram.testjavapt_sirius.app.dto.MobilDTO;
import com.crudclassdiagram.testjavapt_sirius.app.model.Mobil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobilServiceImpl implements MobilService{

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    RodaService rodaService;

    @Override
    public Mobil addMobil(Long RodaId, Mobil mobil) {
        final Roda roda = rodaService.findById(rodaId);
        if (roda != null){
            //add storm to db
             mobil = mobilRepository.save(mobil);
             if (roda.getMobiles() != null){
                 List<Mobil> mobiles = mobil.getMobile();
                 mobiles.add(mobil);
                 roda.setMobiles(mobiles);
             }else {
                 mobil.setMobiles(Collection.singletonList(mobil));
             }
             rodaService.create(roda);
             return mobil;

        }
        return null;
    }

    @Override
    public Mobil mapToEntity(MobilDTO mobilDTO) {
        return mapper.convertValue(mobilDTO,Mobil.class);
    }

    @Override
    public MobilDTO mapToDto(Mobil mobil) {
        return mapper.convertValue(mobil, MobilDTO.class);
    }
}
