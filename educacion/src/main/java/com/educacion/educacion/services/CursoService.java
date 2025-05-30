package com.educacion.educacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.educacion.educacion.models.entities.Curso;
import com.educacion.educacion.models.requests.CursoCrear;
import com.educacion.educacion.repositories.CursoRepository;

@Service   
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;


    public Curso obtenerPorId(int id) {
        Curso curso = cursoRepository.findById(id).orElse(null);
        if(curso == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Curso no encontrado");
        }
        return curso;
    }

    public List<Curso> obtenerTodos(){
        return cursoRepository.findAll();
    }

    public Curso crearNuevo(CursoCrear solicitud){
        Curso nuevo = new Curso();
        nuevo.setNombre(solicitud.getNombre());
        return cursoRepository.save(nuevo);
    }
}
