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
import com.educacion.educacion.models.requests.ContenidoModificar;
import com.educacion.educacion.services.ContenidoService;

import jakarta.validation.Valid;

@RequestMapping("/contenido")
@RestController
public class ContenidoController {
    @Autowired
    private ContenidoService contenidoService;


    @GetMapping("/todos")
    public List<Contenido> listarTodos(){
        return contenidoService.obtenerTodos();
    }

    @PostMapping("/nuevo")
    public Contenido crearNuevo(@Valid @RequestBody ContenidoCrear cuerpo){
        return contenidoService.crearNuevo(cuerpo);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarContenido(@PathVariable int id){
        contenidoService.eliminar(id);
        return "Contenido eliminado correctamente";
    }

    @PutMapping("/modificar")
    public Contenido modificar(@RequestBody ContenidoModificar cuerpo){
        return contenidoService.modificar(cuerpo);
    }
}
