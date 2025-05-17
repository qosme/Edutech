package com.educacion.educacion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EducacionController {

    @GetMapping("/saludo")
    public String saludo() {
        return "¡Bienvenido a la aplicación de Educación!";


                
    }
}








