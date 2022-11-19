package com.pt_fullstack.dto;

import com.pt_fullstack.model.Tb_entidad;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Tb_tipo_contribuyente_DTO {
    private int id_tipo_contribuyente;
    private String nombre;
    private boolean estado;
    private Set<Tb_entidad> tb_entidads = new HashSet<>();
}
