package com.educacion.educacion.models.entities;



import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;



@Data
@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false)
    private String nombre;

    @JsonManagedReference
    @OneToMany(mappedBy = "curso", 
               cascade = CascadeType.ALL, 
               orphanRemoval = true)
    private List<Contenido> contenidos = new ArrayList<>();
}