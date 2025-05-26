package com.admin.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContenidoCrear {
    @NotBlank
    private String titulo;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String urlVideo;
    @NotBlank
    private int cursoId;     
}
