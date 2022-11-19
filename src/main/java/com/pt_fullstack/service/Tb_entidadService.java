package com.pt_fullstack.service;

import com.pt_fullstack.dto.Tb_entidad_DTO;
import com.pt_fullstack.model.Tb_entidad;

import java.util.List;

public interface Tb_entidadService {
    public List<Tb_entidad_DTO> ListEntidad(int pagenumber, int pageSize, String orderBy, String Sort);
    public List<Tb_entidad_DTO> findEntidadByTypeDocument(int id);
    public Tb_entidad_DTO saveEntidad(Tb_entidad_DTO tb_entidad_dto);
    public Tb_entidad_DTO findById(int id);
    public Tb_entidad_DTO updateEntidad(int TypeDocument, int tb_entidadId, Tb_entidad_DTO tb_entidad_dto);
    public void deleteEntidad( int typeDocumentId, int entidadId);

}
