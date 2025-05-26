package com.admin.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data   
@Table
public class Contenido {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(nullable = false)
private String titulo;

@Column(nullable = false)
private String descripcion;
@Column(nullable = false)
private String urlVideo;

@ManyToOne
@JoinColumn(name = "curso_id", nullable = false)
@JsonBackReference
private Cursos curso;




}
