package com.crudclassdiagram.testjavapt_sirius.app.controller;

import com.crudclassdiagram.testjavapt_sirius.app.dto.RodaDTO;
import com.crudclassdiagram.testjavapt_sirius.app.service.RodaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import com.crudclassdiagram.testjavapt_sirius.app.model.Roda;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roda")
public class RodaController {

    @Autowired
    RodaService rodaService;

    @PostMapping("/create")
    public RodaDTO create(@RequestBody RodaDTO request){
        final Roda roda = rodaService.mapToEntity(request);
        final Roda result = rodaService.create(roda);
        return  rodaService.mapToDto(result);
    }

    @PutMapping("/update/{id}")
    public RodaDTO update(@PathVariable Long id, @RequestBody RodaDTO request){
        final Roda roda = rodaService.mapToEntity(request);
        final Roda result = rodaService.update(id, roda);
        return  rodaService.mapToDto(result);
    }

    @GetMapping("/all")
    public List<RodaDTO> findAll(){
        return  rodaService.findAll().stream().map(roda -> rodaService.mapToDto(roda)).collect(Collectors.toList());
    }

    @GetMapping("/search")
    public Page<RodaDTO> findAllWithPagination(@PageableDefault Pageable pageable){
        return rodaService.findAll(pageable).map(roda -> rodaService.mapToDto(roda));
    }


    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return rodaService.delete(id);
    }

}
