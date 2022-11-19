package com.pt_fullstack.service;

import com.pt_fullstack.Exceptions.ResourceNotFoundException;
import com.pt_fullstack.dto.Tb_Tipo_Documento_Respuesta;
import com.pt_fullstack.dto.Tb_tipo_documento_DTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.pt_fullstack.model.Tb_tipo_documento;
import com.pt_fullstack.repository.Tb_tipo_documentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Tb_tipo_documentoServiceImpl implements Tb_tipo_documentoService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Tb_tipo_documentoRepository tb_tipo_documentoRepository;


    @Override
    public Tb_Tipo_Documento_Respuesta ListTipoDocuments(int pagenumber, int pageSize, String orderBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(orderBy).ascending()
                                                                            : Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(pagenumber, pageSize, sort);
        Page<Tb_tipo_documento> TipoDocumentos = tb_tipo_documentoRepository.findAll(pageable);

        List<Tb_tipo_documento> listaTipoDocumentos = TipoDocumentos.getContent();
        List<Tb_tipo_documento_DTO> contenido = listaTipoDocumentos.stream()
                                                                    .map(tipo_documento -> mapearDto(tipo_documento))
                                                                    .collect(Collectors.toList());
        Tb_Tipo_Documento_Respuesta tb_tipo_documento_respuesta = new Tb_Tipo_Documento_Respuesta();
        tb_tipo_documento_respuesta.setContenido(contenido);
        tb_tipo_documento_respuesta.setNumeroPagina(TipoDocumentos.getNumber());
        tb_tipo_documento_respuesta.setMedidaPagina(TipoDocumentos.getSize());
        tb_tipo_documento_respuesta.setTotalElementos(TipoDocumentos.getTotalElements());
        tb_tipo_documento_respuesta.setTotalPaginas(TipoDocumentos.getTotalPages());
        tb_tipo_documento_respuesta.setUltima(TipoDocumentos.isLast());
        return tb_tipo_documento_respuesta;
    }

    @Override
    public Tb_tipo_documento_DTO saveTipoDocument(Tb_tipo_documento_DTO tb_tipo_documento_DTO) {
        Tb_tipo_documento tb_tipo_documento = mapearEntidad(tb_tipo_documento_DTO);

        Tb_tipo_documento nuevatipo_documento = tb_tipo_documentoRepository.save(tb_tipo_documento);

        Tb_tipo_documento_DTO tb_tipo_documentoRespuesta = mapearDto(nuevatipo_documento);

        return tb_tipo_documentoRespuesta;
    }

    @Override
    public Tb_tipo_documento_DTO findById(int id) {
        Tb_tipo_documento tb_tipo_documento = tb_tipo_documentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tipo Documento", "id", id));
        return mapearDto(tb_tipo_documento);
    }

    @Override
    public Tb_tipo_documento_DTO updateTipoDocument(Tb_tipo_documento_DTO tb_tipo_documento_DTO, int id) {
        Tb_tipo_documento tb_tipo_documento = tb_tipo_documentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tipo Documento", "id", id));
        tb_tipo_documento.setCodigo(tb_tipo_documento_DTO.getCodigo());
        tb_tipo_documento.setNombre(tb_tipo_documento_DTO.getNombre());
        tb_tipo_documento.setDescripcion(tb_tipo_documento_DTO.getDescripcion());
        tb_tipo_documento.setEstado(tb_tipo_documento_DTO.isEstado());

        Tb_tipo_documento tb_tipo_documento_actualizado = tb_tipo_documentoRepository.save(tb_tipo_documento);
        return mapearDto(tb_tipo_documento_actualizado);
    }

    @Override
    public void deleteTipoDocument(int id) {
        Tb_tipo_documento tb_tipo_documento = tb_tipo_documentoRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Tipo Documento", "id", id));
        tb_tipo_documentoRepository.delete(tb_tipo_documento);

    }

    private Tb_tipo_documento_DTO mapearDto(Tb_tipo_documento tb_tipo_documento){
        Tb_tipo_documento_DTO tb_entidad_dto = modelMapper.map(tb_tipo_documento, Tb_tipo_documento_DTO.class);
        return tb_entidad_dto;
    }

    private Tb_tipo_documento mapearEntidad(Tb_tipo_documento_DTO tb_tipo_documento_DTO){
        Tb_tipo_documento tb_tipo_documento = modelMapper.map(tb_tipo_documento_DTO, Tb_tipo_documento.class);
        return tb_tipo_documento;
    }


}
