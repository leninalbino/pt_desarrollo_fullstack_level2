package com.pt_fullstack.controller;

import com.pt_fullstack.model.Tb_entidad;
import com.pt_fullstack.service.Tb_entidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class Tb_entidadController {

    @Autowired
    private Tb_entidadService tb_entidadService;

    @GetMapping
    public List<Tb_entidad>listEntidad(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false)int pageNumber,
            @RequestParam(value= "pageSize", defaultValue = "10", required = false)int pageSize){
        return null;
    }
}
