package com.administracion.administracion.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Contenido")
public class Contenido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String tipoContenido;

    @Column(nullable = false)
    private String urlContenido;

    @Column(nullable = false)
    private Long idCurso;

    @Column(nullable = false)
    private String fechaCreacion;

    @Column(nullable = false)
    private String fechaModificacion;

    public Contenido() {
    }

    public Contenido(Long id, String nombre, String descripcion, String tipoContenido, String urlContenido,
                     String fechaCreacion, String fechaModificacion, Long idCurso) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoContenido = tipoContenido;
        this.urlContenido = urlContenido;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.idCurso = idCurso;
    }
}
