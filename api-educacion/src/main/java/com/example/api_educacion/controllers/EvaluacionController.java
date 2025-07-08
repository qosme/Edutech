package com.example.api_educacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_educacion.models.entities.Evaluacion;
import com.example.api_educacion.models.requests.EvaluacionCrear;
import com.example.api_educacion.models.requests.EvaluacionModificar;
import com.example.api_educacion.services.EvaluacionService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/evaluaciones")
@RestController
public class EvaluacionController {
    @Autowired
    private EvaluacionService evaluacionService;

    @GetMapping("/todos")
    public List<Evaluacion> listarTodos(){
        return evaluacionService.obtenerTodos();
    }

    @PostMapping("/nuevo")
    public Evaluacion crearNuevo(@Valid @RequestBody EvaluacionCrear cuerpo){
        return evaluacionService.crearNuevo(cuerpo);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarEvaluacion(@PathVariable int id){
        evaluacionService.eliminar(id);
        return "Evaluación eliminada correctamente";
    }

    @PutMapping("/modificar")
    public Evaluacion modificar(@RequestBody EvaluacionModificar cuerpo){
        return evaluacionService.modificar(cuerpo);
    }

    @GetMapping("buscar-por-usuario/{idUsuario}")
    public List<Evaluacion> getByUsuario(@PathVariable int idUsuario) {
        return evaluacionService.obtenerPorUsuario(idUsuario);
    }
    

}
