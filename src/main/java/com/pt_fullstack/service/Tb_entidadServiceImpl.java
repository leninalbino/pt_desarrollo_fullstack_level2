package com.pt_fullstack.service;

import com.pt_fullstack.dto.Tb_entidad_DTO;
import com.pt_fullstack.model.Tb_entidad;
import com.pt_fullstack.repository.Tb_entidadRepository;
import com.pt_fullstack.repository.Tb_tipo_contribuyenteRepository;
import com.pt_fullstack.repository.Tb_tipo_documentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import org.modelmapper.ModelMapper;
import java.util.stream.Collectors;

public class Tb_entidadServiceImpl implements Tb_entidadService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private Tb_entidadRepository tb_entidadRepository;

    @Autowired
    private Tb_tipo_documentoRepository tb_tipo_documentoRepository;

    @Autowired
    private Tb_tipo_contribuyenteRepository tb_tipo_contribuyenteRepository;

    @Override
    public List<Tb_entidad_DTO> ListEntidad(int pagenumber, int pageSize, String orderBy, String Sort) {
        return null;
    }

    @Override
    public List<Tb_entidad_DTO> findEntidadByTypeDocument(int id) {
        return null;
    }

    @Override
    public Tb_entidad_DTO saveEntidad(Tb_entidad_DTO tb_entidad_dto) {

        return null;
    }

    @Override
    public Tb_entidad_DTO findById(int id) {
        return null;
    }

    @Override
    public Tb_entidad_DTO updateEntidad(int TypeDocument, int tb_entidadId, Tb_entidad_DTO tb_entidad_dto) {
        return null;
    }

    @Override
    public void deleteEntidad(int typeDocumentId, int entidadId) {

    }

    private Tb_entidad_DTO mapearDto(Tb_entidad tb_entidad){
        Tb_entidad_DTO tb_entidad_dto = modelMapper.map(tb_entidad, Tb_entidad_DTO.class);
        return tb_entidad_dto;
    }

    private Tb_entidad mapearEntidad(Tb_entidad_DTO tb_entidad_dto){
        Tb_entidad tb_entidad = modelMapper.map(tb_entidad_dto, Tb_entidad.class);
        return tb_entidad;
    }
}
