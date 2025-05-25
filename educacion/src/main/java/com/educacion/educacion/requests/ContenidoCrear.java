package com.educacion.educacion.requests;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContenidoCrear {
    @NotBlank
    private String titulo;
    
    @NotBlank
    private String descripcion;
    
    @NotBlank
    @URL
    private String urlVideo;
    
    @NotBlank
    private int idCurso;
}