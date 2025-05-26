package com.educacion.educacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educacion.educacion.models.entities.Curso;
import com.educacion.educacion.models.requests.CursoCrear;
import com.educacion.educacion.services.CursoServices;

@RequestMapping("/curso")
@RestController
public class CursoController {
    @Autowired
    private CursoServices cursoServices;
    
    // Endpoint para obtener todos los cursos
    @GetMapping("")
    public List<Curso>  Todos() {
        return cursoServices.obtenerTodos();
    }
    
    // Endpoint para obtener un curso por su ID
    @GetMapping("/{id}")
    public Curso listarPorId(@PathVariable int id) {
        return cursoServices.obtenerporid(id);
    }
    
    @PostMapping("")
    public Curso crearNuevo(@RequestBody CursoCrear cuerpo) {
        return cursoServices.crearNuevo(cuerpo);
    }