package com.educacion.educacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educacion.educacion.models.entities.Contenido;
import com.educacion.educacion.models.requests.ContenidoCrear;
import com.educacion.educacion.models.requests.ModifyContent;
import com.educacion.educacion.services.ContenidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/contenido")
public class ContenidoController {
    @Autowired
    private ContenidoService contenidoService;

    @GetMapping("")
    public List<Contenido> obtenerTodos() {
        return contenidoService.obtenerTodos();
    }

    @PostMapping("")
    public Contenido crearNuevo(@Valid @RequestBody ContenidoCrear cuerpo) {
        return contenidoService.crearNuevo(cuerpo);
    }

    @PutMapping("")
    public Contenido modificarContenido(@RequestBody ModifyContent cuerpo) {
        return contenidoService.modificarContenido(cuerpo);
    }

    @DeleteMapping("/{id}")
    public String eliminarContenido(@PathVariable int id) {
        contenidoService.eliminar(id);
        // Retorna un mensaje de éxito
        return "ok";
        
    }

    
}