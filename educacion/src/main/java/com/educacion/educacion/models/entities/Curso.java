package com.educacion.educacion.models.entities;



import lombok.Data;
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
}