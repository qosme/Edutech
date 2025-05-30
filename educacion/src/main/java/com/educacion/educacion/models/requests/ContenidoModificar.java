package com.educacion.educacion.models.requests;

import org.hibernate.validator.constraints.URL;

import lombok.Data;

@Data
public class ContenidoModificar {
        private int id;

    private String titulo;
    
    private String descripcion;

    @URL
    private String urlVideo;
}
