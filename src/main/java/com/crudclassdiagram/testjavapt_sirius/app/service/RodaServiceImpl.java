package com.crudclassdiagram.testjavapt_sirius.app.service;

import com.crudclassdiagram.testjavapt_sirius.app.dto.RodaDTO;
import com.crudclassdiagram.testjavapt_sirius.app.model.Roda;
import com.crudclassdiagram.testjavapt_sirius.app.repository.RodaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;


import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class RodaServiceImpl  implements  RodaService{
    @Autowired
    private RodaRepository rodaRepository;

    @Override
    public Roda create(Roda roda){
        return rodaRepository.save(roda);
    }

    @Override
    public Roda update(Long id, Roda roda){
        Roda result =  findById(id);
        if (result != null) {
            result.setDiameter(roda.getDiameter());
            return rodaRepository.save(result);

        }
        return  null;
    }
    @Override
    public Boolean delete(Long id){
        Roda result = findById(id);
        if(result != null){
            //hard delete
            rodaRepository.deleteById(id);
            return  true;
        }
        return  false;
    }

    @Override
    public List<Roda> findAll(){
        return  rodaRepository.findAll();
    }

    @Override
    public Roda findByID(Long id) {
        return null;
    }

    @Override
    public Page<Roda> findAll(Pageable pageable){
        return rodaRepository.findAll(pageable) ;
    }

    @Override
    public Roda findById(Long id){
       Optional<Roda> result = rodaRepository.findById(id);
//        if (result.isPresent()){
//            result.get();
//        }

        return  result.orElse(null);
    }


    @Override
    public RodaDTO mapToDto(Roda roda){
        ObjectMapper mapper = new ObjectMapper();
        return  mapper.convertValue(roda, RodaDTO.class);
    }

    @Override
    public Roda mapToEntity(RodaDTO rodaDTO) {
        ObjectMapper mapper = new ObjectMapper();
        return  mapper.convertValue(rodaDTO, Roda.class);
    }
}
