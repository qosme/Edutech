package com.educacion.educacion.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CursoCrear {
    @NotBlank
    private String nombre;

}
    