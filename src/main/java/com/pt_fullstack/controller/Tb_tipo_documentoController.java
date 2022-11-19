package com.pt_fullstack.controller;

import com.pt_fullstack.dto.Tb_Tipo_Documento_Respuesta;
import com.pt_fullstack.dto.Tb_tipo_documento_DTO;
import com.pt_fullstack.service.Tb_tipo_documentoService;
import com.pt_fullstack.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/entidades")
public class Tb_tipo_documentoController {
    @Autowired
    private Tb_tipo_documentoService tb_tipo_documentoService;

    @GetMapping
    public Tb_Tipo_Documento_Respuesta listarEntidades(
            @RequestParam(value = "pageNo", defaultValue = Constantes.NUMBER_PAGE_BY_DEFAULT, required = false)int pageNumber,
            @RequestParam(value= "pageSize", defaultValue = Constantes.SIZE_PAGE_BY_DEFAULT, required = false)int pageSize,
            @RequestParam(value = "sortBy", defaultValue = Constantes.ORDER_BY_DEFAULT, required = false) String orderBy,
            @RequestParam(value = "sortDir", defaultValue = Constantes.ORDER_DIRECTION_BY_DEFAULT, required = false) String sortDir){

        return tb_tipo_documentoService.ListTipoDocuments(pageNumber,pageSize, orderBy,sortDir);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tb_tipo_documento_DTO> obtenerEntidadPorId(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(tb_tipo_documentoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Tb_tipo_documento_DTO> guardarPublicacion(@Valid @RequestBody Tb_tipo_documento_DTO tb_tipo_documento_DTO) {
        return new ResponseEntity<>(tb_tipo_documentoService.saveTipoDocument(tb_tipo_documento_DTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEntidad(@PathVariable(name = "id") int id) {
        tb_tipo_documentoService.deleteTipoDocument(id);
        return new ResponseEntity<>("Entidad eliminada con exito", HttpStatus.OK);
    }
}
