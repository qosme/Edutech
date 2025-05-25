package com.example.educacion.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import  org.springframework.web.bind.annotation.RestController;



@RequestMapping("/curso")
@RestController
public cursoController {
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