package com.educacion.educacion.models.requests;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ModifyContent {
    //para saber cual modificar
    private int id;

    private String titulo;

    private String descripcion;

    @URL
    private String urlVideo;

}
