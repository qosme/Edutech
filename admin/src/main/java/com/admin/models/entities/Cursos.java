package com.admin.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.OverridesAttribute.List;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import java.util.List;
import java.util.ArrayList;

@Entity
@Data
@Table(name = "cursos")
public class Cursos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonManagedReference
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contenido> contenidos = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappeBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contenido> contenidos = new ArrayList<>();

    }




}
