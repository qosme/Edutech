package com.educacion.educacion.models.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import lombok.Data;
import jakarta.persistence.*;


@Data
@Entity
@Table(name = "contenido")
public class Contenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable=false)
    private String titulo; 
    @Column(nullable=false)
    private String descripcion;
    @Column(nullable=false)
    private String urlVideo;

    
    @ManyToOne
    @JoinColumn (name = "curso_id", nullable = false)
    private Curso curso;


}

   