package com.pt_fullstack.dto;

import com.pt_fullstack.model.Tb_tipo_contribuyente;
import com.pt_fullstack.model.Tb_tipo_documento;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tb_entidad_DTO {

    private int id_entidad;
    private Tb_tipo_documento tb_tipo_documento;
    @NotEmpty
    private String nro_documento;
    @NotEmpty
    private String razon_social;
    private String nombre_comercial;
    private Tb_tipo_contribuyente tb_tipo_contribuyente;
    private String direccion;
    private String telefono;
    private boolean estado;
}
