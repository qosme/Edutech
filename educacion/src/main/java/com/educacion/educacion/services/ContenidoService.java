package com.educacion.educacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educacion.educacion.models.entities.Contenido;
import com.educacion.educacion.models.repositories.ContenidoRepository;

@Service
public class ContenidoService {
    @Autowired
    private ContenidoRepository contenidoRepository;

  
    }

    // Método para obtener todos los contenidos
    public List<Contenido> obtenerTodos() {
        return contenidoRepository.findAll();
    }

    // Método para crear un nuevo contenido
    public Contenido obtenerporid(int id) {
        return contenidoRepository.findById(id).orElse(null);
        if(contenido == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contenido no encontrado");
        }
        return contenido;
    }
    public Contenido crearNuevo(ContenidoCear Solicitud) {
        Contenido contenido = new Contenido();
        
        nuevo setdescripcion(Solicitud.getDescripcion());
        nuevo setTipo(Solicitud.getTipo());
        nuevo setUrlVideo(Solicitud.getUrl());

        Curso cursoasociado = cursoRepository.findById(Solicitud.getIdCurso()).orElse(null);

        nuevo setCurso(cursoasociado);
        return contenidoRepository.save(nuevo);

              
    }
    public void eliminar (int id) {
        Contenido contenido = obtenerporid(id);
       
            
        contenidoRepository.delete(contenido);
    }

    public void modificarContenido(contenidoModificarsolicitud) {
        Contenido contenido = obtenerporid(solicitud.getId());
        if(solicitud.gettitulo() != null) {
            contenido.settitulo(solicitud.getTitulo());
    
    }
    if (solicitud.getDescripcion() != null) {
        contenido.settitulo(solicitud.getDescripcion());
    }
    if (solicitud.getUrlVideo() != null) {
        contenido.setUrlVideo(solicitud.getUrlVideo());
    }
    return contenidoRepository.save(contenido);
    }
}
