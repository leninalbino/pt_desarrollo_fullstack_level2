package com.pt_fullstack.service;

import com.pt_fullstack.dto.Tb_tipo_contribuyente_DTO;
import com.pt_fullstack.dto.Tb_tipo_documento_DTO;

import java.util.List;

public interface Tb_tipo_contribuyenteService {
    public List<Tb_tipo_contribuyente_DTO> ListTipoConstribuyente(int pagenumber, int pageSize, String orderBy, String Sort);
    public Tb_tipo_contribuyente_DTO saveTipoConstribuyente(Tb_tipo_contribuyente_DTO tb_tipo_contribuyente_DTO);
    public Tb_tipo_contribuyente_DTO findById(int id);
    public Tb_tipo_contribuyente_DTO updateTipoConstribuyente(Tb_tipo_contribuyente_DTO tb_tipo_contribuyente_DTO, int id);
    public void deleteTipoConstribuyente(int id);
}
