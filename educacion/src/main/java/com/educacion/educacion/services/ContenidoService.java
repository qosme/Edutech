package com.educacion.educacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.educacion.educacion.models.entities.Contenido;
import com.educacion.educacion.models.entities.Curso;
import com.educacion.educacion.models.requests.ContenidoCrear;
import com.educacion.educacion.models.requests.ModifyContent;
import com.educacion.educacion.repositories.ContenidoRepository;
import com.educacion.educacion.repositories.CursoRepository;

@Service
public class ContenidoService {
    @Autowired
    private ContenidoRepository contenidoRepository;
    
    @Autowired
    private CursoRepository cursoRepository;
    

    // Método para obtener todos los contenidos
    public List<Contenido> obtenerTodos() {
        return contenidoRepository.findAll();
    }

    // Método para crear un nuevo contenido
    public Contenido obtenerporid(int id) {
        Contenido contenido = contenidoRepository.findById(id).orElse(null);
        // Verificar si el contenido existe
        if(contenido == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contenido no fue encontrado!");
        }
        return contenido;
    }

    public Contenido crearNuevo(ContenidoCrear solicitud) {
        Contenido nuevo = new Contenido();

        nuevo.setTitulo(solicitud.getTitulo());
        nuevo.setDescripcion(solicitud.getDescripcion());
        nuevo.setUrlVideo(solicitud.getUrlVideo());

        //obtener id del curso
        Curso cursoAsociado=cursoRepository.findById(solicitud.getIdCurso()).orElse(null);
        nuevo.setCurso(cursoAsociado);
        return contenidoRepository.save(nuevo);
    }
    // Método para eliminar un contenido por ID
    public void eliminar (int id) {
        Contenido contenido = obtenerporid(id);
       
            
        contenidoRepository.delete(contenido);
    }

    public Contenido modificarContenido(ModifyContent solicitud) {
        Contenido contenido = obtenerporid(solicitud.getId());
        if(solicitud.getTitulo() != null) {
            contenido.setTitulo(solicitud.getTitulo());
        }
        if (solicitud.getDescripcion() != null) {
            contenido.setTitulo(solicitud.getDescripcion());
        }
        if (solicitud.getUrlVideo() != null) {
            contenido.setUrlVideo(solicitud.getUrlVideo());
        }
        return contenidoRepository.save(contenido);
    }
}
