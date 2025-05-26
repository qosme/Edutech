package com.admin.models.entities.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.models.entities.Contenido;
import com.admin.models.request.ContenidoCrear;
import com.admin.repositories.CursoRepository;

@Service
public class ContenidoService {
    @Autowired
    private ContenidoRepository contenidoRepository;
    @Autowired
    private CursoRepository cursoRepository;


    public List<Contenido> obtenerTodos() {
        return contenidoRepository.findAll();
    }
    public Contenido obtenerContenidoPorId(int id) {
        Contenido contenido = contenidoRepository.findById(id).orElse(null);
        if (contenido == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contenido no encontrado");
        }
        return contenido;
    }
    pulic Contenido crearNuevo(ContenidoCrear solicitud) {
        Contenido nuevoContenido = new Contenido();
        nuevoContenido.setTitulo(solicitud.getTitulo());
        nuevoContenido.setDescripcion(solicitud.getDescripcion());
        nuevoContenido.setUrlVideo(solicitud.getUrlVideo());
    
        Curso cursoAsociado = cursoRepository.findById(solicitud.getCursoId()).orElse(null);

        nuevo.setCurso(cursoAsociado);
        return contenidoRepository.save(nuevoContenido);
            
        
    }
    pulic void eliminarContenido(int id) {
        Contenido contenido = obtenerContenidoPorId(id);
        contenidoRepository.delete(contenido);
    }
    public Contenido modificar(){

    }

    public Contenido modificar(ContenidoModificar solicitud){
        Contenido contenido = obtenerContenidoPorId(solicitud.getCursoId());
        if(solicitud.getTitulo() != null) {
            contenido.setTitulo(solicitud.getTitulo());
        }
        if (solicitud.getDescripcion() != null) {
            contenido.setDescripcion(solicitud.getDescripcion());
            
        }
        if (solicitud.getUrlVideo() != null) {
            contenido.setUrlVideo(solicitud.getUrlVideo());
        }
        return contenidoRepository.save(contenido);
    }
    
}