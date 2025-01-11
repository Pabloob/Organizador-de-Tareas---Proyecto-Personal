package com.example.organizador_tareas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/get")
public class GetController {

    @GetMapping("/login")
    public String mostrarLogin(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Credenciales incorrectas. Inténtalo de nuevo.");
        }
        return "login";
    }

    @GetMapping("/signup")
    public String mostrarSignup() {
        return "signup";
    }

    @GetMapping("/index")
    public String mostrarIndex() {
        return "index";
    }
}
