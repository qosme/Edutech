package com.example.api_educacion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_educacion.models.entities.Contenido;

@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Integer> {
}
