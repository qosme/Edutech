package com.usuario.usuario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.usuario.models.entities.User;
import com.usuario.usuario.models.requests.UserCreate;
import com.usuario.usuario.models.requests.UserUpdate;
import com.usuario.usuario.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getOneUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public User register(@Valid @RequestBody UserCreate body){
        return userService.register(body);
    }

    @PutMapping()
    public User update(@Valid @RequestBody UserUpdate body){
        return userService.updateUser(body);
    }

    @PutMapping("/{id}")
    public String delete(@PathVariable int id) {
        userService.deleteUser(id);
        return "Usuario eliminado";
    }
}
