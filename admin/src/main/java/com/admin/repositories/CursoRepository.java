package com.admin.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.admin.models.entities.Curso;

@Repository
public class CursoRepository extends JpaRepository<Curso,Integer> {


    
}
