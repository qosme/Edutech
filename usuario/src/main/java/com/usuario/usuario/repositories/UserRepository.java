package com.usuario.usuario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usuario.usuario.models.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Custom query methods can be defined here if needed
    // For example, findByEmail, findByName, etc.
    User findByEmail(String email);

}
