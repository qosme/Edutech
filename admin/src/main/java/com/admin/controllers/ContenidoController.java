package com.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/contenido")
public class ContenidoController {
    @Autowired
    private ContenidoService contenidoService;

    @GetMapping("")
    public List<Contenido> listarTodos(){
        return contenidoService.obtenerTodos();

        @GetMapping("")
        public List<Contenido> listarTodos() {
            return contenidoService.obtenerTodos();
        }
        @PostMapping("")
        public Contenido crearNuevo(@Valid @RequestBody ContenidoCrear solicitud) {
            return contenidoService.crearNuevo(solicitud);
        }

        @DeleteMapping("/{id}")
        public void eliminarContenido(@PathVariable int id) {
            contenidoService.eliminar(id);

            return "OK"; 
            
        }
        @PutMapping("")
        pulic Contenido modificar(@Valid @RequestBody ContenidoModificar solicitud) {
            return contenidoService.modificar(cuerpo);
        }

    }








    
}
