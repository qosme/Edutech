package com.usuario.usuario.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.usuario.usuario.models.entities.User;
import com.usuario.usuario.models.requests.UserCreate;
import com.usuario.usuario.models.requests.UserUpdate;
import com.usuario.usuario.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User register(UserCreate user){
        try {
            User newUser = new User();

            newUser.setCreatedAt(new Date());
            newUser.setIsActive(true);

            newUser.setName(user.getName());
            newUser.setLastName(user.getLastName());
            newUser.setSecondLastName(user.getSecondLastName());
            newUser.setEmail(user.getEmail());
            newUser.setPassword(user.getPassword());
            newUser.setPhone(user.getPhone());
            newUser.setCity(user.getCity());
            newUser.setRegion(user.getRegion());

            return userRepository.save(newUser);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario Registrado: ");
        }
    }

    public String passwordHashing(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    public User updateUser(UserUpdate body) {
        User user = userRepository.findById(body.getId()).orElse(null);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }

        if(body.getName() != null) {
            user.setName(body.getName());
        }

        if(body.getLastName() != null) {
            user.setLastName(body.getLastName());
        }

        if(body.getSecondLastName() != null) {
            user.setSecondLastName(body.getSecondLastName());
        }

        if(body.getPassword() != null) {
            user.setPassword(passwordHashing(body.getPassword()));
        }

        if(body.getPhone() != null) {
            user.setPhone(body.getPhone());
        }

        if(body.getCity() != null) {
            user.setCity(body.getCity());
        }

        if(body.getRegion() != null) {
            user.setRegion(body.getRegion());
        }

        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }
        userRepository.delete(user);
    }
}
