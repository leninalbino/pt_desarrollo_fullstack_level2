package com.pt_fullstack.dto;

import com.pt_fullstack.model.Tb_tipo_documento;
import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Tb_Tipo_Documento_Respuesta {
    private List<Tb_tipo_documento_DTO> contenido;
    private int numeroPagina;
    private int medidaPagina;
    private long totalElementos;
    private int totalPaginas;
    private boolean ultima;
}
