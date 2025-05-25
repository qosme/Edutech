package com.example.educacion.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;   

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    
    // Aquí puedes agregar métodos personalizados si es necesario
}
