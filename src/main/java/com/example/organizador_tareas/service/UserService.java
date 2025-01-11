package com.example.organizador_tareas.service;

import com.example.organizador_tareas.model.User;
import com.example.organizador_tareas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public boolean logIn(String email, String password) {
        return userRepository.existsByEmailAndPassword(email, password);
    }

    public boolean exists(String username, String email) {
        return userRepository.existsByUsername(username) || userRepository.existsByEmail(email);
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Long id, User user) {
        User currentUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe usuario con el id " + id));
        currentUser.setUsername(user.getUsername());
        currentUser.setEmail(user.getEmail());
        currentUser.setPassword(user.getPassword());
        userRepository.save(currentUser);
    }

    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }

}
