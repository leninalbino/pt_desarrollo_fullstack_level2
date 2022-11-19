package com.pt_fullstack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Data
@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name="tb_entidad", uniqueConstraints = {@UniqueConstraint(columnNames = {"nro_documento"})})
public class Tb_entidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private int id_entidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tb_tipo_documento_id", nullable = false)
    //@Column(name="id_tipo_documento", nullable = false, length = 11)
    private Tb_tipo_documento tb_tipo_documento;

    @Column(name="nro_documento", nullable = false, length = 25)
    private String nro_documento;

    @Column(name="razon_social",nullable = false, length = 100)
    private String razon_social;

    @Column(name="nombre_comercial", nullable = true, length = 100)
    private String nombre_comercial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tb_tipo_contribuyente_id", nullable = false)
    //@Column(name="id_tipo_contribuyente", nullable = true,length = 11)
    private Tb_tipo_contribuyente tb_tipo_contribuyente;

    @Column(name="direccion", nullable = true, length = 250)
    private String direccion;

    @Column(name="telefono", nullable = true, length = 50)
    private String telefono;

    @Column(name="estado", nullable = false)
    private boolean estado;
}
