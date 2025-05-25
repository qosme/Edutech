package com.example.educacion.services;
import org.springframework.beans.factory.annotation.Autowired;

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
        