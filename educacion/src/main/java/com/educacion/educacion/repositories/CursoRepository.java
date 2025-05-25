package com.educacion.educacion.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educacion.educacion.models.entities.Curso;   

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    
    // Aquí puedes agregar métodos personalizados si es necesario
}
