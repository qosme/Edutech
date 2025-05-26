package com.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.admin.models.entities.Curso;
import com.admin.models.services.CursoService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;
     
    @GetMapping("")
    public List<Curso> Todos() {
        return cursoService.obtenerTodos();
    }
    @GetMapping("/{id}")
    public Curso listarUno(PathVariable int id) {
        return cursoService.obtenerCursoPorId(id);
    }
     @PostMapping("")
    public Curso crearNuevo(@Valid @RequestBody CursoCrear solicitud) {
        return cursoService.crearNuevo(cuerpo);
}
