package com.pt_fullstack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@Table(name = "tb_tipo_documentos")
public class Tb_tipo_documento {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11, nullable = false)
    private int id_tipo_documento;
    @Column(name = "codigo",length = 20, nullable = false)
    private String codigo;
    @Column(name = "nombre",length = 100, nullable = false)
    private String nombre;
    @Column(name = "descripcion",length = 200, nullable = true)
    private String descripcion;
    @Column(name = "estado", nullable = false)
    private boolean estado;

    @OneToMany(mappedBy = "tb_tipo_documento", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Tb_entidad> tb_entidads = new HashSet<>();
}
