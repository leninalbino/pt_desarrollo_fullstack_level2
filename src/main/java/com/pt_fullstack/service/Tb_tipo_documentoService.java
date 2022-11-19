package com.pt_fullstack.service;

import com.pt_fullstack.dto.Tb_Tipo_Documento_Respuesta;
import com.pt_fullstack.dto.Tb_tipo_documento_DTO;

import java.util.List;

public interface Tb_tipo_documentoService {
    public Tb_Tipo_Documento_Respuesta ListTipoDocuments(int pagenumber, int pageSize, String orderBy, String Sort);
    public Tb_tipo_documento_DTO saveTipoDocument(Tb_tipo_documento_DTO tb_tipo_documento_DTO);
    public Tb_tipo_documento_DTO findById(int id);
    public Tb_tipo_documento_DTO updateTipoDocument(Tb_tipo_documento_DTO tb_tipo_documento_DTO, int id);
    public void deleteTipoDocument(int id);
}
