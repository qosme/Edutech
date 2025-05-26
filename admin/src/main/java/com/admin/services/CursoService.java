package com.admin.models.entities.services;

import org.springframework.stereotype.Service;

import com.admin.models.request.CursoCrear;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    public Curso obtenerCursoPorId(int id) {
        return cursoRepository.findById(id).orElse(null);
        if(curso == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado");
            
        }
        return curso;
    }
    public List<Curso> obtenerTodos() {
        return cursoRepository.findAll();
    }
    public Curso crearnuevo(CursoCrear solicitud){
        Curso nuevoCurso = new Curso();
        nuevoCurso.setNombre(solicitud.getNombre());
        return cursoRepository.save(nuevo);
    }
}