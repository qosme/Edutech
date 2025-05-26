package com.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.models.entities.Contenido;

@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Integer> {
    
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar contenidos por título o curso específico
    
}
