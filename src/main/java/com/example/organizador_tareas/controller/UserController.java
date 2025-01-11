package com.example.organizador_tareas.controller;

import com.example.organizador_tareas.model.User;
import com.example.organizador_tareas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String logIn(@RequestParam String email, @RequestParam String password, Model model) {
        if (userService.logIn(email, password)) {
            return "redirect:/get/index";
        } else {
            model.addAttribute("error", "Credenciales incorrectas. Inténtalo de nuevo.");
            return "login";
        }
    }


    @PostMapping("/signup")
    public String signUp(@RequestParam String username, @RequestParam String email, @RequestParam String password, Model model) {
        if (userService.exists(username,email)) {
            model.addAttribute("error", "El usuario ya existe. Prueba con otro email.");
            return "signup";
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(password);

        userService.createUser(newUser);
        return "redirect:/get/login";
    }

//    @GetMapping("/{id}")
//    public Model getUserById(@PathVariable("id") Long id) {
//        User user = userService.findById(id).orElseThrow(() -> new RuntimeException("No existe usuario con el id " + id));
//
//        if (user != null) {
//            return user;
//        } else {
//            return ResponseEntity.status(401).body(null);
//        }
//
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<User> actualizarUsuario(@PathVariable Long id, @RequestBody User userActualizado) {
//        User user = userService.updateUser(id, userActualizado);
//        return ResponseEntity.ok(user);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
//        userService.removeUser(id);
//        return ResponseEntity.noContent().build();
//    }
}
