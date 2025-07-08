package com.example.api_usuario.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.api_usuario.clients.EvaluacionClient;
import com.example.api_usuario.dto.EvaluacionDTO;
import com.example.api_usuario.http.response.EvaluacionByUserResponse;
import com.example.api_usuario.models.entities.User;
import com.example.api_usuario.models.requests.UserCreate;
import com.example.api_usuario.models.requests.UserUpdate;
import com.example.api_usuario.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EvaluacionClient evaluacionClient;

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
            newUser.setCourseId(user.getCourseId());

            return userRepository.save(newUser);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario Registrado: ");
        }
    }

    public String passwordHashing(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    //para tener una prueba de hasheo de contraseña
    public boolean testPassword(String hash, String password){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            return passwordEncoder.matches(password, hash);
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
        
        if(body.getCourseId() != 0) {
            user.setCourseId(body.getCourseId());
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

    public List<User> getByCourse(int courseId) {
        return userRepository.findAllByCourseId(courseId);
    }


    public EvaluacionByUserResponse findEvaluacionByIdUsuario(int idUsuario) {
        //consultar curso
        User user = userRepository.findById(idUsuario).orElse(null);

        //obtener usuarios
        //consultar microservicio de usuarios
        List<EvaluacionDTO> evaluacionDTOList = evaluacionClient.findAllEvaluationsByUser(idUsuario);

        return EvaluacionByUserResponse.builder()
            .name(user.getName())
            .lastName(user.getLastName())
            .secondLastName(user.getSecondLastName())
            .email(user.getEmail())
            .password(user.getPassword())
            .phone(user.getPhone())
            .city(user.getCity())
            .region(user.getRegion())
            .evaluacionDTOlist(evaluacionDTOList)
            .build();
    }


}
