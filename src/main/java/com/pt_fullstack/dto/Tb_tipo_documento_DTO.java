package com.pt_fullstack.dto;

import com.pt_fullstack.model.Tb_entidad;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tb_tipo_documento_DTO {

    private int id_tipo_documento;
    private String codigo;
    private String nombre;
    private String descripcion;
    private boolean estado;
    private Set<Tb_entidad> tb_entidads = new HashSet<>();
}
