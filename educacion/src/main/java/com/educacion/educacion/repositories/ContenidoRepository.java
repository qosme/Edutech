package com.educacion.educacion.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educacion.educacion.models.entities.Contenido;   

@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
