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
import com.educacion.educacion.services.CursoService;

import jakarta.validation.Valid;

@RequestMapping("/curso")
@RestController
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping("/todos")
    public List<Curso> todos(){
        return cursoService.obtenerTodos();
    }

    @GetMapping("/listar/{id}")
    public Curso listarUno(@PathVariable int id){
        return cursoService.obtenerPorId(id);
    }


    @PostMapping("/nuevo")
    public Curso crearNuevo(@Valid @RequestBody CursoCrear cuerpo){
        return cursoService.crearNuevo(cuerpo);
    }
}
