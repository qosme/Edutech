package com.admin.models.request;

import org.hibernate.validator.constraints.URL;

import lombok.Data;

@Data

public class ContenidoModificar {

private int id;


    private String titulo;
    
    private String descripcion;
    
    private String urlVideo;
    
    @URL
    private int cursoId;

    





    
}
