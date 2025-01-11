package com.example.organizador_tareas.repository;

import com.example.organizador_tareas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
}
