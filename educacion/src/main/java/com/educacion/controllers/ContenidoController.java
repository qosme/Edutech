package example.educacion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;  

@RestController
@RequestMapping("/contenido")
public class ContenidoController {
    @Autowired
    private ContenidoService contenidoService;

    @GetMapping("")
    public List<Contenido> obtenerTodos() {
        return contenidoService.obtenerTodos();
    }

    @PostMapping("")

    public Contenido crearNuevo(@Valid.@RequestBody ContenidoCrear cuerpo) {
        return contenidoService.crearNuevo(cuerpo;
    }
    @DeleteMapping("/{id}")
    public String eliminarContenido(@PathVariable int id) {
        contenidoService.eliminar(id);
        // Retorna un mensaje de éxito
        return "ok";
        
    }
    // Endpoint para obtener todos los contenidos
    // @GetMapping("")
    // public List<Contenido> obtenerTodos() {
    //     return contenidoService.obtenerTodos();
    // }

    // Endpoint para obtener un contenido por su ID
    // @GetMapping("/{id}")
    // public Contenido obtenerPorId(@PathVariable int id) {
    //     return contenidoService.obtenerporid(id);
    // }

    // Endpoint para crear un nuevo contenido
    // @PostMapping("")
    // public Contenido crearNuevo(@RequestBody ContenidoCrear solicitud) {
    //     return contenidoService.crearNuevo(solicitud);
    // }

    @
}