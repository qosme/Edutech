package com.example.api_usuario.controllers;

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

import com.example.api_usuario.http.response.EvaluacionByUserResponse;
import com.example.api_usuario.models.entities.User;
import com.example.api_usuario.models.requests.UserCreate;
import com.example.api_usuario.models.requests.UserUpdate;
import com.example.api_usuario.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/todos")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/uno/{id}")
    public User getOneUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/registrar")
    public User register(@Valid @RequestBody UserCreate body){
        return userService.register(body);
    }

    @PutMapping("/actualizar")
    public User update(@Valid @RequestBody UserUpdate body){
        return userService.updateUser(body);
    }

    @DeleteMapping("/eliminar/{id}")
    public String delete(@PathVariable int id) {
        userService.deleteUser(id);
        return "Usuario eliminado";
    }

    @GetMapping("/buscar-por-curso/{courseId}")
    public List<User> getByCourse(@PathVariable int courseId) {
        return userService.getByCourse(courseId);
    }

    @GetMapping("evaluaciones-por-usuario/{idUsuario}")
    public EvaluacionByUserResponse findEvaluacionByIdUsuario(@PathVariable int idUsuario){
        return userService.findEvaluacionByIdUsuario(idUsuario);
    }

    
}
