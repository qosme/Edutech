package com.educacion.educacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educacion.educacion.models.entities.Curso;
import com.educacion.educacion.models.repositories.CursoRepository;

@Service;
public class CursoServices {
    @Autowired
    private CursoRepository cursoRepository;


    public Curso obtenerporid(int id) {
        return cursoRepository.findById(id).orElse(null);
        if(curso == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado");

        }
        return curso;   


    }
    public List<Curso> obtenerTodos() {
        return cursoRepository.findAll();

        public Curso crearNuevo(Curso curso) {
            return cursoRepository.save(curso);
        }
    }
        