package com.pt_fullstack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "tb_tipo_contribuyentes")
public class Tb_tipo_contribuyente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11, nullable = false)
    private int id_tipo_contribuyente;
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;
    @Column(name = "estado", nullable = false)
    private boolean estado;

    @OneToMany(mappedBy = "tb_tipo_contribuyente", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Tb_entidad> tb_entidads = new HashSet<>();
}
